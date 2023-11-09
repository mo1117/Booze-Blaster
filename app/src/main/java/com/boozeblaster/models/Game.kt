package com.boozeblaster.models

import com.boozeblaster.enums.Difficulty
import com.boozeblaster.generators.DareTaskGenerator
import com.boozeblaster.generators.TaskGenerator
import com.boozeblaster.tasks.Task

/**
 * The Game class represents an instance that holds all the tasks that will then be played
 *
 * This class is implemented as a singleton since we do not want more than one instance of a Game
 */
class Game private constructor(
    private var players: MutableList<Player>,
    private var tasks: List<Task>,
    private var rounds: Int,
    private var difficulty: Difficulty = Difficulty.MEDIUM,
    private var adultMode: Boolean
) {
    companion object {
        @Volatile
        private var INSTANCE: Game = Game(
            players = mutableListOf(),
            tasks = emptyList(),
            rounds = 1,
            adultMode = false
        )

        /**
         * Loads the tasks and dares
         */
        fun load() {
            resetAllPoints()
            resetAllDares()
            INSTANCE.tasks = TaskGenerator.generateTasks(
                players = INSTANCE.players,
                rounds = INSTANCE.rounds
            )
        }

        /**
         * Resets the game
         */
        fun reset() {
            for (player in INSTANCE.players) {
                player.setPoints(points = 0)
                player.setSips(sips = 0)
                player.setDare(dare = null)
            }
            INSTANCE.players = mutableListOf()
            DareTaskGenerator.resetUsedDares()
        }

        /**
         * Resets all dares to null value
         */
        fun resetAllDares() {
            for (player in INSTANCE.players) {
                player.setDare(dare = null)
            }
            DareTaskGenerator.resetUsedDares()
        }

        /**
         * Resets all players' points to zero
         */
        fun resetAllPoints() {
            INSTANCE.players.stream().forEach { player -> player.setPoints(points = 0) }
        }

        fun getPlayersByPointsDescending(): List<Player> {
            return getPlayers().sortedByDescending(selector = { player -> player.getPoints() })
        }

        /**
         * @return List of players
         */
        fun getPlayers(): List<Player> = INSTANCE.players

        /**
         * Add a player
         */
        fun setPlayers(players: List<Player>) {
            INSTANCE.players = players as MutableList<Player>
        }

        /**
         * @return List of tasks
         */
        fun getTasks(): List<Task> = INSTANCE.tasks

        /**
         * @return Specific task with given index
         */
        fun getTask(index: Int): Task = INSTANCE.tasks.get(index = index)

        /**
         * @return Player(s) with the least points (2 if at least 5 players played)
         */
        fun getLosers(): List<Player> {
            return INSTANCE.players // List of players based on their points (ascending)
                .sortedWith(comparator = compareBy(selector = { player -> player.getPoints() }))
                .subList(fromIndex = 0, toIndex = 1 + INSTANCE.players.size / 5)
        }

        /**
         * @return Player(s) with the most points (2 if at least players played, 3 if at least 8 players played)
         */
        fun getWinners(): List<Player> {
            val toIndex =
                if (INSTANCE.players.size > 4) 2 else if (INSTANCE.players.size > 7) 3 else 1
            return INSTANCE.players
                .sortedWith(comparator = compareByDescending(selector = { player -> player.getPoints() }))
                .subList(fromIndex = 0, toIndex = toIndex)
        }

        /**
         * Set the adult mode to enabled or disabled
         * @param adultMode Boolean
         */
        fun setAdultMode(adultMode: Boolean) {
            INSTANCE.adultMode = adultMode
        }

        /**
         * @return Whether or not the current game has adult mode enabled
         */
        fun isAdultMode(): Boolean = INSTANCE.adultMode

        fun setRounds(rounds: Int) {
            INSTANCE.rounds = rounds
        }

        /**
         * @return Amount of rounds to be played for INSTANCE game
         */
        fun getRounds(): Int = INSTANCE.rounds

        /**
         * @return The value we want to multiply the sips with - a different constant for each difficulty
         */
        fun getSipMultiplier(): Int {
            return when (INSTANCE.difficulty) {
                Difficulty.EASY -> 1
                Difficulty.MEDIUM -> 2
                Difficulty.HARD -> 3
                Difficulty.ALCOHOLIC -> 4
            }
        }

        fun setDifficulty(difficulty: Difficulty) {
            INSTANCE.difficulty = difficulty
        }
    }
}