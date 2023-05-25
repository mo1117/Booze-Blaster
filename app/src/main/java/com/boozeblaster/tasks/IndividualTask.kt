package com.boozeblaster.tasks

import androidx.compose.runtime.*
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

/**
 * The base class representing all individual tasks
 *
 * An individual task always holds a player it is assigned to
 *
 * Each individual task can have multiple sub-tasks, e.g. Fact or Fiction consists of three
 * different statements that have to be marked as fact or fiction
 */
abstract class IndividualTask(
    player: Player,
    subTasks: List<MiniGame>
) : Task(
    subTasks = subTasks
) {
    @Composable
    abstract override fun Display(callback: () -> Unit)

    @Composable
    abstract override fun DisplayCover(onSurfaceClicked: () -> Unit)
}