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
fun buildComposeTheme(themeBuilder: ThemeBuilder.(ThemeProperties) -> Unit): ThemeComposable {
    val themeProperties = ThemeProperties()
    val theme = ThemeBuilder(themeProperties).apply {
        themeBuilder(themeProperties)
    }.build()
    return { content ->
        CompositionLocalProvider(
            LocalTheme provides theme,
            LocalIndication provides theme.indication,
        ) {
            content()
        }
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
    internal val name: String = "ComposeTheme", internal val indication: Indication, private val properties: Map<DesignProperty<*>, DesignTokens<*>> = emptyMap()
) {
    @Suppress("UNCHECKED_CAST")
    fun <T> getProperty(property: DesignProperty<T>): DesignTokens<T>? {
        return properties[property] as? DesignTokens<T>
    }
}

internal val LocalTheme = staticCompositionLocalOf<ResolvedTheme> { error("No theme was set. In order to use the ComposeTheme object you need to wrap your content with a theme @Composable returned by the buildComposeTheme {} function.") }

data class DesignTokens<T>(private val propertyName: String, private val tokens: Map<DesignToken<T>, T>) {
    @Composable
    @ReadOnlyComposable
    operator fun get(token: DesignToken<T>): T {
        val value = tokens[token]
        if (value == null) {
            val theme = LocalTheme.current.name
            error("Tried to access the value of the token called ${token.name}, but no tokens with that name are defined within the $propertyName property. You probably forgot to set a ${token.name} token in your theme definition. The resolved theme was $theme")
        }
        return value
    }
}


@Composable
@ReadOnlyComposable
operator fun <T> ComposeTheme.get(property: DesignProperty<T>): DesignTokens<T> {
    val theme = LocalTheme.current
    return theme.getProperty(property) ?: error(
        "There is no ${property.name} design property in the ${theme.name} theme. To fix this:" + "\n1. Create a design property: val ${property.name} = DesignProperty<Type>(\"${property.name}\")\n2. Pass it to your theme definition: buildComposeTheme { properties -> properties[${property.name}] = TODO(\"Map tokens to values\") }"
    )
}

class ThemeBuilder internal constructor(private val extraProperties: ThemeProperties) {
    /**
     * The name of the theme. Useful for debugging purposes.
     */
    var name: String = "ComposeTheme"

    var indication: Indication = DefaultIndication

    var colors: Map<DesignToken<Color>, Color> = DefaultComposeTheme.colors
    var textStyles: Map<DesignToken<TextStyle>, TextStyle> = DefaultComposeTheme.textStyles
    var shapes: Map<DesignToken<Shape>, Shape> = DefaultComposeTheme.shapes

    internal fun build(): ResolvedTheme {
        val allProperties: Map<DesignProperty<*>, DesignTokens<*>> = mapOf(
            _colors to DesignTokens("colors", colors + DefaultComposeTheme.colors),
            _textStyles to DesignTokens("textStyles", textStyles + DefaultComposeTheme.textStyles),
            _shapes to DesignTokens("shapes", shapes + DefaultComposeTheme.shapes)
        ) + extraProperties.entries

        return ResolvedTheme(
            name, indication, allProperties
        )
    }
}

class ThemeProperties internal constructor() {
    internal val entries = mutableMapOf<DesignProperty<*>, DesignTokens<*>>()
    operator fun <T> set(property: DesignProperty<T>, value: Map<DesignToken<T>, T>) {
        entries[property] = DesignTokens(property.name, value)
    }
}