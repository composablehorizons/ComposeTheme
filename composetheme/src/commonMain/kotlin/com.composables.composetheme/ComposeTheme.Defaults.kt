package com.composables.composetheme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal val _colors = DesignProperty<Color>("colors")

internal val _textStyles = DesignProperty<TextStyle>("textStyles")
internal val _xs = DesignToken<TextStyle>("xs")
internal val _sm = DesignToken<TextStyle>("sm")
internal val _base = DesignToken<TextStyle>("base")
internal val _lg = DesignToken<TextStyle>("lg")
internal val _xl = DesignToken<TextStyle>("xl")
internal val _xl2 = DesignToken<TextStyle>("xl2")
internal val _xl3 = DesignToken<TextStyle>("xl3")
internal val _xl4 = DesignToken<TextStyle>("xl4")
internal val _xl5 = DesignToken<TextStyle>("xl5")

internal val _shapes = DesignProperty<Shape>("shapes")
internal val _round = DesignToken<Shape>("round")
internal val _roundL = DesignToken<Shape>("roundL")
internal val _roundXL = DesignToken<Shape>("roundXL")
internal val _roundXL2 = DesignToken<Shape>("roundXL2")
internal val _roundXL3 = DesignToken<Shape>("roundXL3")
internal val _full = DesignToken<Shape>("full")

