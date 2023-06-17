package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.MyMediaPlayer
import com.boozeblaster.widgets.Timer
import kotlinx.coroutines.delay

/**
 * Class representing the GuessTheSong minigame
 * @param duration Per default always 10 seconds, change in GuessTheSongGenerator if needed
 * @see com.boozeblaster.generators.individual.GuessTheSongGenerator
 */
class GuessTheSong(
    private val songName: String,
    private val artist: String,
    private val resid: Int,
    private val duration: Long = 10000
) : MiniGame() {


    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, timer: Timer) {
        MyMediaPlayer.create(context = LocalContext.current, resid = this.resid)

        val buttonModifier = Modifier
            .size(width = 150.dp, height = 75.dp)

        // Whether or not we want to show the solution
        var showSolution by remember {
            mutableStateOf(value = false)
        }

        // Needed to check if the sound is finished playing
        var soundPlayed by remember {
            mutableStateOf(value = false)
        }

        // Do not enable users to click on buttons more than once
        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        // Show +Points or +Sips or both
        var showDialog by remember {
            mutableStateOf(value = false)
        }

        if (!soundPlayed) {
            LaunchedEffect(Unit) {
                MyMediaPlayer.start()
                delay(timeMillis = duration)
                MyMediaPlayer.stop()
                soundPlayed = true
            }
        }

        if (soundPlayed) {

            if (!showSolution) {

                // Show Solution Button
                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        showSolution = true
                    },
                    text = "Show Solution",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Blue,
                    buttonType = ButtonType.UI
                )
            } else {

                // Display song name and artist
                SimpleSpacer(size = 50)
                SimpleTextDisplay(
                    text = this.songName,
                    fontSize = 30,
                    fontFamily = FontFamily.SansSerif
                )
                SimpleSpacer(size = 50)
                SimpleTextDisplay(
                    text = this.artist,
                    fontSize = 30,
                    fontFamily = FontFamily.SansSerif
                )
                SimpleSpacer(size = 50)

                // "Both Right" Button
                SimpleButton(
                    modifier = buttonModifier,
                    onClick = {
                        points = 2
                        sips = 0
                        player!!.addPoints(points = points)
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "Got Both",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.CORRECT
                )
                SimpleSpacer(size = 50)

                // User got only the song name or artist correct

                SimpleButton(
                    modifier = buttonModifier,
                    onClick = {
                        points = 1
                        sips = Game.getInstance().getSipMultiplier()
                        player!!.addPoints(points = points)
                        player.addSips(sips = sips)
                        showDialog = true
                        buttonClicked = true
                    },
                    text = "One Correct",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    enabled = !buttonClicked,
                    buttonType = ButtonType.HALF_CORRECT
                )
                SimpleSpacer(size = 50)

                // "Wrong" Button
                SimpleButton(
                    modifier = buttonModifier,
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
            }
        }

        // Show dialog that tells the player if they were correct
        if (showDialog) {
            PointsOrSipsDialog(points = points, sips = sips, callback = {
                buttonClicked = false
                showDialog = false
                showSolution = false
                soundPlayed = false
                callback()
            })
        }
    }
}