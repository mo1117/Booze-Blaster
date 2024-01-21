package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.viewmodels.GameSettingsViewModel
import org.junit.Rule
import org.junit.Test

class AdultModePickerScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testAdultModePickerScreenDisplaysCorrectText() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("Choose Mode").assertIsDisplayed()
    }

    @Test
    fun testAdultModePickerScreenDisplayUnselectedImages() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNode(hasContentDescription("PG Mode")).assertIsDisplayed()
        testComposableRule.onNode(hasContentDescription("Adult Mode")).assertIsDisplayed()
    }

    @Test
    fun testAdultModePickerScreenContinueButtonIsDisabledInitially() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        testComposableRule.onNodeWithText("Continue").assertIsNotEnabled()
    }

    @Test
    fun testAdultModePickerScreenEnablesContinueButton1() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }
        testComposableRule.onNode(hasContentDescription("PG Mode")).performClick()
        testComposableRule.onNodeWithText("Continue").assertIsEnabled()
    }

    @Test
    fun testAdultModePickerScreenEnablesContinueButton2() {
        testComposableRule.setContent {
            val navController = rememberNavController()
            val gameSettingsViewModel = GameSettingsViewModel()
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }
        testComposableRule.onNode(hasContentDescription("Adult Mode")).performClick()
        testComposableRule.onNodeWithText("Continue").assertIsEnabled()
    }

}