internal val _red50 = DesignToken<Color>("red50")
internal val _red100 = DesignToken<Color>("red100")
internal val _red200 = DesignToken<Color>("red200")
internal val _red300 = DesignToken<Color>("red300")
internal val _red400 = DesignToken<Color>("red400")
internal val _red500 = DesignToken<Color>("red500")
internal val _red600 = DesignToken<Color>("red600")
internal val _red700 = DesignToken<Color>("red700")
internal val _red800 = DesignToken<Color>("red800")
internal val _red900 = DesignToken<Color>("red900")
internal val _pink50 = DesignToken<Color>("pink50")
internal val _pink100 = DesignToken<Color>("pink100")
internal val _pink200 = DesignToken<Color>("pink200")
internal val _pink300 = DesignToken<Color>("pink300")
internal val _pink400 = DesignToken<Color>("pink400")
internal val _pink500 = DesignToken<Color>("pink500")
internal val _pink600 = DesignToken<Color>("pink600")
internal val _pink700 = DesignToken<Color>("pink700")
internal val _pink800 = DesignToken<Color>("pink800")
internal val _pink900 = DesignToken<Color>("pink900")
internal val _purple50 = DesignToken<Color>("purple50")
internal val _purple100 = DesignToken<Color>("purple100")
internal val _purple200 = DesignToken<Color>("purple200")
internal val _purple300 = DesignToken<Color>("purple300")
internal val _purple400 = DesignToken<Color>("purple400")
internal val _purple500 = DesignToken<Color>("purple500")
internal val _purple600 = DesignToken<Color>("purple600")
internal val _purple700 = DesignToken<Color>("purple700")
internal val _purple800 = DesignToken<Color>("purple800")
internal val _purple900 = DesignToken<Color>("purple900")
internal val _blue50 = DesignToken<Color>("blue50")
internal val _blue100 = DesignToken<Color>("blue100")
internal val _blue200 = DesignToken<Color>("blue200")
internal val _blue300 = DesignToken<Color>("blue300")
internal val _blue400 = DesignToken<Color>("blue400")
internal val _blue500 = DesignToken<Color>("blue500")
internal val _blue600 = DesignToken<Color>("blue600")
internal val _blue700 = DesignToken<Color>("blue700")
internal val _blue800 = DesignToken<Color>("blue800")
internal val _blue900 = DesignToken<Color>("blue900")
internal val _green50 = DesignToken<Color>("green50")
internal val _green100 = DesignToken<Color>("green100")
internal val _green200 = DesignToken<Color>("green200")
internal val _green300 = DesignToken<Color>("green300")
internal val _green400 = DesignToken<Color>("green400")
internal val _green500 = DesignToken<Color>("green500")
internal val _green600 = DesignToken<Color>("green600")
internal val _green700 = DesignToken<Color>("green700")
internal val _green800 = DesignToken<Color>("green800")
internal val _green900 = DesignToken<Color>("green900")
internal val _yellow50 = DesignToken<Color>("yellow50")
internal val _yellow100 = DesignToken<Color>("yellow100")
internal val _yellow200 = DesignToken<Color>("yellow200")
internal val _yellow300 = DesignToken<Color>("yellow300")
internal val _yellow400 = DesignToken<Color>("yellow400")
internal val _yellow500 = DesignToken<Color>("yellow500")
internal val _yellow600 = DesignToken<Color>("yellow600")
internal val _yellow700 = DesignToken<Color>("yellow700")
internal val _yellow800 = DesignToken<Color>("yellow800")
internal val _yellow900 = DesignToken<Color>("yellow900")
internal val _amber50 = DesignToken<Color>("amber50")
internal val _amber100 = DesignToken<Color>("amber100")
internal val _amber200 = DesignToken<Color>("amber200")
internal val _amber300 = DesignToken<Color>("amber300")
internal val _amber400 = DesignToken<Color>("amber400")
internal val _amber500 = DesignToken<Color>("amber500")
internal val _amber600 = DesignToken<Color>("amber600")
internal val _amber700 = DesignToken<Color>("amber700")
internal val _amber800 = DesignToken<Color>("amber800")
internal val _amber900 = DesignToken<Color>("amber900")
internal val _orange50 = DesignToken<Color>("orange50")
internal val _orange100 = DesignToken<Color>("orange100")
internal val _orange200 = DesignToken<Color>("orange200")
internal val _orange300 = DesignToken<Color>("orange300")
internal val _orange400 = DesignToken<Color>("orange400")
internal val _orange500 = DesignToken<Color>("orange500")
internal val _orange600 = DesignToken<Color>("orange600")
internal val _orange700 = DesignToken<Color>("orange700")
internal val _orange800 = DesignToken<Color>("orange800")
internal val _orange900 = DesignToken<Color>("orange900")
internal val _brown50 = DesignToken<Color>("brown50")
internal val _brown100 = DesignToken<Color>("brown100")
internal val _brown200 = DesignToken<Color>("brown200")
internal val _brown300 = DesignToken<Color>("brown300")
internal val _brown400 = DesignToken<Color>("brown400")
internal val _brown500 = DesignToken<Color>("brown500")
internal val _brown600 = DesignToken<Color>("brown600")
internal val _brown700 = DesignToken<Color>("brown700")
internal val _brown800 = DesignToken<Color>("brown800")
internal val _brown900 = DesignToken<Color>("brown900")
internal val _gray50 = DesignToken<Color>("gray50")
internal val _gray100 = DesignToken<Color>("gray100")
internal val _gray200 = DesignToken<Color>("gray200")
internal val _gray300 = DesignToken<Color>("gray300")
internal val _gray400 = DesignToken<Color>("gray400")
internal val _gray500 = DesignToken<Color>("gray500")
internal val _gray600 = DesignToken<Color>("gray600")
internal val _gray700 = DesignToken<Color>("gray700")
internal val _gray800 = DesignToken<Color>("gray800")
internal val _gray900 = DesignToken<Color>("gray900")

