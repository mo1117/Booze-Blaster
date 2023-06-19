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
            FactOrFiction(
                question = "Cows can walk upstairs, but they cannot walk downstairs.",
                isCorrect = false
            ),
            FactOrFiction(
                question = "Bananas are berries, while strawberries are not.",
                isCorrect = true
            ),
            FactOrFiction(
                question = "The Great Wall of China is visible from space without aid (e.g. telescopic lenses).",
                isCorrect = false
            ),
            FactOrFiction(question = "Humans only use 10% of their brain.", isCorrect = false),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
            FactOrFiction(question = "", isCorrect = true),
        )
    }
}