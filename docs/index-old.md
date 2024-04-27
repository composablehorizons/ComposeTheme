---
title: What is Compose Theme?
description: Build beautiful Compose apps quickly
---

<div style="margin: 40px; display: flex; flex-direction: column; justify-content: center; align-items: center; gap: 8px">
    <div style="width: 100%; display: flex; flex-direction: row; justify-content: center; align-items: center; height: 100%; gap: 8px">
        <svg style="color: #E91E63" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-brush"><path d="m9.06 11.9 8.07-8.06a2.85 2.85 0 1 1 4.03 4.03l-8.06 8.08"/><path d="M7.07 14.94c-1.66 0-3 1.35-3 3.02 0 1.33-2.5 1.52-2 2.02 1.08 1.1 2.49 2.02 4 2.02 2.2 0 4-1.8 4-4.04a3.01 3.01 0 0 0-3-3.02z"/></svg>
        <h1 style="color: black; font-size: 42px; font-weight: 500; margin: 0">Compose Theme</h1>
        </div>
    <span style="text-align: center; color: #454545; font-size: 22px">The API to your Compose Design System</span>
</div>


**Compose Theme** is an API that enables to quickly implement your very own Design System in Jetpack Compose and Compose
Multiplatform.

This page covers a Quick Start guide on how to create and use themes created using `Compose Theme`.

## Quick start

### Installation

```kotlin title="build.gradle.kts"
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.composables:composetheme:1.0.0")
}
```


## How to create and use a Compose Theme

There are two key pieces in creating themes using ComposeTheme:
the <span style="display: inline-block">`buildComposeTheme`</span> function and the `ComposeTheme` object.

### The `buildComposeTheme` function

This function returns a new `@Composable` Theme function that propagates the values of the theme down to its composable
children.

By default, the returned theme provides [beautiful defaults](#beautiful-defaults) to style your app with which can be
used a basis to your own design system. Those include colors, text styles and shapes.

You can customize your theme by defining your own design tokens and design properties. More on that
in [Customizing your Theme](#customizing-your-theme-with-custom-design-properties).

### The `ComposeTheme` object

This object is used to get the values of the current theme during runtime.

#### Accessing standard properties

Every default standard we provide comes with a helper extension function.

Here is an example of accessing colors:

```kotlin
val color = ComposeTheme.colors.red500
val textStyle = ComposeTheme.textStyle.base
val shape = ComposeTheme.shapes.round
```

#### Accessing custom properties

## Beautiful Defaults

Compose Theme comes with a beautiful set of defaults to help you get started building your own design system. You can
use those defaults as a base to your own system or use them as is.

You can access those defaults by using the respective extension function of the `ComposeTheme` object.

| Property    | Description                                                      | Type        | Example of usage               |
|-------------|------------------------------------------------------------------|-------------|--------------------------------| 
| Text Styles | Beautiful typography with predefined text sizes and line heights | `TextStyle` | `ComposeTheme.textStyles.base` |
| Colors      | A rich color palette with shades of standard colors              | `Color`     | `ComposeTheme.colors.red500`   |
| Shapes      | Shapes with rounded corners of different radius                  | `Shape`     | `ComposeTheme.shapes.round`    |

### Adding new colors, text styles and shapes

Design Systems often use what we call Design Tokens that correspond to specific values.

Here is an example of how to define a `content` and `background` color and use them in your app:

```kotlin
// define your design tokens
val content = DesignToken<Color>("content")
val background = DesignToken<Color>("background")

// link the tokens to values
val TokensTheme = buildComposeTheme {
    colors = mapOf(
        content to Color(0xFF212121),
        background to Color(0xFFFAFAFA),
    )
}

@Composable
fun App() {
    TokensTheme {
        Box(Modifier.background(ComposeTheme.colors[background])) {
            BasicText("Hello", style = TextStyle(color = ComposeTheme.colors[content]))
        }
    }
}
```

This same technique can be used to add your own custom `TextStyle`s and `Shape`s.

!!! note

    It is not currently possible to override the default tokens we provide, but you will be in a future release.

## Code Examples

### Customize your Theme with custom Design Properties

Design systems can get complex and different apps require different design properties. Compose Theme has been designed
in its core to handle any design system design.

Using custom

### Change themes dynamically (Dark Mode)
