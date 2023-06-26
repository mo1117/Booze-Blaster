package com.boozeblaster.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

@Composable
fun ClickableSurfaceWithColumn(
    onSurfaceClicked: () -> Unit,
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
            .clickable(onClick = onSurfaceClicked)
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            content()
        }
    }
}

@Composable
fun SurfaceWithColumn(
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            content()
        }
    }
}

@Composable
fun DisplayScore(
    callback: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            val players = Game.getPlayersByPointsDescending()

            SimpleTextDisplay(text = "Scoreboard", fontSize = 30, fontFamily = headerFont)
            SimpleSpacer(size = 30)

            LazyColumn(
                modifier = Modifier
                    .height(height = 300.dp)
                    .fillMaxWidth(fraction = 0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                content = {
                    items(players) { player ->
                        Row {
                            SimpleTextDisplay(
                                text = "${player.getName()} | ${player.getPoints()} Points | " +
                                        "${player.getSips()} Sips\n",
                                fontSize = 20,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                })

            SimpleSpacer(size = 30)
            SimpleButton(
                onClick = callback,
                text = "Continue",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}