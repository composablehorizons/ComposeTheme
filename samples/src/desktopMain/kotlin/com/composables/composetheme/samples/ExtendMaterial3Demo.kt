package com.composables.composetheme.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.composables.composetheme.*
import com.composables.composetheme.material3.colorScheme
import com.composables.composetheme.material3.extendMaterial3
import com.composables.composetheme.material3.extraLarge

/**
 * Showcases how to use ComposeTheme in combination with the Material Compose 3 design system.
 *
 * Here we extend the current theme with the properties and design tokens of Material 3, [ColorScheme], [Typography], and [Shapes].
 *
 * This will cause the contents of the created Theme composable to be themed after Material 3 (as if you would wrap your content using the [MaterialTheme] function).
 *
 *  It also adds the related extension functions to the [ComposeTheme] object, so that you can use [ComposeTheme.colorScheme.primary] instead of [MaterialTheme.colorScheme.primary], etc.
 *
 * Requires the `composetheme-material3` dependency
 */





val Material3ThemeExtended = buildComposeTheme {
    extendMaterial3 {
        colorScheme = lightColorScheme(
            primary = Color(0xFFE91E63),
            onPrimary = Color.White
        )
        typography = Typography()
        shapes = Shapes()
    }
}

@Composable
fun ExtendMaterial3Demo() {
    Material3ThemeExtended {
        Box(Modifier.fillMaxSize().background(ComposeTheme.colorScheme.background)) {
            Button(onClick = { }, shape = ComposeTheme.shapes.extraLarge) {
                Text("Click me")
            }
        }
    }
}

