package com.composables.composetheme

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.text.TextStyle


/**
 * An object which can be used to get values from the currently resolved theme.
 *
 * @see buildComposeTheme
 */
object ComposeTheme

data class DesignProperty<T>(val name: String)
data class DesignToken<T>(val name: String)

typealias ThemeComposable = @Composable (@Composable () -> Unit) -> Unit

/**
 * Returns a [Composable] function that can be used to style your application.
 *
 * You can then use the [ComposeTheme] object within your wrapped content to get the values mapped to respective [DesignToken]s.
 *
 * Here is an example that defines and uses custom colors:
 * ```kotlin
 * // define your color tokens
 * val content = DesignToken<Color>("content")
 * val background = DesignToken<Color>("background")
 *
 * // use the tokens in your theme
 * val AppTheme = buildComposeTheme {
 *     colors = mapOf(
 *         content to Color(0xFF212121),
 *         background to Color(0xFFFAFAFA),
 *     )
 * }
 *
 * // use the ComposeTheme object to use the tokens in runtime
 * @Composable
 * fun App() {
 *     AppTheme {
 *         Box(Modifier.background(ComposeTheme.colors[background]).fillMaxSize()) {
 *             BasicText("The is a styled example", style = TextStyle(color = ComposeTheme.colors[content]))
 *         }
 *     }
 * }
 * ```
 *
 */
fun buildComposeTheme(themeBuilder: ThemeBuilder.() -> Unit): ThemeComposable {
    val builder = ThemeBuilder().apply(themeBuilder)

    val allProperties = mapOf(
        _colors to DesignTokens(_colors.name, builder.colors.entries + DefaultComposeTheme.colors.entries), _textStyles to DesignTokens(_textStyles.name, builder.textStyles.entries + DefaultComposeTheme.textStyles.entries), _shapes to DesignTokens(_shapes.name, builder.shapes.entries + DefaultComposeTheme.shapes.entries)
    ) + builder.properties.entries

    val theme = ResolvedTheme(builder.name, builder.indication, allProperties, builder.themeWrapper)

    return { content ->
        CompositionLocalProvider(LocalTheme provides theme, LocalIndication provides builder.indication, content = {
            theme.Extend(content)
        })
    }
}

internal object DefaultIndication : Indication {

    private class DefaultDebugIndicationInstance(
        private val isPressed: State<Boolean>,
        private val isHovered: State<Boolean>,
        private val isFocused: State<Boolean>,
    ) : IndicationInstance {
        override fun ContentDrawScope.drawIndication() {
            drawContent()
            if (isPressed.value) {
                drawRect(color = Color.Black.copy(alpha = 0.1f), size = size)
            } else if (isHovered.value || isFocused.value) {
                drawRect(color = Color.Black.copy(alpha = 0.05f), size = size)
            }
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()
        val isHovered = interactionSource.collectIsHoveredAsState()
        val isFocused = interactionSource.collectIsFocusedAsState()
        return remember(interactionSource) {
            DefaultDebugIndicationInstance(isPressed, isHovered, isFocused)
        }
    }
}

internal class ResolvedTheme(
    internal val name: String = "ComposeTheme", internal val indication: Indication, private val properties: Map<DesignProperty<*>, Any> = emptyMap(), internal val Extend: ThemeComposable
) {
    @Suppress("UNCHECKED_CAST")
    fun <T> getProperty(property: DesignProperty<T>): T? {
        return properties[property] as? T
    }
}

internal val LocalTheme = staticCompositionLocalOf<ResolvedTheme> { error("No theme was set. In order to use the ComposeTheme object you need to wrap your content with a theme @Composable returned by the buildComposeTheme {} function.") }

@Immutable
data class DesignTokens<T> internal constructor(internal val propertyName: String, internal val entries: Map<DesignToken<T>, T>) {
    @Composable
    @ReadOnlyComposable
    operator fun get(token: DesignToken<T>): T {
        val value = entries[token]
        if (value == null) {
            val theme = LocalTheme.current.name
            error("Tried to access the value of the token called ${token.name}, but no tokens with that name are defined within the $propertyName property. You probably forgot to set a ${token.name} token in your theme definition. The resolved theme was $theme")
        }
        return value
    }
}

fun <T> DesignTokens(pair: Pair<DesignToken<T>, T>): DesignTokens<T> {
    return DesignTokens(entries = mapOf(pair), propertyName = "")
}

fun <T> DesignTokens(vararg pairs: Pair<DesignToken<T>, T>): DesignTokens<T> {
    return DesignTokens(entries = pairs.toMap(), propertyName = "")
}

fun <T> DesignTokens(pairs: List<Pair<DesignToken<T>, T>>): DesignTokens<T> {
    return DesignTokens(entries = pairs.toMap(), propertyName = "")
}

fun <T> DesignTokens(pairs: Map<DesignToken<T>, T>): DesignTokens<T> {
    return DesignTokens(entries = pairs, propertyName = "")
}

@Composable
@ReadOnlyComposable
operator fun <T> ComposeTheme.get(property: DesignProperty<T>): T {
    val theme = LocalTheme.current
    return theme.getProperty(property) ?: error(
        "There is no ${property.name} design property in the ${theme.name} theme. To fix this:" + "\n1. Create a design property: val ${property.name} = DesignProperty<Type>(\"${property.name}\")\n2. Pass it to your theme definition: buildComposeTheme { properties -> properties[${property.name}] = TODO(\"Populate token values\") }"
    )
}

@DslMarker
annotation class ThemeBuilderMarker

@ThemeBuilderMarker
class ThemeBuilder internal constructor() {
    /**
     * The name of the theme. Useful for debugging purposes.
     */
    var name: String = "ComposeTheme"

    var indication: Indication = DefaultIndication

    var colors: DesignTokens<Color> = DefaultComposeTheme.colors
    var textStyles: DesignTokens<TextStyle> = DefaultComposeTheme.textStyles
    var shapes: DesignTokens<Shape> = DefaultComposeTheme.shapes

    val properties = MutableThemeProperties()

    internal var themeWrapper: ThemeComposable = { content -> content() }

    /**
     * Allows the integration with other design systems.
     * @param themeWrapper a composable function that wraps the theme composable of the other design system
     */
    fun extend(themeWrapper: ThemeComposable) {
        this.themeWrapper = themeWrapper
    }
}

class MutableThemeProperties internal constructor() {
    internal val entries = mutableMapOf<DesignProperty<*>, Any>()

    operator fun <T> set(property: DesignProperty<DesignTokens<T>>, value: DesignTokens<T>) {
        entries[property] = DesignTokens(propertyName = property.name, entries = value.entries) as Any
    }

    operator fun <T> set(property: DesignProperty<T>, value: T) {
        entries[property] = value as Any
    }
}
