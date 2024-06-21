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
import kotlinx.coroutines.delay

val content = DesignToken<Color>("content")
val background = DesignToken<Color>("background")

val transitions = DesignProperty<Transitions>("transitions")

@Immutable
data class Transitions(val fast: Int)

val AppTheme = buildComposeTheme {
    colors = DesignTokens(
        content to Color(0xFF212121),
        background to Color(0xFFFAFAFA),
    )
    properties[transitions] = Transitions(fast = 200)
}

@Composable
fun CustomPropertiesDemo() {
    AppTheme {
        var enabled by remember { mutableStateOf(true) }

        LaunchedEffect(Unit) {
            delay(1000)
            enabled = !enabled
        }

        val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f, animationSpec = tween(durationMillis = ComposeTheme[transitions].fast))
        Box(Modifier.fillMaxSize().graphicsLayer(alpha = alpha).background(ComposeTheme.colors.blue400))
    }
}
