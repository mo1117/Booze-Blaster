package com.boozeblaster.tasks.individual

import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.Task

/**
 * The base class representing all individual tasks
 *
 * An individual task always holds a player it is assigned to
 *
 * Each individual task can have multiple sub-tasks, e.g. Fact or Fiction consists of three
 * different statements that have to be marked as fact or fiction
 */
sealed class IndividualTask(
    private val player: Player,
    private val subTasks: List<MiniGame>
) : Task(player = player, subTasks = subTasks)