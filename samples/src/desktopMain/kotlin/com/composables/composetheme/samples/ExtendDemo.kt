package com.composables.composetheme.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.composables.composetheme.*

private val brand = DesignToken<Color>("brand")

/**
 * Showcases how to use ComposeTheme in combination with other existing themes.
 *
 * The [ExtendedTheme] is a copy-pasted from the official Jetpack Compose [Extending Material Theme](https://developer.android.com/develop/ui/compose/designsystems/custom#extending-material) demo.
 *
 * This way you get the flexibility of ComposeTheme without rewriting or throwing away your existing design system
 */
val ComposeThemeExtended = buildComposeTheme {
    colors = DesignTokens(
        brand to Color(0xFFFAFAFA)
    )
    extend { content ->
        ExtendedTheme {
            content()
        }
    }
}

@Immutable
data class ExtendedColors(
    val tertiary: Color, val onTertiary: Color
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        tertiary = Color.Unspecified, onTertiary = Color.Unspecified
    )
}

@Composable
fun ExtendedTheme(content: @Composable () -> Unit) {
    val extendedColors = ExtendedColors(
        tertiary = Color(0xFFA8EFF0), onTertiary = Color(0xFF002021)
    )
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(/* colors = ..., typography = ..., shapes = ... */
            content = content
        )
    }
}

// Use with eg. ExtendedTheme.colors.tertiary
object ExtendedTheme {
    val colors: ExtendedColors
        @Composable get() = LocalExtendedColors.current
}

@Composable
fun ExtendDemo() {
    // using ExtendedComposeTheme instead of MaterialExtendedTheme enables you to use both ComposeTheme & MaterialExtendedTheme objects
    ComposeThemeExtended {
        Box(Modifier.fillMaxSize().background(ComposeTheme.colors[brand])) {
            ExtendedButton(onClick = {}) {
                Text("Hello")
            }
        }
    }
}

@Composable
fun ExtendedButton(onClick: () -> Unit, modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = ExtendedTheme.colors.tertiary,
            contentColor = ExtendedTheme.colors.onTertiary
        ),
        onClick = onClick, modifier = modifier, content = content
    )
}