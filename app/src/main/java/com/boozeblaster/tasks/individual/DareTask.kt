package com.boozeblaster.tasks.individual

import androidx.compose.runtime.Composable
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class DareTask(
    private val player: Player
) : IndividualTask(
    player = player,
    subTasks = emptyList()
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        //STUB
        onSurfaceClicked()
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        //STUB
        callback()
    }
}