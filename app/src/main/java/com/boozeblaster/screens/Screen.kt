package com.boozeblaster.screens

sealed class Screen(val route: String) {

    object HomeScreen: Screen(route = "home")

    object StartGameScreen: Screen(route = "startGame")

    object AddPlayerScreen: Screen(route = "addPlayer")

    object EditPlayerScreen: Screen(route = "editPlayer")

    object GameScreen: Screen(route = "gameScreen")
}