package com.boozeblaster.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
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
    private val player: Player,
    private val subTasks: List<MiniGame>
) : Task(player = player, subTasks = subTasks)