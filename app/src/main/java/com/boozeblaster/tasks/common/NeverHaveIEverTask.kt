package com.boozeblaster.tasks.common

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.tasks.CommonTask

class NeverHaveIEverTask(
    private val subTasks: List<NeverHaveIEver>
) : CommonTask(
    subTasks = subTasks
) {
    @Composable
    override fun DisplayContent() {
        TODO("Not yet implemented")
    }
}