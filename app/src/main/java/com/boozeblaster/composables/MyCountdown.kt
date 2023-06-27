package com.boozeblaster.composables

import android.os.CountDownTimer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.launch


@Composable
fun CountdownTimer(totalTimeInMillis: Long = 20_000) {
    var secondsLeft by remember { mutableStateOf(value = (totalTimeInMillis / 1000).toInt()) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            startCountdown(totalTimeInMillis = totalTimeInMillis, updateSeconds = {
                secondsLeft = it
            })
        }
    }

    SimpleTextDisplay(
        text = "Seconds left: $secondsLeft",
        fontSize = 20,
        fontFamily = FontFamily.SansSerif
    )
}

fun startCountdown(
    updateSeconds: (Int) -> Unit,
    totalTimeInMillis: Long,
) {

    val intervalInMillis = 1_000L

    object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
        override fun onTick(millisUntilFinished: Long) {
            val secondsLeft = (millisUntilFinished / 1000).toInt()
            updateSeconds(secondsLeft)
        }

        override fun onFinish() {
            //STUB
        }
    }.start()
}