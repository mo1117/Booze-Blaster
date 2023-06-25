package com.boozeblaster.minigames.individual

import android.os.CountDownTimer
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.*
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.Timer
import kotlinx.coroutines.launch

class GuessTheLyrics(
    private val songName: String,
    private val artist: String,
    private val lyrics: String,
    private val lyricsCompletion: String,
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        // Whether or not we want to show the solution
        var showSolution by remember {
            mutableStateOf(value = false)
        }

        // Disable both "Right" and "Wrong" buttons after first click - otherwise a user could
        // spam the button to gain more points
        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        if (!showSolution) {
            SimpleSpacer(size = 50)
            SimpleTextDisplay(text = this.songName, fontSize = 38, fontFamily = fontFamily)
            SimpleSpacer(size = 50)
            SimpleTextDisplay(text = this.artist, fontSize = 32, fontFamily = fontFamily)
            SimpleSpacer(size = 50)
            SimpleTextDisplay(text = this.lyrics, fontSize = 28, fontFamily = fontFamily)
            SimpleSpacer(size = 50)


            CountdownTimer()
            
            SimpleSpacer(size = 10)

            // Show Solution Button
            SimpleButton(
                onClick = {
                    showSolution = true
                },
                text = "Show Solution",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif
            )
        }

        MyAnimatedVisibility(
            visible = showSolution,
            animationDuration = AnimationConstants.SHOW_SOLUTION_FADE_IN_OUT.durationMillis,
            content = {
                SimpleTextDisplay(
                    text = this.lyricsCompletion,
                    fontSize = 28,
                    fontFamily = FontFamily.SansSerif
                )
                SimpleSpacer(size = 50)

                // "Correct" Button
                SimpleButton(
                    onClick = {
                        points = 2
                        sips = 0
                        player!!.addPoints(points = 1)
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Correct",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.CORRECT
                )
                SimpleSpacer(size = 50)

                // "Partially correct" Button
                SimpleButton(
                    onClick = {
                        points = 1
                        sips = Game.getSipMultiplier()
                        player!!.addPoints(points = 1)
                        player.addSips(sips = sips)
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Partially Correct",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.HALF_CORRECT
                )
                SimpleSpacer(size = 50)

                // "Wrong" Button
                SimpleButton(
                    onClick = {
                        points = 0
                        sips = 2 * Game.getSipMultiplier()
                        player!!.addSips(sips = 2 * Game.getSipMultiplier())
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Wrong",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.INCORRECT
                )
                SimpleSpacer(size = 30)

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
        )
    }

}