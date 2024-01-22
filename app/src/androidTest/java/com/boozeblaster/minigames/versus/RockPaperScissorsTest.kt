package com.boozeblaster.minigames.versus

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class RockPaperScissorsTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testRockPaperScissorsDisplay() {
        val rockPaperScissors = RockPaperScissors()

        testComposableRule.setContent {
            rockPaperScissors.DisplayContent(
                player = Player(name = "Player1"),
                callback = { },
                versusPlayer = Player(name = "Player2")
            )
        }

        testComposableRule.onNodeWithText("Best of 5").assertIsDisplayed()

        testComposableRule.onNodeWithText("Winner").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Player1").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Player2").assertIsDisplayed()
            .assertHasClickAction()
            .performClick()

        testComposableRule.onNodeWithText("Continue").assertIsDisplayed()
            .assertHasClickAction()
    }
}
