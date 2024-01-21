package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.viewmodels.GameSettingsViewModel
import org.junit.Rule
import org.junit.Test

class DifficultyPickerScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testDifficultyPickerScreenDifficultyIsUnknownInitially() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DifficultyPickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("Continue").assertIsNotEnabled()
    }

    @Test
    fun testDifficultyPickerScreenChangingDifficultyEnablesContinueButton() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DifficultyPickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("Hard").performClick()

        testComposableRule.onNodeWithText("Continue").assertIsEnabled()
    }

    @Test
    fun testDifficultyPickerScreenContainsAllFourDifficulties() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            DifficultyPickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("Easy").assertIsDisplayed()
        testComposableRule.onNodeWithText("Medium").assertIsDisplayed()
        testComposableRule.onNodeWithText("Hard").assertIsDisplayed()
        testComposableRule.onNodeWithText("Alcoholic").assertIsDisplayed()
    }

}