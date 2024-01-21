package com.boozeblaster.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import com.boozeblaster.R

class ImagesTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun testDisplayImage() {
        composableTestRule.setContent {
            SimpleImage(imageId = R.drawable.handshake, contentDescription = "Handshake")
        }

        composableTestRule.onNode(hasContentDescription("Handshake")).assertIsDisplayed()
    }
}