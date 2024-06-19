package com.composables.composetheme.samples

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.composables.composetheme.ComposeTheme
import com.composables.composetheme.DesignToken
import com.composables.composetheme.buildComposeTheme
import com.composables.composetheme.colors

val accent = DesignToken<Color>("accent")
val text = DesignToken<Color>("text")

val NewTheme = buildComposeTheme {
    colors = mapOf(
        accent to Color.Yellow,
        text to Color.Yellow,
    )
}

@Composable
fun UsingWithMaterialDemo() {
    NewTheme {
        CustomButton(onClick = {}) {
            BasicText("Click me")
        }
    }
}

@Composable
fun CustomButton(onClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    androidx.compose.material3.Button(
        onClick = onClick,
        content = content,
        colors = ButtonColors(
            containerColor = ComposeTheme.colors[accent],
            disabledContainerColor = ComposeTheme.colors[accent].copy(alpha = 0.33f),
            contentColor = ComposeTheme.colors[text],
            disabledContentColor = ComposeTheme.colors[text].copy(alpha = 0.33f)
        )
    )
}