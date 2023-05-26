package com.boozeblaster.tasks

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame

abstract class CommonTask(
    subTasks: List<MiniGame>
) : Task() {
    @Composable
    abstract override fun Display(callback: () -> Unit)

    @Composable
    abstract override fun DisplayCover(onSurfaceClicked: () -> Unit)
}