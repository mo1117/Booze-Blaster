package com.boozeblaster.models

import com.boozeblaster.enums.Difficulty
import com.boozeblaster.tasks.Task

/**
 * The Game class represents an instance that holds all the tasks that will then be played
 *
 * This class is implemented as a singleton since we do not want more than one instance of a Game
 */
class Game private constructor(
    private val players: List<Player>,
    private val tasks: List<Task>,
    private val difficulty: Difficulty,
    private val adultMode: Boolean
) {
    companion object {
        @Volatile
        private var INSTANCE: Game? = null

        /**
         * If this method gets called before the first instantiation we just return an 'empty' Game
         * @param players Players
         * @param tasks Tasks
         * @return Singleton instance of Game
         */
        fun getInstance(): Game {
            if (INSTANCE == null) {
                return Game(
                    players = emptyList(),
                    tasks = emptyList(),
                    difficulty = Difficulty.EASY,
                    adultMode = false
                )
            }
            return INSTANCE!! // Not-null assertion operator can be used safely here
        }

        fun init(
            players: List<Player>,
            tasks: List<Task>,
            difficulty: Difficulty,
            adultMode: Boolean
        ) {
            INSTANCE = Game(
                players = players,
                tasks = tasks,
                difficulty = difficulty,
                adultMode = adultMode
            )
        }
    }

    /**
     * @return List of players
     */
    fun getPlayers(): List<Player> = this.players

    /**
     * @return List of tasks
     */
    fun getTasks(): List<Task> = this.tasks

    /**
     * @return Whether or not the current game has adult mode enabled
     */
    fun isAdultMode(): Boolean = this.adultMode

    /**
     * @return The value we want to multiply the sips with - a different constant for each difficulty
     */
    fun getSipMultiplier(): Int {
        return when(this.difficulty) {
            Difficulty.EASY -> 1
            Difficulty.MEDIUM -> 2
            Difficulty.HARD -> 3
            Difficulty.ALCOHOLIC -> 4
        }
    }

    /**
     * Resets all player's points and sips
     */
    fun reset() {
        for (player in this.players) {
            player.setPoints(points = 0)
            player.setSips(sips = 0)
        }
    }
}