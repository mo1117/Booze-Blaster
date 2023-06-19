package com.boozeblaster.models

import android.util.Log
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.generators.DareTaskGenerator
import com.boozeblaster.generators.TaskGenerator
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.individual.DareTask

/**
 * The Game class represents an instance that holds all the tasks that will then be played
 *
 * This class is implemented as a singleton since we do not want more than one instance of a Game
 */
class Game private constructor(
    private val players: List<Player>,
    private var tasks: List<Task>,
    private val rounds: Int,
    private var difficulty: Difficulty = Difficulty.MEDIUM,
    private var adultMode: Boolean
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
                Log.e(
                    "Game",
                    "Could not return Singleton instance of Game. Have you tried " +
                            "initializing it before?"
                )
                Log.w("Game", "EMPTY GAME CREATED!")
                INSTANCE = Game(
                    players = emptyList(),
                    tasks = emptyList(),
                    rounds = 0,
                    adultMode = false
                )
            }
            return INSTANCE!! // Not-null assertion operator can be used safely here
        }

        /**
         * Initializes a new game instance
         * @param players List of players to play the game
         * @param rounds Amount of rounds to be played
         * @param difficulty Difficulty
         * @param adultMode Whether or not adult mode is enabled
         * @see Difficulty
         */
        fun init(
            players: List<Player>,
            rounds: Int,
            difficulty: Difficulty = Difficulty.MEDIUM,
            adultMode: Boolean
        ) {
            INSTANCE = Game(
                players = players,
                tasks = TaskGenerator.generateTasks(players = players, rounds = rounds),
                rounds = rounds,
                difficulty = difficulty,
                adultMode = adultMode
            )
            DareTaskGenerator.assignDares(players = players)
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
     * @return Specific task with given index
     */
    fun getTask(index: Int): Task = this.tasks.get(index = index)

    /**
     * Appends the dare tasks of the 1 to 2 losers to the task list
     */
    fun appendDareTasks() {
        val losers = players // List of players based on their points (ascending)
            .sortedWith(comparator = compareBy(selector = { player -> player.getPoints() }))
            .subList(fromIndex = 0, toIndex = 2) // Take only the last two (two losers max)

        tasks = tasks.plus(DareTask(player = losers.get(index = 0)))

        if (players.size > 5) {
            tasks = tasks.plus(DareTask(player = losers.get(index = 1)))
        }
    }

    /**
     * Set the adult mode to enabled or disabled
     * @param adultMode Boolean
     */
    fun setAdultMode(adultMode: Boolean) {
        this.adultMode = adultMode
    }

    /**
     * @return Whether or not the current game has adult mode enabled
     */
    fun isAdultMode(): Boolean = this.adultMode

    /**
     * @return Amount of rounds to be played for this game
     */
    fun getRounds(): Int = this.rounds

    /**
     * @return The value we want to multiply the sips with - a different constant for each difficulty
     */
    fun getSipMultiplier(): Int {
        return when (this.difficulty) {
            Difficulty.EASY -> 1
            Difficulty.MEDIUM -> 2
            Difficulty.HARD -> 3
            Difficulty.ALCOHOLIC -> 4
        }
    }

    fun setDifficulty(difficulty: Difficulty) {
        this.difficulty = difficulty
    }

    /**
     * Resets all player's points and sips
     */
    fun reset() {
        for (player in this.players) {
            player.setPoints(points = 0)
            player.setSips(sips = 0)
        }
        this.tasks = TaskGenerator.generateTasks(players = players, rounds = rounds)
    }
}