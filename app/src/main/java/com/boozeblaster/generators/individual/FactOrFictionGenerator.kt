package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.individual.FactOrFiction

class FactOrFictionGenerator : MiniGameGenerator() {

    override fun getList(): List<FactOrFiction> {
        return super.getList(list = list) as List<FactOrFiction>
    }

    /**
     * List of FactOrFiction instances
     */
    private val list = listOf(
        FactOrFiction(question = "Grass is blue", isCorrect = false),
        FactOrFiction(question = "Grass is red", isCorrect = false),
        FactOrFiction(question = "Grass is pink", isCorrect = false),
        FactOrFiction(question = "Grass is purple", isCorrect = false),
        FactOrFiction(question = "Grass is green", isCorrect = true),
    )
}