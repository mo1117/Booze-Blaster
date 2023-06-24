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

class FactOrFiction(
    private val question: String,
    private val isCorrect: Boolean
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        // Disable both "Right" and "Wrong" buttons after first click - otherwise a user could
        // spam the button to gain more points
        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        SimpleSpacer(size = 50)
        SimpleTextDisplay(
            text = question,
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
                enabled = !buttonClicked,
                buttonType = ButtonType.INCORRECT
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
                enabled = !buttonClicked,
                buttonType = ButtonType.CORRECT
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
            sips = 0
            player.addPoints(points = points)
            return
        }
        points = 0
        sips = Game.getSipMultiplier()
        player.addSips(sips = sips)
    }
}