package com.boozeblaster.widgets

import android.os.CountDownTimer


/**
 * Work in progress...
 *
 * Will see if this works
 */
class Timer private constructor(
    private val millisInFuture: Long,
    private val countDownInterval: Long,
    private val onFinished: () -> Unit = { }
) : CountDownTimer(millisInFuture, countDownInterval) {
    companion object {
        @Volatile
        private var INSTANCE: Timer? = null

        fun getInstance(): Timer {
            checkInstance()
            return INSTANCE!! // Not-null assertion operator safe here
        }

        private fun checkInstance(millisInFuture: Long = 15000) {
            if (INSTANCE == null) {
                INSTANCE = Timer(millisInFuture = millisInFuture, countDownInterval = 1000)
            }
        }
    }

    fun init(millisInFuture: Long, onFinished: () -> Unit) {
        INSTANCE =
            Timer(
                millisInFuture = millisInFuture,
                countDownInterval = 1000,
                onFinished = onFinished
            )
    }

    override fun onTick(millisUntilFinished: Long) {
        println(millisUntilFinished)
    }

    override fun onFinish() {
        this.onFinished()
    }
}