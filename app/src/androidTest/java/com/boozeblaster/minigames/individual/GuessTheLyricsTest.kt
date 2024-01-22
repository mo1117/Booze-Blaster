package com.boozeblaster.minigames.individual

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.enums.Genre
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Player
import com.boozeblaster.models.Song
import com.boozeblaster.utils.GenrePicker
import org.junit.Rule
import org.junit.Test

class GuessTheLyricsTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testGuessTheLyricsDisplay() {
        val song = Song("TestSong", "TestArtist", genre = Genre.ROCK)
        val lyrics = "These are the lyrics to be displayed."
        val lyricsCompletion = "These are the lyrics to be displayed."

        val guessTheLyrics = GuessTheLyrics(song = song, lyrics = lyrics, lyricsCompletion = lyricsCompletion)

        testComposableRule.setContent {
            guessTheLyrics.DisplayContent(player = Player(name = "TestPlayer"), callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText(song.getSongName()).assertTextEquals(song.getSongName())

        testComposableRule.onNodeWithText(song.getArtistName()).assertTextEquals(song.getArtistName())

        testComposableRule.onNodeWithText(lyrics).assertTextEquals(lyrics)

        testComposableRule.onNodeWithText("Show Solution").assertIsDisplayed().performClick()

        testComposableRule.onNodeWithText("Correct").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Partially Correct").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Wrong").assertIsDisplayed()
            .assertHasClickAction()
    }
}
