package com.boozeblaster.minigames.individual

import androidx.compose.foundation.layout.Row
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
import com.boozeblaster.models.SearchedTerm

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

        SimpleTextDisplay(text = first.getTerm(), fontSize = fontSize, fontFamily = fontFamily)
        SimpleSpacer(size = 10)
        SimpleTextDisplay(
            text = first.getAmount().toString(),
            fontSize = fontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 50)
        SimpleTextDisplay(text = second.getTerm(), fontSize = fontSize, fontFamily = fontFamily)

        Row {
            SimpleButton(
                onClick = { /*TODO*/ },
                text = "Higher",
                fontSize = fontSize,
                fontFamily = fontFamily,
                buttonType = ButtonType.CORRECT
            )
            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { callback() },
                text = "Lower",
                fontSize = fontSize,
                fontFamily = fontFamily,
                buttonType = ButtonType.INCORRECT
            )
        }
    }
}