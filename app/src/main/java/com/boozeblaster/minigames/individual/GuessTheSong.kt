package com.boozeblaster.minigames.individual

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.R
import com.boozeblaster.composables.AnimatingText
import com.boozeblaster.composables.CountdownTimer
import com.boozeblaster.composables.MyAnimatedVisibilityTopToTop
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleImage
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.MyMediaPlayer
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
    private val duration: Long = 10_000
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        MyMediaPlayer.create(context = LocalContext.current, resid = this.resid)

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
            //Sound is currently playing
            SimpleImage(imageId = R.drawable.speaker_on)
            SimpleSpacer(size = 30)
            AnimatingText(text = "Listen up", fontSize = 20, fontFamily = FontFamily.SansSerif)
        }

        if (soundPlayed) {

            if (!showSolution) {
                //Show Solution Button and timer
                CountdownTimer(totalTimeInMillis = 20_000)
                SimpleSpacer(size = 20)

                SimpleButton(
                    onClick = { showSolution = true },
                    text = "Show Solution",
                    fontSize = fontSize,
                    fontFamily = fontFamily
                )
            }

            MyAnimatedVisibilityTopToTop(visible = showSolution,
                animationDuration = AnimationConstants.SHOW_SOLUTION_FADE_IN_OUT.durationMillis,
                content = {
                    // Display song name and artist
                    SimpleSpacer(size = 50)
                    SimpleTextDisplay(
                        text = songName,
                        fontSize = 30,
                        fontFamily = FontFamily.SansSerif
                    )
                    SimpleSpacer(size = 50)
                    SimpleTextDisplay(
                        text = artist,
                        fontSize = 30,
                        fontFamily = FontFamily.SansSerif
                    )
                    SimpleSpacer(size = 50)

                    // "Both Right" Button
                    SimpleButton(
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
                        onClick = {
                            points = 1
                            sips = Game.getSipMultiplier()
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
                        onClick = {
                            points = 0
                            sips = 2 * Game.getSipMultiplier()
                            player!!.addSips(sips = sips)
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

                    if (showDialog) {
                        PointsOrSipsDialog(points = points, sips = sips, callback = {
                            showSolution = false
                            buttonClicked = false
                            showDialog = false
                            soundPlayed = false
                            callback()
                        })
                    }
                }
            )
        }
    }

}

