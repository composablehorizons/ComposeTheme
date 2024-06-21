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

val background1 = DesignToken<Color>("background1")

val Material3ThemeExtended = buildComposeTheme {
    colors = DesignTokens(
        background1 to Color.Blue
    )
    extendMaterial3 {
        colorScheme = lightColorScheme(
            primary = Color.Red
        )
        typography = Typography()
        shapes = Shapes()
    }
}

@Composable
fun ExtendMaterial3Demo() {
    Material3ThemeExtended {
        Box(Modifier.fillMaxSize().background(ComposeTheme.colors[background1])) {
            Button(onClick = { }, shape = ComposeTheme.shapes.extraLarge) {
                Text("Click me")
            }
        }
    }
}

