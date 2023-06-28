package com.boozeblaster.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.regularFont
import kotlinx.coroutines.delay

@Composable
fun PointsOrSipsDialog(
    points: Int,
    sips: Int,
    callback: () -> Unit
) {

    var showDialog by remember {
        mutableStateOf(value = false)
    }

    var displayContinueButton by remember {
        mutableStateOf(value = false)
    }

    LaunchedEffect(key1 = Unit) {
        showDialog = true
        delay(timeMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis.toLong())
        delay(timeMillis = AnimationConstants.POINTS_OR_SIPS_DIALOG.durationMillis.toLong())
        showDialog = false
        displayContinueButton = true
    }

    Box {
        Row {
            AnimatedVisibility(
                visible = displayContinueButton,
                enter = slideInHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.CONTINUE_BUTTON_FADE_IN.durationMillis),
                    initialOffsetX = { -800 }
                )
            ) {
                SimpleButton(
                    onClick = {
                        displayContinueButton = false
                        callback()
                    },
                    text = "Continue",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
        Row {
            AnimatedVisibility(
                visible = showDialog,
                enter = slideInHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
                    initialOffsetX = { -600 }
                ),
                exit = slideOutHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
                    targetOffsetX = { 600 }
                )
            ) {
                SimpleTextDisplay(
                    text = getPointsOrSipsMessage(points = points, sips = sips),
                    fontSize = 30,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Composable
fun AskPlayersToDrinkDialog(
    players: List<Player>?,
    sips: Int,
    callback: () -> Unit
) {
    var showDialog by remember {
        mutableStateOf(value = false)
    }

    var displayContinueButton by remember {
        mutableStateOf(value = false)
    }

    LaunchedEffect(key1 = Unit) {
        showDialog = true
        delay(timeMillis = AnimationConstants.SIPS_FADE_IN_OUT.durationMillis.toLong())
        delay(timeMillis = AnimationConstants.SIPS_DIALOG.durationMillis.toLong())
        showDialog = false
        displayContinueButton = true
    }

    Box {
        Row {
            AnimatedVisibility(
                visible = displayContinueButton,
                enter = slideInHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.CONTINUE_BUTTON_FADE_IN.durationMillis),
                    initialOffsetX = { -800 }
                )
            ) {
                SimpleButton(
                    onClick = {
                        displayContinueButton = false
                        callback()
                    },
                    text = "Continue",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }

        Row {
            AnimatedVisibility(
                visible = showDialog,
                enter = slideInHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
                    initialOffsetX = { -600 }
                ),
                exit = slideOutHorizontally(
                    animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
                    targetOffsetX = { 600 }
                )
            ) {
                SimpleTextDisplay(
                    text = getSipsMessage(players = players, sips = sips),
                    fontSize = 26,
                    fontFamily = regularFont
                )
            }
        }
    }
}

@Composable
fun MyAlertDialog(
    onDismissRequest: () -> Unit = { },
    title: String,
    message: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    confirmText: String = "Yes",
    dismissText: String = "No"
) {
    AlertDialog(
        backgroundColor = Color.Gray,
        onDismissRequest = onDismissRequest,
        title = {
            SimpleTextDisplay(
                modifier = Modifier.fillMaxWidth(fraction = 1f),
                text = title,
                fontSize = 30,
                fontFamily = FontFamily.SansSerif
            )
        },
        text = {
            SimpleTextDisplay(
                modifier = Modifier.fillMaxWidth(fraction = 1f),
                text = message,
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        },
        buttons = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SimpleButton(
                    modifier = Modifier
                        .padding(start = 7.dp, end = 7.dp)
                        .padding(vertical = 10.dp),
                    onClick = { onDismiss() },
                    text = dismissText,
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    buttonType = ButtonType.INCORRECT,
                    minWidth = 100
                )
                SimpleButton(
                    modifier = Modifier
                        .padding(start = 7.dp, end = 7.dp)
                        .padding(vertical = 10.dp),
                    onClick = { onConfirm() },
                    text = confirmText,
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif,
                    buttonType = ButtonType.CORRECT,
                    minWidth = 100
                )
            }
        }
    )
}

/**
 * @param points Amount of points to be added
 * @param sips Amount of sips to drink
 * @return The textual output for the PointsOrSipsDialog
 * @see PointsOrSipsDialog
 */
private fun getPointsOrSipsMessage(points: Int, sips: Int): String {
    val appendSForPoints = if (points > 1) "s" else ""
    val appendSForSips = if (sips > 1) "s" else ""

    return if (points > 0 && sips > 0) {
        "$points Point$appendSForPoints Added!\nDrink $sips Sip$appendSForSips!"
    } else if (points > 0) {
        "$points Point$appendSForPoints Added!"
    } else {
        "Drink $sips Sip$appendSForSips!"
    }
}

/**
 * @param players List of players that should drink
 * @param sips Amount of sips each player has to drink
 * @return The textual output for the AskPlayersToDrinkDialog
 * @see AskPlayersToDrinkDialog
 */
private fun getSipsMessage(players: List<Player>?, sips: Int): String {
    val appendSForSips = if (sips > 1) "s" else ""
    val goOrGoes = if (sips > 1) "go" else "goes"

    if (players.isNullOrEmpty()) {
        return "No one drinks!"
    }

    var output = "$sips Sip$appendSForSips $goOrGoes to:\n"

    if (players.size == 1) {
        return "$output${players.get(index = 0).getName()}"
    }

    for (i in players.indices) {
        output = if (i + 1 == players.size) {
            if (players.size == 2) {
                "$output and ${players.get(index = i).getName()}!"
            } else {
                "$output, and ${players.get(index = i).getName()}!"
            }
        } else {
            if (i == 0) {
                "$output ${players.get(index = i).getName()}"
            } else {
                "$output, ${players.get(index = i).getName()}"
            }
        }
    }
    return output
}