package com.boozeblaster.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import kotlinx.coroutines.delay

@Composable
fun PointsOrSipsDialog(
    points: Int,
    sips: Int,
    callback: () -> Unit
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        showDialog = true
        delay(timeMillis = 1000)
        showDialog = false
        delay(timeMillis = 1000)
        callback()
    }

    AnimatedVisibility(
        visible = showDialog,
        enter = fadeIn(
            animationSpec = tween(durationMillis = 750)
        ),
        exit = fadeOut(
            animationSpec = tween(durationMillis = 750)
        )
    ) {
        Card(
            backgroundColor = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimpleTextDisplay(
                    text = if (points > 0) "$points Points Added!" else "Drink $sips Sips!",
                    fontSize = 16,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }

}