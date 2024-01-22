package com.boozeblaster.composables

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

    SimpleCard(onClick = pickRock) {
        SimpleTextDisplay(text = "Rock", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(onClick = pickRap) {
        SimpleTextDisplay(text = "Rap", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(onClick = pickHipHop) {
        SimpleTextDisplay(text = "Hip-Hop", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(onClick = pickPop) {
        SimpleTextDisplay(text = "Pop", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }
}