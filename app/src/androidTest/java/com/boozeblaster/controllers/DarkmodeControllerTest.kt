package com.boozeblaster.controllers

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class DarkmodeControllerTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun testDarkmodeControllerInitial() {
        composableTestRule.setContent {
            DarkmodeController.load(context = LocalContext.current)
            assert(DarkmodeController.isDarkmode() == isSystemInDarkTheme())
        }
    }

    @Test
    fun testToggleDarkmodeController() {
        composableTestRule.setContent {
            DarkmodeController.load(context = LocalContext.current)
            DarkmodeController.toggle()
        }

        assert(DarkmodeController.isDarkmode())
    }

}