package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.screens.Screen
import com.boozeblaster.tasks.Task

/**
 * The base class representing all individual tasks
 *
 * An individual task always holds a player it is assigned to
 *
 * Each individual task can have multiple sub-tasks, e.g. Fact or Fiction consists of three
 * different statements that have to be marked as fact or fiction
 *
 * For each subtask points can be earned - this must not exceed the maximal points (4) achievable!
 */
abstract class IndividualTask(
    private val player: Player,
    private val subTasks: List<MiniGame>
) : Task() {

    /**
     * Only implemented in the specific individual tasks (!)
     */
    @Composable
    abstract override fun DisplayContent()
}