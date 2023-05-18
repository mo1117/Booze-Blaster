package com.boozeblaster.models

import com.boozeblaster.tasks.Task

/**
 * The Game class represents an instance that holds all the tasks that will then be played
 *
 * This class is implemented as a singleton since we do not want more than one instance of a Game
 */
class Game private constructor(
    private val players: List<Player>,
    private val tasks: List<Task>
) {
    companion object {
        @Volatile
        private var INSTANCE: Game? = null

        /**
         * Call this method only with arguments when instantiating the instance
         * @param players Players
         * @param tasks Tasks
         * @return Singleton instance of Game
         */
        fun getInstance(
            players: List<Player> = listOf(),
            tasks: List<Task> = listOf()
        ): Game {
            if (INSTANCE == null) {
                INSTANCE = Game(players = players, tasks = tasks)
            }
            return INSTANCE!! // Not-null assertion operator can be used safely here
        }
    }
}