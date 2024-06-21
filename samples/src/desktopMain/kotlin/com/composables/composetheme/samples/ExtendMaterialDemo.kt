package com.composables.composetheme.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composables.composetheme.ComposeTheme
import com.composables.composetheme.buildComposeTheme
import com.composables.composetheme.colors
import com.composables.composetheme.material.background
import com.composables.composetheme.material.extendMaterial

/**
 * Showcases how to use ComposeTheme in combination with the Material Compose design system.
 *
 * Here we extend the current theme with the properties and design tokens of Material 3, [Colors], [Typography], and [Shapes].
 *
 * This will cause the contents of the created Theme composable to be themed after Material 3 (as if you would wrap your content using the [MaterialTheme] function).
 *
 *  It also adds the related extension functions to the [ComposeTheme] object, so that you can use [ComposeTheme.colors.primary] instead of [MaterialTheme.color.primary], etc.
 *
 * Requires the `composetheme-material` dependency
 */
val MaterialThemeExtended = buildComposeTheme {
    extendMaterial {
        colors = lightColors()
        typography = Typography()
        shapes = Shapes()
    }
}

@Composable
fun ExtendMaterialDemo() {
    MaterialThemeExtended {
        Box(Modifier.fillMaxSize().background(ComposeTheme.colors.background)) {
            Button(onClick = { }) {
                Text("Click me")
            }
        }
    }
}

