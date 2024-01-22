package com.boozeblaster.minigames.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class HighestBidderTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    private val highestBidder = HighestBidder(pointsToGet = 4)
    private val player = Player(name = "John")

    @Test
    fun testHighestBidderShowsBid() {
        testComposableRule.setContent {
            highestBidder.DisplayContent(player = player, callback = { /*TODO*/ }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Current Bid:").assertIsDisplayed()
    }

    @Test
    fun testHighestBidderShowsCorrectPoints() {
        testComposableRule.setContent {
            highestBidder.DisplayContent(player = player, callback = { /*TODO*/ }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("4 points can be snatched!").assertIsDisplayed()
    }
}