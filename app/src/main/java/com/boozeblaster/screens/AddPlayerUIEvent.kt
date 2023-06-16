package com.boozeblaster.screens

sealed class AddPlayerUIEvent {

    object UsernameChanged : AddPlayerUIEvent()

    object BirthDateChanged : AddPlayerUIEvent()

    object Submit : AddPlayerUIEvent()
}