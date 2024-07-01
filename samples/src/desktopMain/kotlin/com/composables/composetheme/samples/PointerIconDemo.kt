package com.composables.composetheme.samples

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import com.composables.composetheme.PlatformPointer

@Composable
fun PointerIconDemo() {
    BasicText(text = "Hover over me", modifier = Modifier.pointerHoverIcon(PointerIcon.PlatformPointer))
}