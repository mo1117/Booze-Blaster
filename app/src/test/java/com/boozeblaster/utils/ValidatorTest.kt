package com.boozeblaster.utils

import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.Assert.assertTrue

class ValidatorTest {

    @Test
    fun testValidateUsername1() {
        assertTrue(Validator.validateUsername(username = "John").success)
    }

//    @Test
//    fun testValidateUsername2() {
//        assertFalse(Validator.validateUsername(username = "Retard").success)
//    }

    @Test
    fun testValidateUsername3() {
        assertTrue(Validator.validateUsername(username = "Max123").success)
    }

    @Test
    fun testValidateUsername4() {
        assertFalse(Validator.validateUsername(username = "MaxingMaximumMax").success)
    }

    @Test
    fun testValidateUsername5() {
        assertFalse(Validator.validateUsername(username = "M").success)
    }
}