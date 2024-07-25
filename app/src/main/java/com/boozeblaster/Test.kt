package com.boozeblaster

import com.boozeblaster.generators.TaskGenerator
import com.boozeblaster.models.Player

fun main() {
    val players = listOf(Player(name = "Mo"), Player(name = "Mo2"))
    for (i in 0 until 10) {
        val t = System.currentTimeMillis()
        val tasks = TaskGenerator.generateTasks(players, 3)
        println(System.currentTimeMillis() - t)
    }
}