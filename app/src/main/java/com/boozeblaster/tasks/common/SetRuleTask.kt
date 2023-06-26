package com.boozeblaster.tasks.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.common.SetRule
import com.boozeblaster.models.Game
import com.boozeblaster.tasks.CommonTask
import kotlin.random.Random

class SetRuleTask(subTasks: List<SetRule> = emptyList()) : CommonTask(subTasks = emptyList()) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = onSurfaceClicked,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val players = Game.getPlayers()
            val random = Random.nextInt(from = 0, until = players.size)
            val player = players.get(index = random)

            SimpleSpacer(size = 50)
            SimpleTextDisplay(
                text = player.getName(),
                fontSize = 30,
                fontFamily = FontFamily.SansSerif
            )
            SimpleSpacer(size = 50)
            SimpleTextDisplay(
                text = "Set any rule you want!\n\nPlayers that break this rule have to " +
                        "drink ${Game.getSipMultiplier()} sips!\n" +
                        "This rule is in effect for the rest of the game!",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        callback()
    }
}