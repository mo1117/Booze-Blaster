package com.boozeblaster.widgets

import android.media.MediaPlayer
import androidx.test.platform.app.InstrumentationRegistry
import com.boozeblaster.R
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * See [testing documentation](http://d.android.com/tools/testing)
 */
class MyMediaPlayerTest {

    @Test
    fun testCreateMediaPlayer() {
        createMediaPlayer()
        assertNotNull(MyMediaPlayer::class.java.getDeclaredField("INSTANCE"))
    }

    @Test
    fun testStartMediaPlayer() {
        createMediaPlayer()
        MyMediaPlayer.start()
        val field = MyMediaPlayer::class.java.getDeclaredField("INSTANCE")
        field.isAccessible = true
        assertTrue((field.get(null) as MediaPlayer).isPlaying)
    }

    @Test
    fun testStopMediaPlayer() {
        createMediaPlayer()
        MyMediaPlayer.start()
        Thread.sleep(1000)
        MyMediaPlayer.stop()
        val field = MyMediaPlayer::class.java.getDeclaredField("INSTANCE")
        field.isAccessible = true
        assertFalse((field.get(null) as MediaPlayer).isPlaying)
    }

    private fun createMediaPlayer() {
        MyMediaPlayer.create(
            context = InstrumentationRegistry.getInstrumentation().targetContext,
            resid = R.raw.afterglow
        )
    }
}