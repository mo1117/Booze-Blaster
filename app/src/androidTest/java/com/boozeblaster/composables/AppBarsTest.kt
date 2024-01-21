package com.boozeblaster.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class AppBarsTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun testHomeTopAppBarShowsCorrectTitle() {
        composableTestRule.setContent {
            HomeTopAppBar()
        }

        composableTestRule.onNodeWithText("Booze Blaster").assertIsDisplayed()
    }

    @Test
    fun testHomeTopAppBarShowsNavigationIcon() {
        composableTestRule.setContent {
            HomeTopAppBar()
        }

        composableTestRule.onNode(hasContentDescription("Menu")).assertIsDisplayed()
    }

    @Test
    fun testHomeTopAppBarOpensDropdown() {
        composableTestRule.setContent {
            HomeTopAppBar()
        }

        composableTestRule.onNode(hasContentDescription("Menu")).performClick()

        composableTestRule.onNodeWithText("Quit").assertIsDisplayed()
    }

    @Test
    fun testSimpleTopAppBarShowsCorrectTitle() {
        composableTestRule.setContent {
            SimpleTopAppBar(onBackButtonClick = {})
        }

        composableTestRule.onNodeWithText("Booze Blaster").assertIsDisplayed()
    }

    @Test
    fun testSimpleTopAppBarExecutesActionOnBackButton() {
        var pressedBackButton = false
        composableTestRule.setContent {
            SimpleTopAppBar(onBackButtonClick = { pressedBackButton = true })
        }

        composableTestRule.onNode(hasContentDescription("BackButton")).performClick()

        assert(pressedBackButton)
    }

    @Test
    fun testGameScreenAppBarExecutesActionOnBackButton() {
        var pressedBackButton = false
        composableTestRule.setContent {
            GameScreenAppBar(onBackButtonClick = { pressedBackButton = true }, currentRound = 1, onRestartClicked = {})
        }

        composableTestRule.onNode(hasContentDescription("BackButton")).performClick()

        assert(pressedBackButton)
    }

    @Test
    fun testGameScreenAppBarShowsRuleBreaker() {
        composableTestRule.setContent {
            GameScreenAppBar(onBackButtonClick = { }, currentRound = 1, onRestartClicked = {})
        }
        composableTestRule.onNode(hasContentDescription("Rule Breaker Icon")).performClick()

        composableTestRule.onNodeWithText("Pick Players that have broken a rule!").assertIsDisplayed()
    }

    @Test
    fun testGameScreenAppBarShowsScoreboard() {
        composableTestRule.setContent {
            GameScreenAppBar(onBackButtonClick = { }, currentRound = 1, onRestartClicked = {})
        }
        composableTestRule.onNode(hasContentDescription("Scoreboard Icon")).performClick()

        composableTestRule.onNodeWithText("Scoreboard").assertIsDisplayed()
    }
}