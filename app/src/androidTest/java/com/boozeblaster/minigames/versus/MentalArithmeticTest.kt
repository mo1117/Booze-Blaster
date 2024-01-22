package com.boozeblaster.minigames.versus

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class MentalArithmeticTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testMentalArithmeticDisplay() {
        val mentalArithmetic = MentalArithmetic(expression = "2 + 2", solution = 4)

        testComposableRule.setContent {
            mentalArithmetic.DisplayContent(player = Player(name = "Player1"), callback = { }, versusPlayer = Player(name = "Player2"))
        }

        testComposableRule.onNodeWithText("2 + 2").assertIsDisplayed()

        testComposableRule.onNodeWithText("Show Solution").assertIsDisplayed()
            .assertHasClickAction()
    }
}
