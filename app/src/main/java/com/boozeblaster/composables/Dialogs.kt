package com.boozeblaster.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.enums.AnimationConstants
import kotlinx.coroutines.delay

@Composable
fun PointsOrSipsDialog(
    points: Int,
    sips: Int,
    callback: () -> Unit,
    duration: Long = 2500
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    val appendSForPoints = if (points > 1) "s" else ""
    val appendSForSips = if (sips > 1) "s" else ""

    // Actual output of the dialog, might be points, sips, or both
    val text = if (points > 0 && sips > 0) {
        "$points Point$appendSForPoints Added!\nDrink $sips Sip$appendSForSips!"
    } else if (points > 0) {
        "$points Point$appendSForPoints Added!"
    } else {
        "Drink $sips Sip$appendSForSips!"
    }

    LaunchedEffect(key1 = Unit) {
        showDialog = true
        delay(timeMillis = duration / 2)
        showDialog = false
        delay(timeMillis = duration / 2)
        callback()
    }

    AnimatedVisibility(
        visible = showDialog,
        enter = slideInHorizontally(
            animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
            initialOffsetX = { -500 }
        ),
        exit = slideOutHorizontally(
            animationSpec = tween(durationMillis = AnimationConstants.POINTS_OR_SIPS_FADE_IN_OUT.durationMillis),
            targetOffsetX = { 500 }
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleTextDisplay(
                text = text,
                fontSize = 30,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}