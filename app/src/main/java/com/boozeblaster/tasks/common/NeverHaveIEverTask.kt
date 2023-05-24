package com.boozeblaster.tasks.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.tasks.CommonTask

class NeverHaveIEverTask(
    private val subTasks: List<NeverHaveIEver>
) : CommonTask(
    subTasks = subTasks
) {
    @Composable
    override fun Display(callback: () -> Unit) {
        var subTaskCounter by remember {
            mutableStateOf(0)
        }
        LaunchedEffect(key1 = this) {
            subTaskCounter = 0
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                subTasks.get(subTaskCounter).DisplayContent(
                    player = null,
                    callback = {
                        if (subTaskCounter == 2) {
                            callback()
                        } else {
                            subTaskCounter++
                        }
                    })
            }
        }
    }
}