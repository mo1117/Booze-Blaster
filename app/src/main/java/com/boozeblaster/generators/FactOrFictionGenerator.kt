package com.boozeblaster.generators

import com.boozeblaster.minigames.individual.FactOrFiction

/**
 * The FactOrFictionGenerator handles generating a list of FactOrFictions
 *
 * This list, consisting of three elements, then gets assigned to a player
 */
class FactOrFictionGenerator : MiniGameGenerator() {

    override fun getList(): List<FactOrFiction> {
        return super.getList(list = list) as List<FactOrFiction>
    }

    /**
     * List of FactOrFiction instances
     */
    private companion object {
        private val list = listOf(
            FactOrFiction(question = "Grass is blue", isCorrect = false),
            FactOrFiction(question = "Grass is red", isCorrect = false),
            FactOrFiction(question = "Grass is pink", isCorrect = false),
            FactOrFiction(question = "Grass is purple", isCorrect = false),
            FactOrFiction(question = "Grass is green", isCorrect = true),
        )
    }
}