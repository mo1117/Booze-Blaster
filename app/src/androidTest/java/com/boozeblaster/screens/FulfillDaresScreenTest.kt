package com.boozeblaster.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import org.junit.Rule
import org.junit.Test

class FulfillDaresScreenTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    private val players = listOf(Player(name = "John"), Player(name = "Mary"))

//    @Test
//    fun testFulfillDaresScreenShowsCorrectLosers1() {
//        Game.setPlayers(players = players)
//        players.get(index = 0).addPoints(points = 5)
//        players.get(index = 1).addPoints(points = 4)
//        testComposableRule.setContent {
//            val navController = rememberNavController()
//            FulfillDaresScreen(navController = navController)
//        }
//
//        testComposableRule.onNode(hasAnyChild(hasText("Mary"))).assertIsDisplayed()
//        TODO()
//    }

}