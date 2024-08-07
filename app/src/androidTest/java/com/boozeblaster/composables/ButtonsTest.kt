package com.boozeblaster.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.font.FontFamily
import org.junit.Rule
import org.junit.Test

class ButtonsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val fontSize = 10
    private val fontFamily = FontFamily.SansSerif

    @Test
    fun testDisplaySimpleButton() {
        composeTestRule.setContent {
            SimpleButton(
                onClick = { /*TODO*/ },
                text = "Hi",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
        }

        composeTestRule.onNodeWithText("Hi").assertIsDisplayed()
    }

    @Test
    fun testSimpleButtonDisplaysConfirmation() {
        composeTestRule.setContent {
            SimpleButton(
                onClick = { /*TODO*/ },
                text = "Confirm me",
                fontSize = fontSize,
                fontFamily = fontFamily,
                needsConfirmation = true
            )
        }

        composeTestRule.onNodeWithText("Confirm me").performClick()

        composeTestRule.onNodeWithText("Confirm").assertIsDisplayed()
    }

    @Test
    fun testDisplaySimpleChangeableButton() {
        composeTestRule.setContent {
            SimpleChangeableButton(
                onClick = { /*TODO*/ },
                text = {
                    SimpleTextDisplay(
                        text = "Hi",
                        fontSize = fontSize,
                        fontFamily = fontFamily
                    )
                },
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }

        composeTestRule.onNodeWithText("Hi").assertIsDisplayed()
    }

    @Test
    fun testDisplaySimpleChangeableButtonDisplaysConfirmation() {
        composeTestRule.setContent {
            SimpleChangeableButton(
                onClick = { /*TODO*/ },
                text = {
                    SimpleTextDisplay(
                        text = "Confirm me",
                        fontSize = fontSize,
                        fontFamily = fontFamily
                    )
                },
                fontSize = 20,
                fontFamily = FontFamily.SansSerif,
                needsConfirmation = true
            )
        }

        composeTestRule.onNodeWithText("Confirm me").performClick()

        composeTestRule.onNodeWithText("Confirm").assertIsDisplayed()
    }
}