@file:Suppress("ObjectPropertyName", "unused")

package com.composables.composetheme.material

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.composables.composetheme.*


/**
 * Includes all of Material Compose [MaterialTheme] design properties to the given [ComposeTheme].
 *
 *
 * This will cause the children of the created Theme Composable to have.
 *
 * It also enables the usage of [MaterialTheme] related extension functions to be used via [ComposeTheme],
 * such as `ComposeTheme.colors.primary` or `ComposeTheme.typography.h6`
 */
fun ThemeBuilder.extendMaterial(themeBuilder: MaterialThemeBuilder.() -> Unit) {
    val theme = MaterialThemeBuilder().apply(themeBuilder)

    with(theme.colors) {
        colors = DesignTokens(
            _primary to primary,
            _primaryVariant to primaryVariant,
            _onPrimary to onPrimary,
            _secondary to secondary,
            _secondaryVariant to secondaryVariant,
            _onSecondary to onSecondary,
            _background to background,
            _onBackground to onBackground,
            _surface to surface,
            _onSurface to onSurface,
            _error to error,
            _onError to onError,
        )
    }
    with(theme.shapes) {
        shapes = DesignTokens(
            _small to small,
            _medium to medium,
            _large to large,
        )
    }

    properties[_typography] = theme.typography

    extend { content ->
        MaterialTheme(
            colors = theme.colors, shapes = theme.shapes, typography = theme.typography, content = content
        )
    }
}

class MaterialThemeBuilder {
    var colors: Colors = lightColors()
    var typography: Typography = Typography()
    var shapes: Shapes = Shapes()
}

private val _primary = DesignToken<Color>("primary")
private val _primaryVariant = DesignToken<Color>("primaryVariant")
private val _onPrimary = DesignToken<Color>("onPrimary")
private val _secondary = DesignToken<Color>("secondary")
private val _secondaryVariant = DesignToken<Color>("secondaryVariant")
private val _onSecondary = DesignToken<Color>("onSecondary")
private val _background = DesignToken<Color>("background")
private val _onBackground = DesignToken<Color>("onBackground")
private val _surface = DesignToken<Color>("surface")
private val _onSurface = DesignToken<Color>("onSurface")
private val _error = DesignToken<Color>("error")
private val _onError = DesignToken<Color>("onError")

private val _typography = DesignProperty<Typography>("typography")
private val _h1 = DesignToken<TextStyle>("h1")
private val _h2 = DesignToken<TextStyle>("h2")
private val _h3 = DesignToken<TextStyle>("h3")
private val _h4 = DesignToken<TextStyle>("h4")
private val _h5 = DesignToken<TextStyle>("h5")
private val _h6 = DesignToken<TextStyle>("h6")
private val _subtitle1 = DesignToken<TextStyle>("subtitle1")
private val _subtitle2 = DesignToken<TextStyle>("subtitle2")
private val _body1 = DesignToken<TextStyle>("body1")
private val _body2 = DesignToken<TextStyle>("body2")
private val _button = DesignToken<TextStyle>("button")
private val _caption = DesignToken<TextStyle>("caption")
private val _overline = DesignToken<TextStyle>("overline")

private val _small = DesignToken<Shape>("small")
private val _medium = DesignToken<Shape>("medium")
private val _large = DesignToken<Shape>("large")

val ComposeTheme.typography: Typography
    @Composable @ReadOnlyComposable get() {
        return this[_typography]
    }

val DesignTokens<TextStyle>.h1: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h1]
val DesignTokens<TextStyle>.h2: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h2]
val DesignTokens<TextStyle>.h3: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h3]
val DesignTokens<TextStyle>.h4: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h4]
val DesignTokens<TextStyle>.h5: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h5]
val DesignTokens<TextStyle>.h6: TextStyle
    @Composable @ReadOnlyComposable get() = this[_h6]
val DesignTokens<TextStyle>.subtitle1: TextStyle
    @Composable @ReadOnlyComposable get() = this[_subtitle1]
val DesignTokens<TextStyle>.subtitle2: TextStyle
    @Composable @ReadOnlyComposable get() = this[_subtitle2]
val DesignTokens<TextStyle>.body1: TextStyle
    @Composable @ReadOnlyComposable get() = this[_body1]
val DesignTokens<TextStyle>.body2: TextStyle
    @Composable @ReadOnlyComposable get() = this[_body2]
val DesignTokens<TextStyle>.button: TextStyle
    @Composable @ReadOnlyComposable get() = this[_button]
val DesignTokens<TextStyle>.caption: TextStyle
    @Composable @ReadOnlyComposable get() = this[_caption]
val DesignTokens<TextStyle>.overline: TextStyle
    @Composable @ReadOnlyComposable get() = this[_overline]

val DesignTokens<Shape>.small: Shape
    @Composable @ReadOnlyComposable get() = this[_small]
val DesignTokens<Shape>.medium: Shape
    @Composable @ReadOnlyComposable get() = this[_medium]
val DesignTokens<Shape>.large: Shape
    @Composable @ReadOnlyComposable get() = this[_large]

val DesignTokens<Color>.primary: Color
    @Composable @ReadOnlyComposable get() = this[_primary]
val DesignTokens<Color>.primaryVariant: Color
    @Composable @ReadOnlyComposable get() = this[_primaryVariant]
val DesignTokens<Color>.onPrimary: Color
    @Composable @ReadOnlyComposable get() = this[_onPrimary]
val DesignTokens<Color>.secondary: Color
    @Composable @ReadOnlyComposable get() = this[_secondary]
val DesignTokens<Color>.secondaryVariant: Color
    @Composable @ReadOnlyComposable get() = this[_secondaryVariant]
val DesignTokens<Color>.onSecondary: Color
    @Composable @ReadOnlyComposable get() = this[_onSecondary]
val DesignTokens<Color>.background: Color
    @Composable @ReadOnlyComposable get() = this[_background]
val DesignTokens<Color>.onBackground: Color
    @Composable @ReadOnlyComposable get() = this[_onBackground]
val DesignTokens<Color>.surface: Color
    @Composable @ReadOnlyComposable get() = this[_surface]
val DesignTokens<Color>.onSurface: Color
    @Composable @ReadOnlyComposable get() = this[_onSurface]
val DesignTokens<Color>.error: Color
    @Composable @ReadOnlyComposable get() = this[_error]
val DesignTokens<Color>.onError: Color
    @Composable @ReadOnlyComposable get() = this[_onError]