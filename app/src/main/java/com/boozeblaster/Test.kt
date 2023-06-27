package com.boozeblaster

class Test {
    fun name() : String = javaClass.simpleName
}

fun main() {
    val test = Test()
    println(test.name())
}