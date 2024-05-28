package com.boozeblaster.composables

import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.ui.theme.backgroundColorForCard
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun PickGenre(
        pickRock: () -> Unit,
        pickRap: () -> Unit,
        pickHipHop: () -> Unit,
        pickPop: () -> Unit
) {

    SimpleCard(modifier = Modifier,
            width = 220.dp,
            height = 120.dp,
            onClick = pickRock,
            shape = AbsoluteRoundedCornerShape(20.dp),
            backgroundColor = getBackgroundColor().backgroundColorForCard(),
            border = null,
            elevation = 4.dp,
            padding = 16.dp,
            enabled = true) {
        SimpleTextDisplay(text = "Rock", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(modifier = Modifier,
            width = 220.dp,
            height = 120.dp,
            onClick = pickRap,
            shape = AbsoluteRoundedCornerShape(20.dp),
            backgroundColor = getBackgroundColor().backgroundColorForCard(),
            border = null,
            elevation = 4.dp,
            padding = 16.dp,
            enabled = true) {
        SimpleTextDisplay(text = "Rap", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(modifier = Modifier,
            width = 220.dp,
            height = 120.dp,
            onClick = pickHipHop,
            shape = AbsoluteRoundedCornerShape(20.dp),
            backgroundColor = getBackgroundColor().backgroundColorForCard(),
            border = null,
            elevation = 4.dp,
            padding = 16.dp,
            enabled = true) {
        SimpleTextDisplay(text = "Hip-Hop", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }

    SimpleCard(modifier = Modifier,
            width = 220.dp,
            height = 120.dp,
            onClick = pickPop,
            shape = AbsoluteRoundedCornerShape(20.dp),
            backgroundColor = getBackgroundColor().backgroundColorForCard(),
            border = null,
            elevation = 4.dp,
            padding = 16.dp,
            enabled = true) {
        SimpleTextDisplay(text = "Pop", fontSize = 20, fontFamily = FontFamily.SansSerif)
    }
}