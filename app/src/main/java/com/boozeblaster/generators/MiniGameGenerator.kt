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
     * @param amount How many mini games we want to generate (default = 3)
     */
    fun getList(list: List<MiniGame>, amount: Int = 3): List<MiniGame> {
        var randoms = arrayOf<Int>()
        var ret = listOf<MiniGame>()
        var counter = 0
        var random: Int

        while (counter < amount) {
            random = Random.nextInt(from = 0, until = list.size)
            if (random !in randoms) {
                randoms = randoms.plus(element = random)
                ret = ret.plus(list.get(index = random))
                counter++
            }
        }
        return ret
    }
}