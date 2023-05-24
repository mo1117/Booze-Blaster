package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.minigames.MiniGame
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

        Spacer(modifier = Modifier.size(size = 50.dp))
        Text(text = this.songName)
        Spacer(modifier = Modifier.size(size = 50.dp))
        Text(text = this.artist)
        Spacer(modifier = Modifier.size(size = 50.dp))
        Text(text = this.lyrics)
        Spacer(modifier = Modifier.size(size = 50.dp))
        if (!showSolution) {
            SimpleButton(
                modifier = Modifier,
                onClick = {
                    showSolution = !showSolution
                },
                text = "Show Solution",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif
            )
        }
        Spacer(modifier = Modifier.size(size = 50.dp))
        if (showSolution) {
            Text(text = this.lyricsCompletion)
            Spacer(modifier = Modifier.size(size = 50.dp))
        }
        if (showSolution) {
            Row {
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        player!!.addPoints(points = 1)
                        callback()
                    },
                    text = "Right",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.size(size = 50.dp))
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        player!!.addSips(sips = 2) //TODO hardcore drink mode more sips than 2
                        callback()
                    },
                    text = "Wrong",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }

    }
}