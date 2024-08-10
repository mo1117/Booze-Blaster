package com.boozeblaster.filters

interface ProfanityFilter {

    fun setSuccessor(successor: ((String) -> Boolean)?)

    /**
     * @return A function that accepts an argument of type String and returns whether the input
     * contains profanity, or null
     */
    fun getFilter(): ((String) -> Boolean)?
}