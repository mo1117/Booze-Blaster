package com.boozeblaster.models

class SearchedTerm(
    private val term: String,
    private val amount: Int
) {
    fun getTerm(): String = this.term
    fun getAmount(): Int = this.amount
}