package com.boozeblaster.tasks

import androidx.compose.runtime.*
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

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
    subTasks: List<MiniGame>
) {
    private val maxPoints: Int = 4

    @Composable
    fun DisplayTask(callback: () -> Unit) {
        var showCover by remember {
            mutableStateOf(true)
        }
        LaunchedEffect(key1 = this) {
            showCover = true
        }
        if (showCover) {
            DisplayCover(onSurfaceClicked = {showCover = false} )
        } else {
            Display(callback = callback)
        }
    }

    @Composable
    abstract fun Display(callback: () -> Unit)

    @Composable
    abstract fun DisplayCover(onSurfaceClicked: () -> Unit)

    fun addPoints(player: Player, points: Int) {
        if (points > maxPoints) {
            player.addPoints(points = maxPoints)
        } else {
            player.addPoints(points = points)
        }
    }

    fun addSips(player: Player, sips: Int) {
        player.addSips(sips = sips)
    }
}