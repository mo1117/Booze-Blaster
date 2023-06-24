package com.boozeblaster.minigames.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.*
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.headerFont

class NeverHaveIEver(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        var selectPlayers by remember {
            mutableStateOf(value = false)
        }

        var playersDoneIt by remember {
            mutableStateOf(value = listOf<Player>())
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!selectPlayers) {
                SimpleTextDisplay(
                    text = "Never Have I Ever",
                    fontSize = 30,
                    fontFamily = headerFont
                )
                SimpleSpacer(size = 50)
                SimpleTextDisplay(
                    text = statement,
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )

                SimpleSpacer(size = 30)
                SimpleTextDisplay(
                    text = "Select all players that have done said thing!",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
                SimpleSpacer(size = 30)

                SimpleButton(
                    onClick = { selectPlayers = true },
                    text = "Select Players",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    enabled = !showDialog
                )
            }

            //Pick Players
            MyAnimatedVisibility(
                visible = selectPlayers,
                animationDuration = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis
            ) {
                SimpleButton(
                    onClick = { },
                    text = "Done it",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    buttonType = ButtonType.CORRECT
                )

                SimpleSpacer(size = 30)

                SimpleButton(
                    onClick = { },
                    text = "Did not do it",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    buttonType = ButtonType.INCORRECT
                )

                SimpleSpacer(size = 30)

                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.size(width = 300.dp, height = 300.dp),
                    content = {
                        items(Game.getPlayers()) { player ->

                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    playersDoneIt = if (playersDoneIt.contains(element = player)) {
                                        playersDoneIt.minus(element = player)
                                    } else {
                                        playersDoneIt.plus(element = player)
                                    }
                                },
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (playersDoneIt.contains(element = player))
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    }
                )
                SimpleSpacer(size = 30)
                SimpleButton(
                    onClick = { selectPlayers = false },
                    text = "Done",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            }

            if (!selectPlayers) {
                SimpleSpacer(size = 30)
                SimpleButton(
                    onClick = {
                        addPointsOrSips(playersDoneIt = playersDoneIt)
                        showDialog = true
                    },
                    text = "Check",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    needsConfirmation = true,
                    enabled = !showDialog
                )
            }

            SimpleSpacer(size = 50)

            if (showDialog) {
                AskPlayersToDrinkDialog(
                    players = playersDoneIt,
                    sips = Game.getSipMultiplier()
                ) {
                    showDialog = false
                    playersDoneIt = listOf()
                    callback()
                }
            }

        }
    }
}

/**
 * Gives points to all players that have not done the said thing
 *
 * Gives sips to all players that have done it
 * @param playersDoneIt List of players that have done the said statement
 */
private fun addPointsOrSips(playersDoneIt: List<Player>) {
    for (player in Game.getPlayers()) {
        if (playersDoneIt.contains(element = player)) {
            player.addSips(sips = Game.getSipMultiplier())
        } else {
            player.addPoints(points = 1)
        }
    }
}