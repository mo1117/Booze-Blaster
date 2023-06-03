package com.boozeblaster.tasks.individual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import kotlinx.coroutines.delay

class DareTask(
    private val player: Player
) : IndividualTask(
    player = player,
    subTasks = emptyList()
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
                SimpleTextDisplay(
                    text = "$player\n\nYou lost!\nTime to complete your dare!",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            }
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { callback() })
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = if (DarkmodeController.isDarkmode())
                        DarkBackGround else LightBackground
                )
            ) {
                SimpleTextDisplay(
                    text = "${player.getName()}\n\n${player.getDare()}",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            }
        }
    }
}