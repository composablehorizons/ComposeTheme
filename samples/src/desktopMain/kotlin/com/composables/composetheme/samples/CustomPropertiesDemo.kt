package com.composables.composetheme.samples

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.composables.composetheme.*

val content = DesignToken<Color>("content")
val background = DesignToken<Color>("background")

val transitions = DesignProperty<Int>("background")
val fast = DesignToken<Int>("background")

val AppTheme = buildComposeTheme {
    colors = mapOf(
        content to Color(0xFF212121),
        background to Color(0xFFFAFAFA),
    )
}

@Composable
fun CustomPropertiesDemo() {
    AppTheme {
        var enabled by remember { mutableStateOf(true) }

        val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f, animationSpec = tween(durationMillis = ComposeTheme[transitions][fast]))
        Box(
            Modifier.fillMaxSize().graphicsLayer(alpha = alpha).background(ComposeTheme.colors.blue400)
        )
    }
}
