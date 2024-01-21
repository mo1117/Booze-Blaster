package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.CountdownTimer
import com.boozeblaster.composables.PointsOrSipsDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.models.SearchedTerm
import java.text.NumberFormat
import java.util.Locale

class HigherLower(
    private val first: SearchedTerm,
    private val second: SearchedTerm
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        var showSolution by remember {
            mutableStateOf(value = false)
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        var buttonClicked by remember {
            mutableStateOf(value = false)
        }

        SimpleTextDisplay(text = first.getTerm(), fontSize = fontSize, fontFamily = fontFamily)
        SimpleSpacer(size = 20)
        val formattedAmount = NumberFormat.getNumberInstance(Locale.US).format(first.getAmount())
        SimpleTextDisplay(text = formattedAmount, fontSize = fontSize, fontFamily = fontFamily)

        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = second.getTerm(), fontSize = fontSize, fontFamily = fontFamily)
        SimpleSpacer(size = 50)

        Row {
            SimpleButton(
                onClick = {
                    checkAnswer(player = player!!, higher = true)
                    showDialog = true
                    buttonClicked = true
                },
                text = "Higher",
                fontSize = fontSize,
                fontFamily = fontFamily,
                buttonType = ButtonType.CORRECT,
                enabled = !buttonClicked
            )
            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = {
                    checkAnswer(player = player!!, higher = false)
                    showDialog = true
                    buttonClicked = true
                },
                text = "Lower",
                fontSize = fontSize,
                fontFamily = fontFamily,
                buttonType = ButtonType.INCORRECT,
                enabled = !buttonClicked
            )
        }
        SimpleSpacer(size = 30)

        if (showDialog) {
            PointsOrSipsDialog(points = points, sips = sips, callback = {
                buttonClicked = false
                showDialog = false
                callback()
            })
        }

        if (!buttonClicked) {
            CountdownTimer(totalTimeInMillis = 15_000)
            SimpleSpacer(size = 20)
        }
    }

    private fun checkAnswer(player: Player, higher: Boolean) {
        if (higher && first.getAmount() < second.getAmount()) {
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