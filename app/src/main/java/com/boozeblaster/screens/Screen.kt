package com.boozeblaster.screens

sealed class Screen(val route: String) {

    object HomeScreen : Screen(route = "home")

    object StartGameScreen : Screen(route = "startGame")

    object AddPlayerScreen : Screen(route = "addPlayer")

    object GameScreen : Screen(route = "game")

    object GameOverScreen : Screen(route = "gameOver")

    object TutorialScreen : Screen(route = "tutorial")

    object DifficultyPickerScreen : Screen(route = "difficulty")

    object AdultModePickerScreen : Screen(route = "adultMode")

    object DisplayDaresScreen : Screen(route = "displayDares")

    object RoundPickerScreen : Screen(route = "rounds")

    object FullfillDaresScreen : Screen(route = "fulfillDares")

    object GiveSipsScreen : Screen(route = "giveSips")

    object CustomizeGameScreen : Screen(route = "customizeGame")
}