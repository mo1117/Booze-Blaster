package com.boozeblaster.minigames.individual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import com.boozeblaster.widgets.Timer

class FactOrFiction(
    private val question: String,
    private val isCorrect: Boolean
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, timer: Timer) {

        // Disable both "Right" and "Wrong" buttons after first click - otherwise a user could
        // spam the button to gain more points
        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        SimpleSpacer(size = 50)
        SimpleTextDisplay(
            text = "$question",
            fontSize = fontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 50)

        Row {
            // "Wrong" Button
            SimpleButton(
                modifier = Modifier,
                onClick = {
                    checkAnswer(player = player!!, answer = false)
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
                    checkAnswer(player = player!!, answer = true)
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
        SimpleSpacer(size = 50)

        // Show dialog that tells the player if they were correct
        if (showDialog) {
            PointsOrSipsDialog(points = points, sips = sips, callback = {
                buttonClicked = false
                showDialog = false
                callback()
            })
        }
    }

    private fun checkAnswer(player: Player, answer: Boolean) {
        if (answer == isCorrect) {
            points = 1
            player.addPoints(points = points)
            return
        }
        sips = 2 * Game.getInstance().getSipMultiplier()
        player.addSips(sips = sips)
    }
}