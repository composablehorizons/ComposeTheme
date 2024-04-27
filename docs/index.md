---
title: The API to your Compose Design System
description: Build beautiful Compose apps quickly
---

<div style="margin: 40px; display: flex; flex-direction: column; justify-content: center; align-items: center; gap: 8px">
    <div style="width: 100%; display: flex; flex-direction: row; justify-content: center; align-items: center; height: 100%; gap: 8px">
        <svg style="color: #E91E63" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-brush"><path d="m9.06 11.9 8.07-8.06a2.85 2.85 0 1 1 4.03 4.03l-8.06 8.08"/><path d="M7.07 14.94c-1.66 0-3 1.35-3 3.02 0 1.33-2.5 1.52-2 2.02 1.08 1.1 2.49 2.02 4 2.02 2.2 0 4-1.8 4-4.04a3.01 3.01 0 0 0-3-3.02z"/></svg>
        <h1 style="color: black; font-size: 42px; font-weight: 500; margin: 0">Compose Theme</h1>
        </div>
    <span style="text-align: center; color: #454545; font-size: 22px">The API to your Compose Design System</span>
</div>


Compose Theme is an API that enables you to quickly implement your very own Design System in Jetpack Compose and Compose Multiplatform.

## An API, not a Design System

Compose Theme provides you with the API to build your design system with. It does not come with a set of components that
require specific design tokens or theming properties in order to be rendered.

Instead, it gives you a flexible way to define your own design tokens and properties which are easily accessible from your
composables.

As a result, you have full control of how your app and API looks like.

## Beautiful Defaults

Compose Theme provides you a set of defaults that you can use such as a colors, text styles and shapes. 

You can use them as is, or use them as a base for your own design system.

```kotlin
@Composable
fun MyTextComposable(text: String) {
    BasicText(text = text, style = ComposeTheme.textStyles.base)
}
```

## Flexibility to the core

Your app is unique and has its own unique design requirements. Compose Theme makes it super simple to extend the default design properties and even define your very own.

```kotlin
// define a primary color
val primary = DesignToken<Color>("primary")

val transitions = DesignProperty<Duration>("transition")

val normal = DesignToken<Int>("normal")
val fast = DesignToken<Int>("fast")
val faster = DesignToken<Int>("faster")

val AnimatedTheme = buildComposeTheme { properties ->
    
    // define a new color token
    colors = mapOf(
        primary to Color(0xFFE91E63)
    )
    
    // define a new design property
    properties[transitions] = mapOf(
        normal to 300,
        fast to 200,
        faster to 100
    )
}

@Composable
fun App() {
    AnimatedTheme {
        var enabled by remember { mutableStateOf(true) }

        val alpha by animateFloatAsState(if (enabled) 1f else 0.5f, 
            animationSpec = tween(durationMillis = ComposeTheme[transitions][fast])
        )
        Box(
            Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = alpha)
                .background(ComposeTheme.colors[primary])
        )
    }
}
```
