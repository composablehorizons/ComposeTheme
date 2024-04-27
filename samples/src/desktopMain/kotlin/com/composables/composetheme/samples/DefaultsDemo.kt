package com.composables.composetheme.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.composetheme.*

val Theme = buildComposeTheme {}

@Composable
fun DefaultsDemo() {
    Theme {
        Column(Modifier.verticalScroll(rememberScrollState()).padding(24.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            val text = "The quick brown fox jumps over the lazy dog"
            BasicText(text = text, style = ComposeTheme.textStyles.xs)
            BasicText(text = text, style = ComposeTheme.textStyles.sm)
            BasicText(text = text, style = ComposeTheme.textStyles.base.copy(color = ComposeTheme.colors.red500))
            BasicText(text = text, style = ComposeTheme.textStyles.lg)
            BasicText(text = text, style = ComposeTheme.textStyles.xl)
            BasicText(text = text, style = ComposeTheme.textStyles.xl2)
            BasicText(text = text, style = ComposeTheme.textStyles.xl3)
            BasicText(text = text, style = ComposeTheme.textStyles.xl4)
            BasicText(text = text, style = ComposeTheme.textStyles.xl5)
            Spacer(Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.round).size(48.dp))
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.roundL).size(48.dp))
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.roundXL).size(48.dp))
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.roundXL2).size(48.dp))
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.roundXL3).size(48.dp))
                Box(Modifier.background(ComposeTheme.colors.gray800, ComposeTheme.shapes.roundFull).size(48.dp))
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.red50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.red900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.pink50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.pink900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.purple50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.purple900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.blue50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.blue900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.green50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.green900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.yellow50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.yellow900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.amber50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.amber900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.orange50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.orange900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.brown50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.brown900).size(48.dp))
                }
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.background(ComposeTheme.colors.gray50).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray100).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray200).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray300).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray400).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray500).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray600).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray700).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray800).size(48.dp))
                    Box(Modifier.background(ComposeTheme.colors.gray900).size(48.dp))
                }
            }
        }
    }
}

