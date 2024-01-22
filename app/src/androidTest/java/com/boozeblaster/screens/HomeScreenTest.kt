package com.boozeblaster.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testButtonClicks() {
        var startClicked = false
        var customizeClicked = false
        var addPlayerClicked = false
        var tutorialClicked = false

        testComposableRule.setContent {
            HomeScreenContent(
                modifier = androidx.compose.ui.Modifier,
                onStartClicked = { startClicked = true },
                onCustomizeGameClicked = { customizeClicked = true },
                onAddPlayerClicked = { addPlayerClicked = true },
                onTutorialClicked = { tutorialClicked = true }
            )
        }

        testComposableRule.onNodeWithText("Classic Game").performClick()
        assert(startClicked)

        testComposableRule.onNodeWithText("Create Custom Game").performClick()
        assert(customizeClicked)

        testComposableRule.onNodeWithText("Add Players").performClick()
        assert(addPlayerClicked)

        testComposableRule.onNodeWithText("How To Play").performClick()
        assert(tutorialClicked)
    }
}
