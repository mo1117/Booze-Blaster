package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.FactOrFiction

class FactOrFictionGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    /**
     * List of FactOrFiction instances
     */
    private companion object {
        private val list = listOf(
            FactOrFiction(question = "Some cats are allergic to people.", isCorrect = true),
            FactOrFiction(question = "Grass is red", isCorrect = false),
            FactOrFiction(question = "Grass is pink", isCorrect = false),
        )
    }
}