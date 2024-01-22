package com.boozeblaster.minigames.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class WhoInThisRoomTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    private val whoInThisRoom = WhoInThisRoom(statement = "Has the most rizz")

    @Test
    fun testWhoInThisRoomDisplaysStatement() {
        testComposableRule.setContent {
            whoInThisRoom.DisplayContent(player = null, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Has the most rizz").assertIsDisplayed()
    }

    @Test
    fun testWhoInThisRoomDisplaysCorrectText() {
        testComposableRule.setContent {
            whoInThisRoom.DisplayContent(player = null, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Who In This Room?").assertIsDisplayed()
    }

    @Test
    fun testWhoInThisRoomCanPickPlayers() {
        testComposableRule.setContent {
            whoInThisRoom.DisplayContent(player = null, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Select Players").assertIsDisplayed()
    }

    @Test
    fun testWhoInThisRoomCannotContinueWithoutPickingPlayers() {
        testComposableRule.setContent {
            whoInThisRoom.DisplayContent(player = null, callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText("Continue").assertIsNotEnabled()
    }

}