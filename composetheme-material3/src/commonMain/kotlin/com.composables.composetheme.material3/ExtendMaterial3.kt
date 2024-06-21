@file:Suppress("ObjectPropertyName", "unused")

package com.composables.composetheme.material3

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Shape
import com.composables.composetheme.*

/**
 * Includes all of Material 3 Compose's [MaterialTheme] design properties to the given [ComposeTheme].
 *
 *
 * This will cause the children of the created Theme Composable to have.
 *
 * It also enables the usage of [MaterialTheme] related extension functions to be used via [ComposeTheme],
 * such as `ComposeTheme.colorScheme.primary` or `ComposeTheme.typography.bodyLarge`
 */
fun ThemeBuilder.extendMaterial3(themeBuilder: Material3ThemeBuilder.() -> Unit) {
    val theme = Material3ThemeBuilder().apply(themeBuilder)

    properties[_colorScheme] = theme.colorScheme
    properties[_typography] = theme.typography

    shapes = DesignTokens(
        _extraSmall to theme.shapes.extraSmall,
        _small to theme.shapes.small,
        _medium to theme.shapes.medium,
        _large to theme.shapes.large,
        _extraLarge to theme.shapes.extraLarge,
    )

    extend { content ->
        MaterialTheme(
            colorScheme = theme.colorScheme, shapes = theme.shapes, typography = theme.typography, content = content
        )
    }
}


class Material3ThemeBuilder {
    var colorScheme: ColorScheme = lightColorScheme()
    var typography: Typography = Typography()
    var shapes: Shapes = Shapes()
}

private val _colorScheme = DesignProperty<ColorScheme>("colorScheme")
private val _typography = DesignProperty<Typography>("typography")

private val _extraSmall = DesignToken<Shape>("extraSmall")
private val _small = DesignToken<Shape>("small")
private val _medium = DesignToken<Shape>("medium")
private val _large = DesignToken<Shape>("large")
private val _extraLarge = DesignToken<Shape>("extraLarge")

val ComposeTheme.colorScheme: ColorScheme
    @Composable @ReadOnlyComposable get() = this[_colorScheme]
val ComposeTheme.typography: Typography
    @Composable @ReadOnlyComposable get() = this[_typography]
val DesignTokens<Shape>.extraSmall: Shape
    @Composable @ReadOnlyComposable get() = this[_extraSmall]
val DesignTokens<Shape>.small: Shape
    @Composable @ReadOnlyComposable get() = this[_small]
val DesignTokens<Shape>.medium: Shape
    @Composable @ReadOnlyComposable get() = this[_medium]
val DesignTokens<Shape>.large: Shape
    @Composable @ReadOnlyComposable get() = this[_large]
val DesignTokens<Shape>.extraLarge: Shape
    @Composable @ReadOnlyComposable get() = this[_extraLarge]