internal object DefaultComposeTheme {
    val colors = mapOf(
        _red50 to Color(0xFFFFEDED),
        _red100 to Color(0xFFFFC8C8),
        _red200 to Color(0xFFFFADAD),
        _red300 to Color(0xFFFF8787),
        _red400 to Color(0xFFFF7070),
        _red500 to Color(0xFFFF4C4C),
        _red600 to Color(0xFFE84545),
        _red700 to Color(0xFFB53636),
        _red800 to Color(0xFF8C2A2A),
        _red900 to Color(0xFF6B2020),
        _pink50 to Color(0xFFFFF3F6),
        _pink100 to Color(0xFFFFD9E2),
        _pink200 to Color(0xFFFFC7D4),
        _pink300 to Color(0xFFFFADC1),
        _pink400 to Color(0xFFFF9DB5),
        _pink500 to Color(0xFFFF85A2),
        _pink600 to Color(0xFFE87993),
        _pink700 to Color(0xFFB55E73),
        _pink800 to Color(0xFF8C4959),
        _pink900 to Color(0xFF6B3844),
        _purple50 to Color(0xFFF6F2FF),
        _purple100 to Color(0xFFE4D5FF),
        _purple200 to Color(0xFFD7C1FF),
        _purple300 to Color(0xFFC4A5FF),
        _purple400 to Color(0xFFB994FF),
        _purple500 to Color(0xFFA779FF),
        _purple600 to Color(0xFF986EE8),
        _purple700 to Color(0xFF7756B5),
        _purple800 to Color(0xFF5C438C),
        _purple900 to Color(0xFF46336B),
        _blue50 to Color(0xFFF0F5FF),
        _blue100 to Color(0xFFD0DFFF),
        _blue200 to Color(0xFFB9D0FF),
        _blue300 to Color(0xFF98BBFF),
        _blue400 to Color(0xFF85ADFF),
        _blue500 to Color(0xFF6699FF),
        _blue600 to Color(0xFF5D8BE8),
        _blue700 to Color(0xFF486DB5),
        _blue800 to Color(0xFF38548C),
        _blue900 to Color(0xFF2B406B),
        _green50 to Color(0xFFF0FFF0),
        _green100 to Color(0xFFD0FFD0),
        _green200 to Color(0xFFB9FFB9),
        _green300 to Color(0xFF98FF98),
        _green400 to Color(0xFF85FF85),
        _green500 to Color(0xFF66FF66),
        _green600 to Color(0xFF5DE85D),
        _green700 to Color(0xFF48B548),
        _green800 to Color(0xFF388C38),
        _green900 to Color(0xFF2B6B2B),
        _yellow50 to Color(0xFFFFFFF0),
        _yellow100 to Color(0xFFFFFFD0),
        _yellow200 to Color(0xFFFFFFB9),
        _yellow300 to Color(0xFFFFFF98),
        _yellow400 to Color(0xFFFFFF85),
        _yellow500 to Color(0xFFFFFF66),
        _yellow600 to Color(0xFFE8E85D),
        _yellow700 to Color(0xFFB5B548),
        _yellow800 to Color(0xFF8C8C38),
        _yellow900 to Color(0xFF6B6B2B),
        _amber50 to Color(0xFFFFFAEB),
        _amber100 to Color(0xFFFFEFC0),
        _amber200 to Color(0xFFFFE8A1),
        _amber300 to Color(0xFFFFDD76),
        _amber400 to Color(0xFFFFD65C),
        _amber500 to Color(0xFFFFCC33),
        _amber600 to Color(0xFFE8BA2E),
        _amber700 to Color(0xFFB59124),
        _amber800 to Color(0xFF8C701C),
        _amber900 to Color(0xFF6B5615),
        _orange50 to Color(0xFFFFF5EB),
        _orange100 to Color(0xFFFFDFC0),
        _orange200 to Color(0xFFFFD0A1),
        _orange300 to Color(0xFFFFBB76),
        _orange400 to Color(0xFFFFAD5C),
        _orange500 to Color(0xFFFF9933),
        _orange600 to Color(0xFFE88B2E),
        _orange700 to Color(0xFFB56D24),
        _orange800 to Color(0xFF8C541C),
        _orange900 to Color(0xFF6B4015),
        _brown50 to Color(0xFFF8F3F0),
        _brown100 to Color(0xFFE9D9CF),
        _brown200 to Color(0xFFDEC7B8),
        _brown300 to Color(0xFFCFAE97),
        _brown400 to Color(0xFFC69E83),
        _brown500 to Color(0xFFB88664),
        _brown600 to Color(0xFFA77A5B),
        _brown700 to Color(0xFF835F47),
        _brown800 to Color(0xFF654A37),
        _brown900 to Color(0xFF4D382A),
        _gray50 to Color(0xFFF6F6F6),
        _gray100 to Color(0xFFE4E4E4),
        _gray200 to Color(0xFFD7D7D7),
        _gray300 to Color(0xFFC5C5C5),
        _gray400 to Color(0xFFBABABA),
        _gray500 to Color(0xFFA9A9A9),
        _gray600 to Color(0xFF9A9A9A),
        _gray700 to Color(0xFF787878),
        _gray800 to Color(0xFF5D5D5D),
        _gray900 to Color(0xFF474747),
    )
    val textStyles = mapOf(
        _xs to TextStyle(fontSize = 12.sp, lineHeight = 16.sp),
        _sm to TextStyle(fontSize = 14.sp, lineHeight = 20.sp),
        _base to TextStyle(fontSize = 16.sp, lineHeight = 24.sp),
        _lg to TextStyle(fontSize = 18.sp, lineHeight = 28.sp),
        _xl to TextStyle(fontSize = 20.sp, lineHeight = 28.sp),
        _xl2 to TextStyle(fontSize = 24.sp, lineHeight = 32.sp),
        _xl3 to TextStyle(fontSize = 30.sp, lineHeight = 36.sp),
        _xl4 to TextStyle(fontSize = 36.sp, lineHeight = 40.sp),
        _xl5 to TextStyle(fontSize = 48.sp, lineHeight = 48.sp),
    )
    val shapes = mapOf(
        _round to RoundedCornerShape(4.dp),
        _roundL to RoundedCornerShape(8.dp),
        _roundXL to RoundedCornerShape(12.dp),
        _roundXL2 to RoundedCornerShape(16.dp),
        _roundXL3 to RoundedCornerShape(18.dp),
        _full to RoundedCornerShape(100),
    )
}

