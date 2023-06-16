package com.boozeblaster.composables

import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import kotlinx.coroutines.delay
import com.boozeblaster.R

@Composable
fun PointsOrSipsDialog(
    points: Int,
    sips: Int,
    callback: () -> Unit,
    duration: Long = 2500
) {

    // TODO do we wanna play sounds when answer is wrong / correct? maybe good maybe unnecessary
//    val sound = if (points > 0) R.raw.test else R.raw.test
//    val mediaPlayer = MediaPlayer.create(LocalContext.current, sound)

    var showDialog by remember {
        mutableStateOf(false)
    }

    val appendS = if (points > 1) "s" else ""

    LaunchedEffect(key1 = Unit) {
//        mediaPlayer.start()
        showDialog = true
        delay(timeMillis = duration / 2)
        showDialog = false
        delay(timeMillis = duration / 2)
//        mediaPlayer.stop()
        callback()
    }

    AnimatedVisibility(
        visible = showDialog,
        enter = slideInHorizontally(
            animationSpec = tween(durationMillis = 750),
            initialOffsetX = { -500 }
        ),
        exit = slideOutHorizontally(
            animationSpec = tween(durationMillis = 750),
            targetOffsetX = { 500 }
        )
    ) {
        Card(
            backgroundColor = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground,
            modifier = Modifier.fillMaxSize(fraction = 1f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimpleTextDisplay(
                    text = if (points > 0) "$points Point$appendS Added!" else "Drink $sips Sips!",
                    fontSize = 30,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }

}