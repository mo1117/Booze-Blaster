package com.boozeblaster.screens

sealed class AddPlayerUIEvent {

    object UsernameChanged : AddPlayerUIEvent()

    object Submit : AddPlayerUIEvent()
}