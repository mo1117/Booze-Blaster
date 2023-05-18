package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.models.Player
import com.boozeblaster.screens.Screen

/**
 * The base class representing a Task
 *
 * A Task is either an IndividualTask or a CommonTask
 *
 * Individual Tasks are assigned to a specific player, for Common Tasks all players can achieve points
 *
 * @see IndividualTask
 * @see CommonTask
 */
abstract class Task(
) {
    private val maxPoints: Int = 4

    /**
     * Needs implementation in the specific Task classes
     *
     * Used to display the content for the GameScreen
     */
    @Composable
    abstract fun displayContent()


    /**
     * Method responsible for adding points to a player
     * @param player Player that gets points added
     * @param points Points to be added
     */
    fun addPoints(player: Player, points: Int) {
        if (points > maxPoints) {
            player.addPoints(points = maxPoints)
        } else {
            player.addPoints(points = points)
        }
    }
}