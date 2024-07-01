package com.composables.composetheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.input.pointer.PointerIcon

internal val LocalPlatformPointer = staticCompositionLocalOf { PointerIcon.Default }
internal expect val PlatformPointerIcon: PointerIcon

/**
 * [PointerIcon] used to indicate the hovered item is interactive. The icon displayed depends on the platform the icon will be used on.
 *
 * For example, this will show a [PointerIcon.Hand] icon when used on web vs a [PointerIcon.Default] icon on desktop.
 */
val PointerIcon.Companion.PlatformPointer: PointerIcon
    @Composable get() {
        return LocalPlatformPointer.current
    }