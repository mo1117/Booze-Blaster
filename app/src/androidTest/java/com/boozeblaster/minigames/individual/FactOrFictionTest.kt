package com.boozeblaster.minigames.individual

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import com.boozeblaster.minigames.individual.FactOrFiction
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class FactOrFictionTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testFactOrFictionDisplay() {
        val question = "Is the sky blue?"
        val isCorrect = true

        testComposableRule.setContent {
            FactOrFiction(question = question, isCorrect = isCorrect)
                .DisplayContent(player = Player(name = "TestPlayer"), callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText(question).assertIsDisplayed()

        testComposableRule.onNodeWithText("Wrong").assertIsDisplayed()
            .assertHasClickAction()
            .performClick()

        testComposableRule.onNodeWithText("Right").assertIsDisplayed()
            .assertHasClickAction()
            .performClick()
    }
}