val ComposeTheme.colors: DesignTokens<Color>
    @Composable @ReadOnlyComposable get() {
        return this[_colors]
    }
val ComposeTheme.textStyles: DesignTokens<TextStyle>
    @Composable @ReadOnlyComposable get() {
        return this[_textStyles]
    }
val ComposeTheme.shapes: DesignTokens<Shape>
    @Composable @ReadOnlyComposable get() {
        return this[_shapes]
    }

val DesignTokens<TextStyle>.xs: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xs]
val DesignTokens<TextStyle>.sm: TextStyle
    @Composable @ReadOnlyComposable get() = this[_sm]
val DesignTokens<TextStyle>.base: TextStyle
    @Composable @ReadOnlyComposable get() = this[_base]
val DesignTokens<TextStyle>.lg: TextStyle
    @Composable @ReadOnlyComposable get() = this[_lg]
val DesignTokens<TextStyle>.xl: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xl]
val DesignTokens<TextStyle>.xl2: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xl2]
val DesignTokens<TextStyle>.xl3: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xl3]
val DesignTokens<TextStyle>.xl4: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xl4]
val DesignTokens<TextStyle>.xl5: TextStyle
    @Composable @ReadOnlyComposable get() = this[_xl5]

val DesignTokens<Shape>.round: Shape
    @Composable @ReadOnlyComposable get() = this[_round]
val DesignTokens<Shape>.roundL: Shape
    @Composable @ReadOnlyComposable get() = this[_roundL]
val DesignTokens<Shape>.roundXL: Shape
    @Composable @ReadOnlyComposable get() = this[_roundXL]
val DesignTokens<Shape>.roundXL2: Shape
    @Composable @ReadOnlyComposable get() = this[_roundXL2]
