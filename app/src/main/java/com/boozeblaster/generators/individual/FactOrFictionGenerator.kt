package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.FactOrFiction

class FactOrFictionGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list)
    }

    /**
     * List of FactOrFiction instances
     */
    private val list = listOf(
        FactOrFiction(question = "Grass is blue", isCorrect = false),
        FactOrFiction(question = "Grass is red", isCorrect = false),
        FactOrFiction(question = "Grass is pink", isCorrect = false),
    )
}