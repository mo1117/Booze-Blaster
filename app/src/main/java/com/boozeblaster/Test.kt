package com.boozeblaster

import com.boozeblaster.generators.taskFactories.CommonTaskFactory
import com.boozeblaster.generators.taskFactories.IndividualTaskFactory
import com.boozeblaster.generators.taskFactories.VersusTaskFactory
import com.boozeblaster.models.Player

fun main() {
    val task = CommonTaskFactory().createTask().invoke(null, null, false)
    val p1 = Player(name = "Mo")
    val p2 = Player(name = "Mo2")
    val versusTask = VersusTaskFactory().createTask().invoke(p1, p2, null)
    val indTask = IndividualTaskFactory().createTask().invoke(p1, null, null)
    println(task.getName())
    println(versusTask.getName())
    println(indTask.getName())
}