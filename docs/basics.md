---
title: Theming Basics
description: Learn how to use Compose Theme to create and use custom themes.
---

<p>Learn how to use Compose Theme to create and use custom themes.</p>

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