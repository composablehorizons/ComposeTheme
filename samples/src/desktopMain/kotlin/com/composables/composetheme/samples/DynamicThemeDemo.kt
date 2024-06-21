package com.composables.composetheme.samples

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.composables.composetheme.*

private val brand = DesignToken<Color>("brand")

private val RedTheme = buildComposeTheme {
    name = "Red"
    colors = DesignTokens(
        brand to Color.Red
    )
}

private val BlueTheme = buildComposeTheme {
    name = "Blue"
    colors = DesignTokens(
        brand to Color.Blue
    )
}

@Composable
fun DynamicThemeDemo() {
    var useDarkTheme by remember { mutableStateOf(false) }
    val AppTheme = if (useDarkTheme) RedTheme else BlueTheme

    Column {
        AppTheme {
            Toggle(useDarkTheme, onToggled = { useDarkTheme = it })
            BasicText(text = "Outer Text", style = TextStyle(color = ComposeTheme.colors[brand]))
        }
    }
}

@Composable
private fun Toggle(toggled: Boolean, onToggled: (Boolean) -> Unit) {
    val offset by animateDpAsState(if (toggled) 18.dp else 0.dp)
    val backgroundColor by animateColorAsState(if (toggled) ComposeTheme.colors[brand] else Color(0xFFBDBDBD))

    Box(modifier = Modifier.clip(RoundedCornerShape(100)).background(backgroundColor).border(2.dp, Color.Black, RoundedCornerShape(100)).width(48.dp).toggleable(toggled, role = Role.Switch, onValueChange = onToggled)) {
        Box(Modifier.offset(x = offset).padding(4.dp).size(22.dp).shadow(2.dp, CircleShape).background(Color.White, CircleShape))
    }
}