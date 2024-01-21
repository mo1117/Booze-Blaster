package com.boozeblaster.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class DialogsTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun testPointsOrSipsDialogShowsCorrectMessage1() {
        composableTestRule.setContent {
            PointsOrSipsDialog(points = 10, sips = 5, callback = {})
        }

        composableTestRule.onNodeWithText("10 Points Added!\nDrink 5 Sips!").assertIsDisplayed()
    }

    @Test
    fun testPointsOrSipsDialogShowsCorrectMessage2() {
        composableTestRule.setContent {
            PointsOrSipsDialog(points = 10, sips = 0, callback = {})
        }

        composableTestRule.onNodeWithText("10 Points Added!").assertIsDisplayed()
    }

    @Test
    fun testPointsOrSipsDialogShowsCorrectMessage3() {
        composableTestRule.setContent {
            PointsOrSipsDialog(points = 0, sips = 7, callback = {})
        }

        composableTestRule.onNodeWithText("Drink 7 Sips!").assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage1() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(players = emptyList(), sips = 10, callback = {})
        }

        composableTestRule.onNodeWithText("No one drinks!").assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage2() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(players = null, sips = 10, callback = {})
        }

        composableTestRule.onNodeWithText("No one drinks!").assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage3() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(
                players = listOf(Player(name = "John")),
                sips = 10,
                callback = {})
        }

        composableTestRule.onNodeWithText("10 Sips go to:\nJohn").assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage4() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(
                players = listOf(
                    Player(name = "John"),
                    Player(name = "Mary Jane")
                ), sips = 10, callback = {})
        }

        composableTestRule.onNodeWithText("10 Sips go to:\nJohn and Mary Jane").assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage5() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(
                players = listOf(
                    Player(name = "John"),
                    Player(name = "Johanna"),
                    Player(name = "Tom")
                ),
                sips = 10,
                callback = {})
        }

        composableTestRule.onNodeWithText("10 Sips go to:\nJohn, Johanna, and Tom")
            .assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage6() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(
                players = listOf(
                    Player(name = "John"),
                    Player(name = "Johanna"),
                    Player(name = "Tom"),
                    Player(name = "Jerry")
                ),
                sips = 10,
                callback = {})
        }

        composableTestRule.onNodeWithText("10 Sips go to:\nJohn, Johanna, Tom, and Jerry")
            .assertIsDisplayed()
    }

    @Test
    fun testAskPlayersToDrinkDialogShowsCorrectMessage7() {
        composableTestRule.setContent {
            AskPlayersToDrinkDialog(
                players = listOf(Player(name = "John")),
                sips = 1,
                callback = {})
        }

        composableTestRule.onNodeWithText("1 Sip goes to:\nJohn").assertIsDisplayed()
    }

    @Test
    fun testMyAlertDialogOnConfirm() {
        var confirm = false
        composableTestRule.setContent {
            MyAlertDialog(
                title = "Leave",
                message = "Do you want to leave?",
                onConfirm = { confirm = true },
                onDismiss = { })
        }

        composableTestRule.onNodeWithText("Yes").performClick()

        assert(confirm)
    }

    @Test
    fun testMyAlertDialogOnDismiss() {
        var dismiss = false
        composableTestRule.setContent {
            MyAlertDialog(
                title = "Leave",
                message = "Do you want to leave?",
                onConfirm = { },
                onDismiss = { dismiss = true })
        }

        composableTestRule.onNodeWithText("No").performClick()

        assert(dismiss)
    }
}