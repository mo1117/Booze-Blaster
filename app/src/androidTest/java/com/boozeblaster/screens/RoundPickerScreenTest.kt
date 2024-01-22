package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.viewmodels.GameSettingsViewModel
import org.junit.Rule
import org.junit.Test

class RoundPickerScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testRoundPickerScreenContainsCorrectRound() {
        testComposableRule.setContent {
            RoundPickerScreen(
                navController = rememberNavController(),
                gameSettingsViewModel = GameSettingsViewModel()
            )
        }

        testComposableRule.onNodeWithText("1").assertIsDisplayed()
    }
}