package com.boozeblaster.composables

import android.os.CountDownTimer
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.launch


@Composable
fun CountdownTimer() {
    var secondsLeft by remember { mutableStateOf(10) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            startCountdown {
                secondsLeft = it
            }
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
) {
    val totalTimeInMillis = 20_000L // Total time in milliseconds (10 seconds)
    val intervalInMillis = 1_000L // Interval between countdown updates (1 second)

    object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
        override fun onTick(millisUntilFinished: Long) {
            val secondsLeft = (millisUntilFinished / 1000).toInt()
            updateSeconds(secondsLeft)
        }

        override fun onFinish() {
            // Countdown finished, perform any desired actions
            println("END OF TIME")
        }
    }.start()
}