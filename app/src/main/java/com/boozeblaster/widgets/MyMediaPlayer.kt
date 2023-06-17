package com.boozeblaster.widgets

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

/**
 * Singleton - We do not want to run more than one sound at the same time!
 */
class MyMediaPlayer private constructor() : MediaPlayer() {
    companion object {
        @Volatile
        private var INSTANCE: MediaPlayer? = null

        fun create(context: Context, resid: Int) {
            INSTANCE = MediaPlayer.create(context, resid)
        }

        /**
         * If we start the MediaPlayer, make sure we do not run two sounds concurrently
         */
        fun start() {
            try {
                if (INSTANCE!!.isPlaying) {
                    INSTANCE!!.stop()
                }

                INSTANCE!!.start()
            } catch (e: Exception) {
                Log.e("MyMediaPlayer", "Cannot start MyMediaPlayer!")
            }
        }

        fun stop() {
            try {
                INSTANCE!!.stop()
            } catch (e: Exception) {
                Log.e("MyMediaPlayer", "Cannot stop MyMediaPlayer!")
            }
        }
    }
}