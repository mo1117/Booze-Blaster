package com.boozeblaster.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily

@Composable
fun PickGenre(
    pickRock: () -> Unit,
    pickRap: () -> Unit,
    pickHipHop: () -> Unit,
    pickPop: () -> Unit
) {
    val rowModifier = Modifier.fillMaxWidth(fraction = 0.9f)

    Row(modifier = rowModifier) {
        SimpleCard(onClick = pickRock) {
            SimpleTextDisplay(text = "Rock", fontSize = 20, fontFamily = FontFamily.SansSerif)
        }

        SimpleCard(onClick = pickRap) {
            SimpleTextDisplay(text = "Rap", fontSize = 20, fontFamily = FontFamily.SansSerif)
        }
    }

    Row(modifier = rowModifier) {
        SimpleCard(onClick = pickHipHop) {
            SimpleTextDisplay(text = "Hip-Hop", fontSize = 20, fontFamily = FontFamily.SansSerif)
        }

        SimpleCard(onClick = pickPop) {
            SimpleTextDisplay(text = "Pop", fontSize = 20, fontFamily = FontFamily.SansSerif)
        }
    }
}