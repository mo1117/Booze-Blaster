package com.boozeblaster.models

import org.junit.Test
import org.junit.Assert.assertEquals

class SearchedTermTest {

    private val searchedTerm = SearchedTerm(term = "Austria", amount = 1000000)

    @Test
    fun testGetTerm() {
        assertEquals("Austria", searchedTerm.getTerm())
    }

    @Test
    fun testGetAmount() {
        assertEquals(1000000, searchedTerm.getAmount())
    }

}