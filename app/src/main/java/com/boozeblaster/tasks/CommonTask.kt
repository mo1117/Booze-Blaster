package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame

abstract class CommonTask(
    private val subTasks: List<MiniGame>
) : Task(
    subTasks = subTasks
) {
    @Composable
    abstract override fun Display(callback: () -> Unit)
}