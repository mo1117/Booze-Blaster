package com.boozeblaster.utils

import com.boozeblaster.filters.AdvancedProfanityFilter
import com.boozeblaster.filters.BackupProfanityFilter

object Validator {

    private val profanityFilter = AdvancedProfanityFilter()
    private val filter = profanityFilter.getFilter()

    init {
        profanityFilter.setSuccessor(successor = BackupProfanityFilter().getFilter())
    }

    fun validateUsername(username: String): ValidationResult {
        if (username.length < 2 || username.length > 15 || filter?.invoke(username)!!) {
            return ValidationResult(success = false)
        }
        return ValidationResult(success = true)
    }
}

data class ValidationResult(
    val success: Boolean
)