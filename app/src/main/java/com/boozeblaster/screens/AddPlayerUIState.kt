package com.boozeblaster.screens

import com.boozeblaster.models.Player
import com.boozeblaster.utils.Validator
import java.util.*

data class AddPlayerUIState(
    val name: String = "",
    var nameError: Boolean = false,
    var actionEnabled: Boolean = false
) {



    fun toPlayer(): Player = Player(
        name = name
    )

    fun hasError(): Boolean {
        val userNameResult = Validator.validateUsername(username = name)

        return listOf(
            userNameResult
        ).any {
            !it.success
        }
    }
}