package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class GameOverScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testDisplayGameOverScreenDisplaysPlayAgain() {
        testComposableRule.setContent {
            GameOverScreen(navController = rememberNavController())
        }

        testComposableRule.onNodeWithText("Play Again").assertIsDisplayed()
    }
}