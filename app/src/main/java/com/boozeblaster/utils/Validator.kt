package com.boozeblaster.utils

import com.boozeblaster.filters.ProfanityFilter

object Validator {

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