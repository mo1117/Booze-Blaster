package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class AddPlayerScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testAddPlayerScreen() {
        testComposableRule.setContent {
            AddPlayerScreen()
        }

        testComposableRule.onNodeWithText("Confirm Age").assertIsDisplayed()
    }

}