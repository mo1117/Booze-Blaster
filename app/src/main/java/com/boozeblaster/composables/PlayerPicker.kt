package com.boozeblaster.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Player

@Composable
fun PlayerPicker( //TODO
    isVisible: Boolean,
    callback: () -> Unit,
    players: List<Player>,
    fontSize: Int = 20,
    fontFamily: FontFamily = FontFamily.SansSerif,
    message: String = "Picked Player(s)"
) {
    var pickedPlayers by remember {
        mutableStateOf(value = listOf<Player>())
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
                            pickedPlayers = if (pickedPlayers.contains(element = player)) {
                                pickedPlayers.minus(element = player)
                            } else {
                                pickedPlayers.plus(element = player)
                            }
                        },
                        text = player.getName(),
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        buttonType = if (pickedPlayers.contains(element = player))
                            ButtonType.CORRECT else ButtonType.INCORRECT
                    )
                }
            }
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = callback,
            text = "Done",
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}