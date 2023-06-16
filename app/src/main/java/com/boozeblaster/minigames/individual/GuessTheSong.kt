package com.boozeblaster.minigames.individual

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.Timer
import kotlinx.coroutines.delay

/**
 * Class representing the GuessTheSong minigame
 * @param duration Per default always 10 seconds, change in GuessTheSongGenerator
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
        val mediaPlayer = MediaPlayer.create(LocalContext.current, this.resid)

        // Whether or not we want to show the solution
        var showSolution by remember {
            mutableStateOf(value = false)
        }

        var soundPlayed by remember {
            mutableStateOf(value = false)
        }

        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        if (!soundPlayed) {
            LaunchedEffect(Unit) {
                mediaPlayer.start()
                delay(timeMillis = duration)
                mediaPlayer.stop()
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
                    color = Color.Blue
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


                Row {

                    // "Wrong" Button
                    SimpleButton(
                        modifier = Modifier,
                        onClick = {
                            sips = 2 * Game.getInstance().getSipMultiplier()
                            player!!.addSips(sips = 2 * Game.getInstance().getSipMultiplier())
                            showDialog = true
                            buttonClicked = true
                        },
                        text = "Wrong",
                        fontSize = 16,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Red,
                        enabled = !buttonClicked
                    )
                    SimpleSpacer(size = 50)

                    // "Right" Button
                    SimpleButton(
                        modifier = Modifier,
                        onClick = {
                            points = 1
                            player!!.addPoints(points = 1)
                            showDialog = true
                            buttonClicked = true
                        },
                        text = "Right",
                        fontSize = 16,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Green,
                        enabled = !buttonClicked
                    )
                }
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