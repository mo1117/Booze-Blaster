package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.tasks.Task

abstract class CommonTask(
    private val subTasks: List<MiniGame>
) : Task() {
    @Composable
    abstract override fun displayContent()
}