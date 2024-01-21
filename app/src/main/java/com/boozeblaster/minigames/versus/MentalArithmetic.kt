package com.boozeblaster.minigames.versus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.AskPlayersToDrinkDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

class MentalArithmetic(
    private val expression: String,
    private val solution: Int
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        var winner: Player? by remember {
            mutableStateOf(value = null)
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        var showSolution by remember {
            mutableStateOf(value = false)
        }

        SimpleTextDisplay(text = expression, fontSize = fontSize * 2, fontFamily = fontFamily)
        SimpleSpacer(size = 30)
        if (!showSolution) {
            SimpleButton(
                onClick = { showSolution = true },
                text = "Show Solution",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
        } else {
            SimpleTextDisplay(
                text = solution.toString(),
                fontSize = fontSize * 2,
                fontFamily = fontFamily
            )
        }

        SimpleSpacer(size = 50)

        SimpleButton(
            onClick = { },
            text = "Winner",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = ButtonType.CORRECT,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = { winner = player },
            text = player!!.getName(),
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = if (winner == player) ButtonType.CORRECT else ButtonType.INCORRECT,
            enabled = !showDialog && showSolution
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = { winner = versusPlayer },
            text = versusPlayer!!.getName(),
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = if (winner == versusPlayer) ButtonType.CORRECT else ButtonType.INCORRECT,
            enabled = !showDialog && showSolution
        )

        SimpleSpacer(size = 50)

        SimpleButton(
            onClick = { showDialog = true },
            text = "Continue",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            needsConfirmation = true,
            enabled = !showDialog && winner != null
        )

        SimpleSpacer(size = 50)

        if (showDialog) {
            val loser: Player? = when (winner) {
                player -> versusPlayer
                versusPlayer -> player
                else -> null
            }
            AskPlayersToDrinkDialog(
                players = if (loser == null) null else listOf(loser),
                sips = Game.getSipMultiplier(),
                callback = {
                    addSips(player = loser!!, sips = Game.getSipMultiplier())
                    addPoints(player = winner!!, points = 2)
                    showDialog = false
                    showSolution = false
                    winner = null
                    callback()
                })
        }
    }
}