package com.boozeblaster.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.builder.PickableCardBuilder

@Composable
fun PickGenre(
        pickRock: () -> Unit,
        pickRap: () -> Unit,
        pickHipHop: () -> Unit,
        pickPop: () -> Unit
) {
    val cardBuilder = PickableCardBuilder()

    cardBuilder.onClick = pickRock
    cardBuilder.content = { SimpleTextDisplay(text = "Rock", fontSize = 20, fontFamily = FontFamily.SansSerif) }
    val pickRockCard = cardBuilder.build()

    cardBuilder.onClick = pickRap
    cardBuilder.content = { SimpleTextDisplay(text = "Rap", fontSize = 20, fontFamily = FontFamily.SansSerif) }
    val pickRapCard = cardBuilder.build()

    cardBuilder.onClick = pickHipHop
    cardBuilder.content = { SimpleTextDisplay(text = "Hip-Hop", fontSize = 20, fontFamily = FontFamily.SansSerif) }
    val pickHipHopCard = cardBuilder.build()

    cardBuilder.onClick = pickPop
    cardBuilder.content = { SimpleTextDisplay(text = "Pop", fontSize = 20, fontFamily = FontFamily.SansSerif) }
    val pickPopCard = cardBuilder.build()

    pickRockCard()
    pickRapCard()
    pickHipHopCard()
    pickPopCard()
}