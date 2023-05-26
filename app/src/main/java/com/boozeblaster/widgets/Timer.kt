package com.boozeblaster.widgets

import androidx.compose.runtime.rememberCoroutineScope
import java.util.Timer

/**
 * Work in progress...
 *
 * Will see if this works
 */
class Timer private constructor(
    private val seconds: Int
): Timer() {
    companion object {
        @Volatile
        private var INSTANCE: Timer? = null

        fun getInstance(): Timer {
            if (INSTANCE == null) {
                return Timer(seconds = 15)
            }
            return INSTANCE!! // Not-null assertion operator safe here
        }

        fun init(seconds: Int) {
            INSTANCE = Timer(seconds = seconds)
        }
    }

    fun start(seconds: Int) {
        INSTANCE = Timer(seconds = seconds)
    }
}