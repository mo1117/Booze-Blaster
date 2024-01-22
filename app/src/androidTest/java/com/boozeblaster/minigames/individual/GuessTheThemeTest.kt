package com.boozeblaster.minigames.individual

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.individual.GuessTheTheme
import com.boozeblaster.models.Player
import com.boozeblaster.R
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test

class GuessTheThemeTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testGuessTheThemeDisplay() {
        val name = "TestTheme"
        val resid = R.raw.ghostbusters
        val duration = 1000L

        val guessTheTheme = GuessTheTheme(name = name, resid = resid, duration = duration)

        testComposableRule.setContent {
            guessTheTheme.DisplayContent(
                player = Player(name = "TestPlayer"),
                callback = { },
                versusPlayer = null
            )
            LaunchedEffect(Unit) {
                delay(2000)
                testComposableRule.onNodeWithText(name).assertTextEquals(name)

                testComposableRule.onNodeWithText("Show Solution").assertIsDisplayed().performClick()

                testComposableRule.onNodeWithText("Correct").assertIsDisplayed()
                    .assertHasClickAction()

                testComposableRule.onNodeWithText("Almost").assertIsDisplayed()
                    .assertHasClickAction()

                testComposableRule.onNodeWithText("Wrong").assertIsDisplayed()
                    .assertHasClickAction()
            }
        }
    }
}
