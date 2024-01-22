package com.boozeblaster.minigames.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class NeverHaveIEverTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    private val neverHaveIEver = NeverHaveIEver(statement = "Smoked a Beer")
    private val player = Player(name = "John")

    @Test
    fun testNeverHaveIEverDisplaysText() {
        testComposableRule.setContent {
            neverHaveIEver.DisplayContent(player = player, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Never Have I Ever").assertIsDisplayed()
    }

    @Test
    fun testNeverHaveIEverDisplaysCorrectStatement() {
        testComposableRule.setContent {
            neverHaveIEver.DisplayContent(player = player, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Smoked a Beer").assertIsDisplayed()
    }

    @Test
    fun testNeverHaveIEverAsksForConfirmation() {
        testComposableRule.setContent {
            neverHaveIEver.DisplayContent(player = player, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Check").performClick()
        testComposableRule.onNodeWithText("Confirm").assertIsDisplayed()
    }
}