package com.composables.composetheme.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composables.composetheme.ComposeTheme
import com.composables.composetheme.buildComposeTheme
import com.composables.composetheme.colors
import com.composables.composetheme.material.background
import com.composables.composetheme.material.extendMaterial

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