val DesignTokens<Shape>.roundXL3: Shape
    @Composable @ReadOnlyComposable get() = this[_roundXL3]
val DesignTokens<Shape>.roundFull: Shape
    @Composable @ReadOnlyComposable get() = this[_full]

val DesignTokens<Color>.red50: Color
    @Composable @ReadOnlyComposable get() = this[_red50]
val DesignTokens<Color>.red100: Color
    @Composable @ReadOnlyComposable get() = this[_red100]
val DesignTokens<Color>.red200: Color
    @Composable @ReadOnlyComposable get() = this[_red200]
val DesignTokens<Color>.red300: Color
    @Composable @ReadOnlyComposable get() = this[_red300]
val DesignTokens<Color>.red400: Color
    @Composable @ReadOnlyComposable get() = this[_red400]
val DesignTokens<Color>.red500: Color
    @Composable @ReadOnlyComposable get() = this[_red500]
val DesignTokens<Color>.red600: Color
    @Composable @ReadOnlyComposable get() = this[_red600]
val DesignTokens<Color>.red700: Color
    @Composable @ReadOnlyComposable get() = this[_red700]
val DesignTokens<Color>.red800: Color
    @Composable @ReadOnlyComposable get() = this[_red800]
val DesignTokens<Color>.red900: Color
    @Composable @ReadOnlyComposable get() = this[_red900]
val DesignTokens<Color>.pink50: Color
    @Composable @ReadOnlyComposable get() = this[_pink50]
val DesignTokens<Color>.pink100: Color
    @Composable @ReadOnlyComposable get() = this[_pink100]
val DesignTokens<Color>.pink200: Color
    @Composable @ReadOnlyComposable get() = this[_pink200]
val DesignTokens<Color>.pink300: Color
    @Composable @ReadOnlyComposable get() = this[_pink300]
val DesignTokens<Color>.pink400: Color
    @Composable @ReadOnlyComposable get() = this[_pink400]
val DesignTokens<Color>.pink500: Color
    @Composable @ReadOnlyComposable get() = this[_pink500]
val DesignTokens<Color>.pink600: Color
    @Composable @ReadOnlyComposable get() = this[_pink600]
val DesignTokens<Color>.pink700: Color
    @Composable @ReadOnlyComposable get() = this[_pink700]
val DesignTokens<Color>.pink800: Color
    @Composable @ReadOnlyComposable get() = this[_pink800]
val DesignTokens<Color>.pink900: Color
    @Composable @ReadOnlyComposable get() = this[_pink900]
val DesignTokens<Color>.purple50: Color
    @Composable @ReadOnlyComposable get() = this[_purple50]
val DesignTokens<Color>.purple100: Color
    @Composable @ReadOnlyComposable get() = this[_purple100]
val DesignTokens<Color>.purple200: Color
    @Composable @ReadOnlyComposable get() = this[_purple200]
val DesignTokens<Color>.purple300: Color
    @Composable @ReadOnlyComposable get() = this[_purple300]
val DesignTokens<Color>.purple400: Color
    @Composable @ReadOnlyComposable get() = this[_purple400]
val DesignTokens<Color>.purple500: Color
    @Composable @ReadOnlyComposable get() = this[_purple500]
val DesignTokens<Color>.purple600: Color
    @Composable @ReadOnlyComposable get() = this[_purple600]
val DesignTokens<Color>.purple700: Color
    @Composable @ReadOnlyComposable get() = this[_purple700]
val DesignTokens<Color>.purple800: Color
    @Composable @ReadOnlyComposable get() = this[_purple800]
val DesignTokens<Color>.purple900: Color
    @Composable @ReadOnlyComposable get() = this[_purple900]
val DesignTokens<Color>.blue50: Color
    @Composable @ReadOnlyComposable get() = this[_blue50]
val DesignTokens<Color>.blue100: Color
    @Composable @ReadOnlyComposable get() = this[_blue100]
val DesignTokens<Color>.blue200: Color
    @Composable @ReadOnlyComposable get() = this[_blue200]
