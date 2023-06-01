package com.boozeblaster.tasks.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.minigames.common.SetRule
import com.boozeblaster.models.Game
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import kotlin.random.Random

class SetRuleTask(subTasks: List<SetRule> = emptyList()) : CommonTask(subTasks = emptyList()) {

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
                val players = Game.getInstance().getPlayers()
                val random = Random.nextInt(from = 0, until = players.size)
                val player = players.get(index = random)
                Text(text = "${player.getName()}")
                Spacer(Modifier.size(50.dp))
                Text(text = "Set A Rule")
            }
        }
    }

    /**
     * We do not display any content here - just invoke the callback() method instantly
     */
    @Composable
    override fun Display(callback: () -> Unit) {
        callback()
    }
}