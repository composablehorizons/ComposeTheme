<div align="center">
<h1><img src="./art/logo.svg"> Compose Theme</h1>
<span>The API to your Compose Design System</span>
</div>

## Installation

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.composables:composetheme:1.0.1-alpha")
}
```

## An API, not a Design System

Compose Theme provides you with the API to build your design system with. It does not come with a set of components that
require specific design tokens or theming properties in order to be rendered.

Instead, it gives you a flexible way to define your own design tokens and properties which are easily accessible from
your
composables.

As a result, you have full control over how your app and API looks like.

## Flexibility to the core

Your app is unique and has unique design requirements. Compose Theme makes it super simple to add new design tokens and
design properties to your themes, using the types you prefer.

## Beautiful defaults

Compose Theme provides you a set of defaults that you can use such as a `colors`, `textStyles` and `shapes`.

You can use them as is, or use them as a base for your own design system.

## Theming Basics (How to theme your app in < 60 seconds)

1. Use the `buildComposeTheme {}` function to create a new theme. This returns a theme `@Composable` function that we
   will use in a bit.

```kotlin
val MyTheme = buildComposeTheme { }
```

2. Use the returned `@Composable` function to wrap your Compose app:

```kotlin
@Composable
fun App() {
    MyTheme {
        BasicText("Hello Beautiful world!")
    }
}
```

3. Use the `ComposeTheme` object to use the properties of the currently resolved theme:

```kotlin
@Composable
fun App() {
    MyTheme {
        BasicText(text = "Hello Beautiful world!", style = ComposeTheme.textStyles.base)
    }
}
```

That's the gist. Keep reading to find out how to extend the default properties or even add your own.

### Using default properties (colors, text styles and shapes)

By default, themes provide you with 3 sets of properties: colors, text styles and shapes.

You can access those properties by using the respective extension functions on the `ComposeTheme` object like so:

```kotlin
val aColor = ComposeTheme.colors.red500

val aTextStyle = ComposeTheme.textStyles.base

val aShape = ComposeTheme.shapes.round
```

You can use those properties any way you like.

### Extending the default properties (adding more colors, text styles and shapes)

1. Create a new `DesignToken` for every new token you need:

```kotlin
val primary = DesignToken<Color>("primary")
val background = DesignToken<Color>("background")
```

2. Use the new tokens while setting up your theme and assign a respective value:

```kotlin
val Theme = buildComposeTheme {
    colors = mapOf(
        primary to Color.Red,
        background to Color.Gray,
    )
}
```

3. Wrap your content with the `Theme` function and use the `ComposeTheme` object to get the respective property when you
   need it:

```kotlin
@Composable
fun App() {
    Theme {
        Box(Modifier.fillMaxSize().background(ComposeTheme.colors[background])) {
            Box(Modifier.size(56.dp).background(ComposeTheme.colors[primary]))
        }
    }
}
```

## Define your own design properties (ie adding transition speed)

1. Create a new `DesignProperty` for every new property you need. Also crease a new `DesignToken` for each token this
   property contains:

```kotlin
val transition = DesignProperty<Int>("transition")

val fast = DesignToken<Int>("fast")
val faster = DesignToken<Int>("faster")
```

2. Use the new property and tokens while setting up your theme and assign a respective value:

```kotlin
val Theme = buildComposeTheme { properties ->
    properties[transition] = mapOf(
        fast to 200, faster to 300
    )
}
```

3. Wrap your content with the `Theme` function and use the `ComposeTheme` object to get the respective property when you
   need it:

```kotlin
@Composable
fun App() {
    Theme {
        val animationSpeed = ComposeTheme[transition][fast] // ...
    }
}
```

## Debugging (optional)

You can define a name to your theme. This is optional but recommended, especially when using multiple themes in your
app (ie light/dark or nesting themes)

This will include the name of the resolved theme in error logs, when you try to access an attribute or property that
does not exist in the current theme:

```kotlin
val primary = DesignToken<Color>("primary")

val LightTheme = buildComposeTheme {
    name = "LightTheme"
    colors = mapOf(
        primary to Color.Red
    )
}
val DarkTheme = buildComposeTheme {
    name = "DarkTheme"
}

@Composable
fun App() {
    val AppTheme = if (isSystemInDarkTheme()) DarkTheme else LightTheme

    AppTheme {
        val color = ComposeTheme.colors[primary] // 💥 error while using DarkTheme
    }
}
```

this will print:
`
Tried to access the value of the token called primary, but no tokens with that name are defined within the colors property. You probably forgot to set a primary token in your theme definition. The resolved theme was DarkTheme
`

## Contributing

We are currently accepting contributions in the form of bug reports and feature requests, in the form of Github issues.