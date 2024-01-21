package com.boozeblaster.minigames.versus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.headerFont

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

        SimpleTextDisplay(text = expression, fontSize = fontSize, fontFamily = fontFamily)
        SimpleSpacer(size = 30)
        SimpleTextDisplay(text = solution.toString(), fontSize = fontSize, fontFamily = fontFamily)

//        SimpleTextDisplay(text = "Best of 5", fontSize = 30, fontFamily = headerFont)
//        SimpleSpacer(size = 30)
//
//        SimpleButton(
//            onClick = { },
//            text = "Winner",
//            fontSize = super.fontSize,
//            fontFamily = super.fontFamily,
//            buttonType = ButtonType.CORRECT,
//            enabled = !showDialog
//        )
//
//        SimpleSpacer(size = 30)
//
//        SimpleButton(
//            onClick = { winner = player },
//            text = player!!.getName(),
//            fontSize = super.fontSize,
//            fontFamily = super.fontFamily,
//            buttonType = if (winner == player) ButtonType.CORRECT else ButtonType.INCORRECT,
//            enabled = !showDialog
//        )
    }
}