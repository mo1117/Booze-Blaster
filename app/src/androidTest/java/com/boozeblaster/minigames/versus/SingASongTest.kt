package com.boozeblaster.minigames.versus

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class SingASongTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testSingASongDisplay() {
        val singASong = SingASong(statement = "Sing a Song")

        testComposableRule.setContent {
            singASong.DisplayContent(
                player = Player(name = "Player1"),
                callback = { },
                versusPlayer = Player(name = "Player2")
            )
        }

        testComposableRule.onNodeWithText("Sing a Song").assertIsDisplayed()

        testComposableRule.onNodeWithText("Winner").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Player1").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Player2").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("No Winner").assertIsDisplayed()
            .assertHasClickAction()
    }
}
