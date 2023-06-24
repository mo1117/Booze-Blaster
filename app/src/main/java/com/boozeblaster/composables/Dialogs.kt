package com.boozeblaster.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.enums.AnimationConstants
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
    players: List<Player>,
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
private fun getSipsMessage(players: List<Player>, sips: Int): String {
    val appendSForSips = if (sips > 1) "s" else ""
    val goOrGoes = if (sips > 1) "go" else "goes"

    if (players.isEmpty()) {
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