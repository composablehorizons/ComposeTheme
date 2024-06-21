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
    implementation("com.composables:composetheme:1.1.0-alpha")
    // includes extensions for material 3 compose
    implementation ("com.composables:composetheme-material3:1.1.0-alpha")
    // includes extensions for material compose
    implementation ("com.composables:composetheme-material:1.1.0-alpha")
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

## Theming Basics (How to theme your app in < 30 seconds)

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
    colors = DesignTokens(
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

> [!WARNING]  
> It is not currently possible to override the default tokens of the default properties

## Define your own design properties (ie adding transition speed)

1. Create a new `DesignProperty` for every new property you need. Design Properties can contain any type:

```kotlin
val transitions = DesignProperty<Transitions>("transitions")

@Immutable
data class Transitions(
    val fast: Int,
    val faster: Int
)
```

2. Use the new property while setting up your theme:

```kotlin
val Theme = buildComposeTheme { 
    properties[transition] = Transitions(
        fast = 200, 
        faster = 300
    )
}
```

3. Wrap your content with the `Theme` function and use the `ComposeTheme` object to get the respective property when you
   need it:

```kotlin
@Composable
fun App() {
    Theme {
        val animationSpeed = ComposeTheme[transition].fast 
        // ...
    }
}
```

## Extend ComposeTheme with existing design systems

Let's assume you have an `ExistingTheme` composable function that uses one or more `CompositionLocalProvider` that push down the Compose tree styling properties. You probably also have a respective `ExistingTheme` object with extension functions that get the respective `CompositionLocal.current` value. You also use this `ExistingTheme` object across your codebase to style your components.

You can extend your Compose Theme to use other design systems using the `extend` function. 

This will cause the children of the created theme composable to have access to any `CompositionLocal`, provided by your provided.

You can now use Compose Theme to easily build flexible themes, while the rest of your code base stays unmodified:

```kotlin
val ComposeThemeExtended = buildComposeTheme {
    extend { content ->
        ExistingTheme {
            content()
        }
    }
}
```

### Extend using Material 3 Compose & Material Compose 

Working with Material Compose can be painful as it does not let you add new colors easily. At the same time your components wrap the Material Compose components, which are styled using `MaterialTheme`, which leaves you to a dead end.

Compose Theme makes it simple to build new themes using existing Material Compose theme setups using the `composetheme-material3` and `composetheme-material` modules.

These modules add the respective `extendMaterial3` and `extendMaterial` functions that you can use to extend your new theme using Material Design. 

They also add helpful extension functions to the `ComposeTheme` object, so that you can use `ComposeTheme.colorScheme.primary` or `ComposeTheme.typography.bodyLarge` instead of the respective `MaterialTheme` counterpart.

This gives you both the flexibility to create fully custom themes with any kind of design properties and tokens, while allowing you to continue using the components from Material Compose libraries:

```kotlin
val buttonLabel = DesignToken<TextStyle>("buttonLabel")

val Material3ThemeExtended = buildComposeTheme {
    textStyles = DesignTokens(
       buttonLabel to TextStyle(fontSize = 12.sp, lineHeight = 16.sp)
    )

   extendMaterial3 {
      colorScheme = lightColorScheme(
         primary = Color.Red,
      )
      typography = Typography()
      shapes = Shapes()
   }
}

@Composable
fun App() {
   Material3ThemeExtended {  
      Button(onClick = { }) { // this button is rendered Red
         Text("Click me!", style = ComposeTheme.textStyles[buttonLabel])
      }
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
    colors = DesignTokens(
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

this will throw an error with the following message:
`
Tried to access the value of the token called primary, but no tokens with that name are defined within the colors property. You probably forgot to set a primary token in your theme definition. The resolved theme was DarkTheme
`

## Contributing

We are currently accepting contributions in the form of bug reports and feature requests, in the form of Github issues.