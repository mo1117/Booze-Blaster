package com.boozeblaster.generators

import com.boozeblaster.generators.individual.DareGenerator
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Player
import kotlin.random.Random

object DareTaskGenerator {

    /**
     * We want to keep track of the dares we have already used for a game
     *
     * Therefore, when reloading a dare, only provide dares that are not yet used by another player
     */
    private var usedDares = arrayOf<Dare>()

    /**
     * This method generates the dares for all the players. The 1 or 2 players, depending on
     * the number of players for a game, have to fulfill this dares at the end or drink a huge
     * amount of sips
     *@param players The players for the current game
     */
    fun assignDares(players: List<Player>) {
        var dare: Dare
        var counter = 0

        val dareList = DareGenerator().getList() as List<Dare>

        while (counter < players.size) {
            if (players.get(index = counter).getDare() != null) {
                counter++
                continue
            }
            dare = dareList.get(index = Random.nextInt(from = 0, until = dareList.size))
            if (dare !in usedDares) {
                usedDares = usedDares.plus(element = dare)
                players.get(index = counter).setDare(dare = dare)
                counter++
            }
        }
    }

    /**
     * Reloads the dare for a certain player
     * @param player The player for whom a new dare shall be selected
     * @return True if a new dare could be loaded, false else
     */
    fun reloadDare(player: Player): Boolean {
        val dareList = DareGenerator().getList() as List<Dare>
        var dare: Dare

        if (usedDares.size == dareList.size) {
            return false
        }

        while (true) {
            dare = dareList.get(index = Random.nextInt(from = 0, until = dareList.size))
            if (dare !in usedDares) {
                usedDares = usedDares.plus(element = dare)
                player.setDare(dare = dare)
                break;
            }
        }
        return true
    }

    /**
     * Resets the list of used Dares
     */
    fun resetUsedDares() {
        usedDares = emptyArray()
    }

    fun getUsedDares() = this.usedDares
}