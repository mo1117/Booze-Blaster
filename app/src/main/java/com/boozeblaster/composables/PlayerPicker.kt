package com.boozeblaster.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Used to pick one to multiple players
 * @param players Players to list
 * @param pickedPlayers For this, pass a mutable list of players that can then be edited
 */
@Composable
fun PlayerPicker(
    callback: () -> Unit,
    players: List<Player>,
    pickedPlayers: MutableList<Player>,
    fontSize: Int = 20,
    fontFamily: FontFamily = FontFamily.SansSerif,
    message: String = "Picked Player(s)"
) {
    val coroutineScope = rememberCoroutineScope()

    var selectedPlayers by remember {
        mutableStateOf(value = pickedPlayers.toList())
    }

    var isVisible by remember {
        mutableStateOf(value = false)
    }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    MyAnimatedVisibilityTopToTop(
        visible = isVisible,
        animationDuration = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis
    ) {

        SimpleButton(
            onClick = { },
            text = message,
            fontSize = fontSize,
            fontFamily = fontFamily,
            buttonType = ButtonType.CORRECT
        )

        SimpleSpacer(size = 30)

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.sizeIn(maxHeight = 400.dp),
            content = {
                items(items = players) { player ->
                    SimpleSpacer(size = 10)

                    SimpleButton(
                        onClick = {
                            if (selectedPlayers.contains(element = player)) {
                                selectedPlayers = selectedPlayers.minus(element = player)
                                pickedPlayers.remove(element = player)
                            } else {
                                selectedPlayers = selectedPlayers.plus(element = player)
                                pickedPlayers.add(element = player)
                            }
                        },
                        text = player.getName(),
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        buttonType = if (selectedPlayers.contains(element = player))
                            ButtonType.CORRECT else ButtonType.INCORRECT
                    )
                }
            }
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = {
                selectedPlayers = emptyList()
                coroutineScope.launch {
                    isVisible = false
                    delay(timeMillis = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis.toLong())
                    callback()
                }

            },
            text = "Done",
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}

/**
 * Used to pick a maximum of one player only
 * @param players Players to list
 * @param pickedPlayer For this pass a mutable list of nullable player elements. This method will
 * ensure that there is never more than one player in that list. It needs to be nullable so we can
 * actually de-select players by setting the value of index 0 to null
 */
@Composable
fun SinglePlayerPicker(
    callback: () -> Unit,
    players: List<Player>,
    pickedPlayer: MutableList<Player?>,
    fontSize: Int = 20,
    fontFamily: FontFamily = FontFamily.SansSerif,
    message: String = "Picked Player"
) {
    val coroutineScope = rememberCoroutineScope()

    var selectedPlayer: Player? by remember {
        mutableStateOf(value = pickedPlayer.get(index = 0))
    }

    var isVisible by remember {
        mutableStateOf(value = false)
    }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    MyAnimatedVisibilityTopToTop(
        visible = isVisible,
        animationDuration = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis
    ) {

        SimpleButton(
            onClick = { },
            text = message,
            fontSize = fontSize,
            fontFamily = fontFamily,
            buttonType = ButtonType.CORRECT
        )

        SimpleSpacer(size = 30)

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.sizeIn(maxHeight = 400.dp),
            content = {
                items(items = players) { player ->
                    SimpleSpacer(size = 10)

                    SimpleButton(
                        onClick = {
                            selectedPlayer = if (player == selectedPlayer) null else player
                            pickedPlayer[0] = selectedPlayer

                        },
                        text = player.getName(),
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        buttonType = if (selectedPlayer == player)
                            ButtonType.CORRECT else ButtonType.INCORRECT
                    )
                }
            }
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = {
                selectedPlayer = null
                coroutineScope.launch {
                    isVisible = false
                    delay(timeMillis = AnimationConstants.PLAYER_PICKER_FADE_IN_OUT.durationMillis.toLong())
                    callback()
                }
            },
            text = "Done",
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}