package com.boozeblaster.controllers

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.assertNotEquals
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

class DarkmodeControllerTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun testDarkmodeControllerInitial() {
        composableTestRule.setContent {
            DarkmodeController.load(context = LocalContext.current)
        }

        val instanceField = DarkmodeController::class.java.getDeclaredField("INSTANCE")
        instanceField.isAccessible = true
        assert(instanceField.get(null) != null)
    }

    @Test
    fun testToggleDarkmodeController() {
        val isDarkmode = DarkmodeController.isDarkmode()
        composableTestRule.setContent {
            DarkmodeController.load(context = LocalContext.current)
            DarkmodeController.toggle()
        }

        assertNotEquals(isDarkmode, DarkmodeController.isDarkmode())
    }

}