val DesignTokens<Color>.blue300: Color
    @Composable @ReadOnlyComposable get() = this[_blue300]
val DesignTokens<Color>.blue400: Color
    @Composable @ReadOnlyComposable get() = this[_blue400]
val DesignTokens<Color>.blue500: Color
    @Composable @ReadOnlyComposable get() = this[_blue500]
val DesignTokens<Color>.blue600: Color
    @Composable @ReadOnlyComposable get() = this[_blue600]
val DesignTokens<Color>.blue700: Color
    @Composable @ReadOnlyComposable get() = this[_blue700]
val DesignTokens<Color>.blue800: Color
    @Composable @ReadOnlyComposable get() = this[_blue800]
val DesignTokens<Color>.blue900: Color
    @Composable @ReadOnlyComposable get() = this[_blue900]
val DesignTokens<Color>.green50: Color
    @Composable @ReadOnlyComposable get() = this[_green50]
val DesignTokens<Color>.green100: Color
    @Composable @ReadOnlyComposable get() = this[_green100]
val DesignTokens<Color>.green200: Color
    @Composable @ReadOnlyComposable get() = this[_green200]
val DesignTokens<Color>.green300: Color
    @Composable @ReadOnlyComposable get() = this[_green300]
val DesignTokens<Color>.green400: Color
    @Composable @ReadOnlyComposable get() = this[_green400]
val DesignTokens<Color>.green500: Color
    @Composable @ReadOnlyComposable get() = this[_green500]
val DesignTokens<Color>.green600: Color
    @Composable @ReadOnlyComposable get() = this[_green600]
val DesignTokens<Color>.green700: Color
    @Composable @ReadOnlyComposable get() = this[_green700]
val DesignTokens<Color>.green800: Color
    @Composable @ReadOnlyComposable get() = this[_green800]
val DesignTokens<Color>.green900: Color
    @Composable @ReadOnlyComposable get() = this[_green900]
val DesignTokens<Color>.yellow50: Color
    @Composable @ReadOnlyComposable get() = this[_yellow50]
val DesignTokens<Color>.yellow100: Color
    @Composable @ReadOnlyComposable get() = this[_yellow100]
val DesignTokens<Color>.yellow200: Color
    @Composable @ReadOnlyComposable get() = this[_yellow200]
val DesignTokens<Color>.yellow300: Color
    @Composable @ReadOnlyComposable get() = this[_yellow300]
val DesignTokens<Color>.yellow400: Color
    @Composable @ReadOnlyComposable get() = this[_yellow400]
val DesignTokens<Color>.yellow500: Color
    @Composable @ReadOnlyComposable get() = this[_yellow500]
val DesignTokens<Color>.yellow600: Color
    @Composable @ReadOnlyComposable get() = this[_yellow600]
val DesignTokens<Color>.yellow700: Color
    @Composable @ReadOnlyComposable get() = this[_yellow700]
val DesignTokens<Color>.yellow800: Color
    @Composable @ReadOnlyComposable get() = this[_yellow800]
val DesignTokens<Color>.yellow900: Color
    @Composable @ReadOnlyComposable get() = this[_yellow900]
val DesignTokens<Color>.amber50: Color
    @Composable @ReadOnlyComposable get() = this[_amber50]
val DesignTokens<Color>.amber100: Color
    @Composable @ReadOnlyComposable get() = this[_amber100]
val DesignTokens<Color>.amber200: Color
    @Composable @ReadOnlyComposable get() = this[_amber200]
val DesignTokens<Color>.amber300: Color
    @Composable @ReadOnlyComposable get() = this[_amber300]
val DesignTokens<Color>.amber400: Color
    @Composable @ReadOnlyComposable get() = this[_amber400]
val DesignTokens<Color>.amber500: Color
    @Composable @ReadOnlyComposable get() = this[_amber500]
