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

@Composable
fun PlayerPicker( //TODO
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

    MyAnimatedVisibility(
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