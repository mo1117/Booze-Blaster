package com.boozeblaster.utils

object Validator {

    fun validateUsername(name: String): ValidationResult {
        if (name.length < 2) {
            return ValidationResult(success = false)
        }
        return ValidationResult(success = true)
    }

    fun validateBirthdate(): ValidationResult {
        return ValidationResult(false)
    }

}

data class ValidationResult(
    private val success: Boolean
)