val DesignTokens<Color>.amber600: Color
    @Composable @ReadOnlyComposable get() = this[_amber600]
val DesignTokens<Color>.amber700: Color
    @Composable @ReadOnlyComposable get() = this[_amber700]
val DesignTokens<Color>.amber800: Color
    @Composable @ReadOnlyComposable get() = this[_amber800]
val DesignTokens<Color>.amber900: Color
    @Composable @ReadOnlyComposable get() = this[_amber900]
val DesignTokens<Color>.orange50: Color
    @Composable @ReadOnlyComposable get() = this[_orange50]
val DesignTokens<Color>.orange100: Color
    @Composable @ReadOnlyComposable get() = this[_orange100]
val DesignTokens<Color>.orange200: Color
    @Composable @ReadOnlyComposable get() = this[_orange200]
val DesignTokens<Color>.orange300: Color
    @Composable @ReadOnlyComposable get() = this[_orange300]
val DesignTokens<Color>.orange400: Color
    @Composable @ReadOnlyComposable get() = this[_orange400]
val DesignTokens<Color>.orange500: Color
    @Composable @ReadOnlyComposable get() = this[_orange500]
val DesignTokens<Color>.orange600: Color
    @Composable @ReadOnlyComposable get() = this[_orange600]
val DesignTokens<Color>.orange700: Color
    @Composable @ReadOnlyComposable get() = this[_orange700]
val DesignTokens<Color>.orange800: Color
    @Composable @ReadOnlyComposable get() = this[_orange800]
val DesignTokens<Color>.orange900: Color
    @Composable @ReadOnlyComposable get() = this[_orange900]
val DesignTokens<Color>.brown50: Color
    @Composable @ReadOnlyComposable get() = this[_brown50]
val DesignTokens<Color>.brown100: Color
    @Composable @ReadOnlyComposable get() = this[_brown100]
val DesignTokens<Color>.brown200: Color
    @Composable @ReadOnlyComposable get() = this[_brown200]
val DesignTokens<Color>.brown300: Color
    @Composable @ReadOnlyComposable get() = this[_brown300]
val DesignTokens<Color>.brown400: Color
    @Composable @ReadOnlyComposable get() = this[_brown400]
val DesignTokens<Color>.brown500: Color
    @Composable @ReadOnlyComposable get() = this[_brown500]
val DesignTokens<Color>.brown600: Color
    @Composable @ReadOnlyComposable get() = this[_brown600]
val DesignTokens<Color>.brown700: Color
    @Composable @ReadOnlyComposable get() = this[_brown700]
val DesignTokens<Color>.brown800: Color
    @Composable @ReadOnlyComposable get() = this[_brown800]
val DesignTokens<Color>.brown900: Color
    @Composable @ReadOnlyComposable get() = this[_brown900]
val DesignTokens<Color>.gray50: Color
    @Composable @ReadOnlyComposable get() = this[_gray50]
val DesignTokens<Color>.gray100: Color
    @Composable @ReadOnlyComposable get() = this[_gray100]
val DesignTokens<Color>.gray200: Color
    @Composable @ReadOnlyComposable get() = this[_gray200]
val DesignTokens<Color>.gray300: Color
    @Composable @ReadOnlyComposable get() = this[_gray300]
val DesignTokens<Color>.gray400: Color
    @Composable @ReadOnlyComposable get() = this[_gray400]
val DesignTokens<Color>.gray500: Color
    @Composable @ReadOnlyComposable get() = this[_gray500]
val DesignTokens<Color>.gray600: Color
    @Composable @ReadOnlyComposable get() = this[_gray600]
val DesignTokens<Color>.gray700: Color
    @Composable @ReadOnlyComposable get() = this[_gray700]
val DesignTokens<Color>.gray800: Color
    @Composable @ReadOnlyComposable get() = this[_gray800]
val DesignTokens<Color>.gray900: Color
    @Composable @ReadOnlyComposable get() = this[_gray900]
