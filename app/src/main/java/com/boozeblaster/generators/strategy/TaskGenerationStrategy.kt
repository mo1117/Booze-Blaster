package com.boozeblaster.generators.strategy

import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task
import kotlin.random.Random

interface TaskGenerationStrategy {

    fun getRandomTask(availableTasks: Array<String>): String {
        return availableTasks[Random.nextInt(from = 0, until = availableTasks.size)]
    }

    val generateTask: (Boolean?, List<Player>?, List<Task>) -> List<Task>

}