package com.boozeblaster.screens

import com.boozeblaster.utils.Validator
import java.util.*

data class AddPlayerUIState(
    val userName: String = "",
    val birthDate: Date = Date(),
    var nameError: Boolean = false,
    var birthDateError: Boolean = false,
    var actionEnabled: Boolean = false
) {

    fun hasError(): Boolean {
        val userNameResult = Validator.validateUsername(username = userName)
        val birthDateResult = Validator.validateBirthdate(birthDate = birthDate)

        return listOf(
            userNameResult,
            birthDateResult
        ).any {
            !it.success
        }
    }
}