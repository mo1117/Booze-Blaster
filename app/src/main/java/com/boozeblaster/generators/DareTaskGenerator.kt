package com.boozeblaster.generators

import com.boozeblaster.generators.individual.DareGenerator
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Player
import kotlin.random.Random

object DareTaskGenerator {

    /**
     * This method generates the dares for all the players. The 1 or 2 players, depending on
     * the number of players for a game, have to fulfill this dares at the end or drink a huge
     * amount of sips
     *@param players The players for the current game
     */
    fun assignDares(players: List<Player>) {
        var randoms = arrayOf<Int>()
        var random: Int
        var counter = 0

        val dareList = DareGenerator().getList()

        while (counter < players.size) {
            random = Random.nextInt(from = 0, until = dareList.size)
            if (random !in randoms) {
                randoms = randoms.plus(element = random)
                players.get(index = counter).setDare(dare = dareList.get(index = random) as Dare)
                counter++
            }
        }
    }
}