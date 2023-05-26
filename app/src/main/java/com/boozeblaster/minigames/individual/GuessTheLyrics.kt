package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

class GuessTheLyrics(
    private val songName: String,
    private val artist: String,
    private val lyrics: String,
    private val lyricsCompletion: String,
) : MiniGame {
    /**
     * We want to trigger recomposition whenever the "Show Solution" Button gets clicked
     *
     * LaunchedEffect() helps to avoid remembering the showSolution variable's value on each
     * (re)composition
     */
    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {
        var showSolution by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(key1 = this) {
            showSolution = false
        }

        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.songName, fontSize = 38, fontFamily = FontFamily.SansSerif)
        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.artist, fontSize = 32, fontFamily = FontFamily.SansSerif)
        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.lyrics, fontSize = 28, fontFamily = FontFamily.SansSerif)
        SimpleSpacer(size = 50)
        if (!showSolution) {
            SimpleButton(
                modifier = Modifier,
                onClick = {
                    showSolution = !showSolution
                },
                text = "Show Solution",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif,
                color = Color.Blue
            )
        } else {
            SimpleSpacer(size = 50)
            if (showSolution) {
                SimpleTextDisplay(
                    text = this.lyricsCompletion,
                    fontSize = 28,
                    fontFamily = FontFamily.SansSerif
                )
                SimpleSpacer(size = 50)
            }
            Row {
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        player!!.addSips(sips = 2 * Game.getInstance().getSipMultiplier())
                        callback()
                    },
                    text = "Wrong",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Red
                )
                SimpleSpacer(size = 50)
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        player!!.addPoints(points = 1)
                        callback()
                    },
                    text = "Right",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Green
                )
            }
        }
    }
}