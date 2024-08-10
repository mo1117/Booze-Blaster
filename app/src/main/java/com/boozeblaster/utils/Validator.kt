package com.boozeblaster.utils

object Validator {

    private val profanityFilter = ProfanityFilter

    fun validateUsername(username: String): ValidationResult {
        if (username.length < 2 || username.length > 15 || ProfanityFilter.containsProfanity(input = username)) {
            return ValidationResult(success = false)
        }
        return ValidationResult(success = true)
    }
}

data class ValidationResult(
    val success: Boolean
)