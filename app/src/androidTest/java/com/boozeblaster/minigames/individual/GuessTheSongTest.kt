package com.boozeblaster.minigames.individual

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.individual.GuessTheSong
import com.boozeblaster.models.Player
import com.boozeblaster.models.Song
import com.boozeblaster.utils.GenrePicker
import com.boozeblaster.R
import com.boozeblaster.enums.Genre
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test

class GuessTheSongTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testGuessTheSongDisplay() {
        val song = Song("TestSong", "TestArtist", genre = Genre.ROCK)
        val resid = R.raw.waka_waka
        val duration = 1000L

        val guessTheSong = GuessTheSong(song = song, resid = resid, duration = duration)

        testComposableRule.setContent {
            guessTheSong.DisplayContent(player = Player(name = "TestPlayer"), callback = { }, versusPlayer = null)
            LaunchedEffect(Unit) {
                delay(2000)
                testComposableRule.onNodeWithText("Show Solution").assertIsDisplayed().performClick()

                testComposableRule.onNodeWithText(song.getSongName()).assertTextEquals(song.getSongName())

                testComposableRule.onNodeWithText(song.getArtistName()).assertTextEquals(song.getArtistName())

                testComposableRule.onNodeWithText("Got Both").assertIsDisplayed()
                    .assertHasClickAction()

                testComposableRule.onNodeWithText("One Correct").assertIsDisplayed()
                    .assertHasClickAction()

                testComposableRule.onNodeWithText("Wrong").assertIsDisplayed()
                    .assertHasClickAction()
            }
        }
    }
}
