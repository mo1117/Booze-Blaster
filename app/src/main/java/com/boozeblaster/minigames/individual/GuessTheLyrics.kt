package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.Timer

class GuessTheLyrics(
    private val songName: String,
    private val artist: String,
    private val lyrics: String,
    private val lyricsCompletion: String,
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, timer: Timer) {
        // Whether or not we want to show the solution
        var showSolution by remember {
            mutableStateOf(value = false)
        }

        // Disable both "Right" and "Wrong" buttons after first click - otherwise a user could
        // spam the button to gain more points
        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        timer.init(millisInFuture = 15000, onFinished = {
            sips = 2 * Game.getInstance().getSipMultiplier()
            player!!.addSips(sips = 2 * Game.getInstance().getSipMultiplier())
            showSolution = true
        })

//        timer.cancel()
//        timer.start()

        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.songName, fontSize = 38, fontFamily = fontFamily)
        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.artist, fontSize = 32, fontFamily = fontFamily)
        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = this.lyrics, fontSize = 28, fontFamily = fontFamily)
        SimpleSpacer(size = 50)

        if (!showSolution) {

            // Show Solution Button
            SimpleButton(
                modifier = Modifier,
                onClick = {
                    showSolution = true
                },
                text = "Show Solution",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif
            )
        } else {
            SimpleTextDisplay(
                text = this.lyricsCompletion,
                fontSize = 28,
                fontFamily = FontFamily.SansSerif
            )
            SimpleSpacer(size = 50)

            Row {

                // "Wrong" Button
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        points = 0
                        sips = 2 * Game.getInstance().getSipMultiplier()
                        player!!.addSips(sips = 2 * Game.getInstance().getSipMultiplier())
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Wrong",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.INCORRECT
                )
                SimpleSpacer(size = 50)

                // "Right" Button
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        points = 1
                        sips = 0
                        player!!.addPoints(points = 1)
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Right",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.CORRECT
                )
            }
        }

        // Show dialog that tells the player if they were correct
        if (showDialog) {
            PointsOrSipsDialog(points = points, sips = sips, callback = {
                showSolution = false
                buttonClicked = false
                showDialog = false
                callback()
            })
        }
    }
}