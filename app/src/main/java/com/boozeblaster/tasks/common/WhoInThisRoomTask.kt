package com.boozeblaster.tasks.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.minigames.common.WhoInThisRoom
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground

class WhoInThisRoomTask(
    private val subTasks: List<WhoInThisRoom>
) : CommonTask(
    subTasks = subTasks
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { onSurfaceClicked() })
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = if (DarkmodeController.isDarkmode())
                        DarkBackGround else LightBackground
                )
            ) {
                Text(text = "WhoInThisRoom")
                Spacer(Modifier.size(50.dp))
            }
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        var subTaskCounter by remember {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = if (DarkmodeController.isDarkmode())
                        DarkBackGround else LightBackground
                )
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