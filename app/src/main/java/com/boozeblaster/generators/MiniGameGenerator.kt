package com.boozeblaster.generators

import com.boozeblaster.minigames.MiniGame
import kotlin.random.Random

abstract class MiniGameGenerator {

    /**
     * Every mini game generator needs to implement this method
     *
     * In this method, call the getList(list: List<MiniGame>) function
     */
    abstract fun getList(): List<MiniGame>

    /**
     * Sub classes call this method by passing a list consisting of the specific mini game's instances
     *
     * This method is used to fill the subTasks lists of each Task
     * @param list List of mini games
     * @param amount How many mini games we want to generate
     * @param resetAllToUnused If we want to reset all to unused after creating a list. This is
     * needed for [com.boozeblaster.generators.individual.GuessTheSongGenerator] and
     * [com.boozeblaster.generators.individual.GuessTheLyricsGenerator], since we always
     * re-generate the list when the user picked a Genre.
     */
    fun getList(
        list: List<MiniGame>,
        amount: Int,
        resetAllToUnused: Boolean
    ): List<MiniGame> {

        if (list.size < amount) {
            throw IllegalArgumentException("The list holds less instances than is required!")
        }

        var randoms = arrayOf<Int>()
        var ret = listOf<MiniGame>()
        var counter = 0
        var random: Int

        while (counter < amount) {
            random = Random.nextInt(from = 0, until = list.size)
            val game = list.get(index = random)

            if (list.haveAllBeenUsed()) {
                list.resetAllToUnused()
            }

            if (random !in randoms && !game.hasBeenUsed()) {
                randoms = randoms.plus(element = random)
                ret = ret.plus(element = game)
                game.setUsed(used = true)
                counter++
            }
        }

        if (resetAllToUnused) {
            list.resetAllToUnused()
        }

        return ret
    }

    /**
     * Check if a list of MiniGames consists of only elements that have all been used at least once
     */
    private fun List<MiniGame>.haveAllBeenUsed(): Boolean {
        return this.stream().allMatch(MiniGame::hasBeenUsed)
    }

    /**
     * Resets all elements of a list to 'unused' again
     */
    private fun List<MiniGame>.resetAllToUnused() {
        this.stream().forEach { game -> game.setUsed(used = false) }
    }
}