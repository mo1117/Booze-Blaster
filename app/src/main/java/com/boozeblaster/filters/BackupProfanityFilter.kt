package com.boozeblaster.filters

class BackupProfanityFilter : ProfanityFilter {

    private var successor: ((String) -> Boolean)? = null
    private val list = listOf("Stupid", "Idiot", "Ass")

    override fun setSuccessor(successor: ((String) -> Boolean)?) {
        this.successor = successor
    }

    override fun getFilter(): (String) -> Boolean {
        return ::handleRequest
    }

    private fun handleRequest(input: String): Boolean {
        return list.any { word -> word.equals(input, true) }
    }
}