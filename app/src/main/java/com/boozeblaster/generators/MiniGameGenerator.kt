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
     */
    fun getList(list: List<MiniGame>): List<MiniGame> {
        var randoms = arrayOf<Int>()
        var ret = listOf<MiniGame>()
        for (i in 0 until 3) {
            val random = Random.nextInt(from = 0, until = list.size)
            if (random !in randoms) {
                randoms += random
                ret += list.get(index = random)
            }
        }
        return ret
    }
}