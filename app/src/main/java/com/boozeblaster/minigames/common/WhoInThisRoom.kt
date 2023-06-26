package com.boozeblaster.minigames.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.sizeIn
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

class WhoInThisRoom(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        var pickedPlayers by remember {
            mutableStateOf(value = listOf<Player>())
        }

        var selectPlayers by remember {
            mutableStateOf(value = false)
        }

        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!selectPlayers) {
                SimpleTextDisplay(
                    text = "Who In This Room?",
                    fontSize = 30,
                    fontFamily = headerFont
                )
                SimpleSpacer(size = 30)
                SimpleTextDisplay(text = statement, fontSize = 24, fontFamily = super.fontFamily)
                SimpleSpacer(size = 30)

                SimpleButton(
                    onClick = { selectPlayers = true },
                    text = "Select Players",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    enabled = !showDialog
                )
            }

            sips = Game.getSipMultiplier()

            MyAnimatedVisibility(
                visible = selectPlayers,
                animationDuration = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis
            ) {

                SimpleButton(
                    onClick = { },
                    text = "Picked Player(s)",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    buttonType = ButtonType.CORRECT
                )

                SimpleSpacer(size = 30)

                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.sizeIn(maxHeight = 400.dp),
                    content = {
                        items(items = Game.getPlayers()) { player ->
                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    pickedPlayers = if (pickedPlayers.contains(element = player)) {
                                        pickedPlayers.minus(element = player)
                                    } else {
                                        pickedPlayers.plus(element = player)
                                    }
                                },
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (pickedPlayers.contains(element = player))
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    })

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
                        addSips(pickedPlayers = pickedPlayers)
                        showDialog = true
                    },
                    text = "Continue",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily,
                    enabled = pickedPlayers.isNotEmpty() && !showDialog,
                    needsConfirmation = true
                )
            }

            SimpleSpacer(size = 30)

            if (showDialog) {
                AskPlayersToDrinkDialog(players = pickedPlayers, sips = sips, callback = {
                    showDialog = false
                    pickedPlayers = listOf()
                    callback()
                })
            }
        }
    }

    /**
     * Adds sips to the picked players
     * @param pickedPlayers Players that got picked
     */
    private fun addSips(pickedPlayers: List<Player>) {
        for (player in Game.getPlayers()) {
            if (pickedPlayers.contains(element = player)) {
                player.addSips(sips = Game.getSipMultiplier())
            }
        }
    }
}