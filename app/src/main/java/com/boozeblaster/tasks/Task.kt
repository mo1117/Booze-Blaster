package com.boozeblaster.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

/**
 * The base class representing a Task
 *
 * A Task is either an IndividualTask or a CommonTask
 *
 * Individual Tasks are assigned to a specific player, for Common Tasks all players can achieve points
 *
 * @see IndividualTask
 * @see CommonTask
 */
abstract class Task(
    private val player: Player? = null,
    private val subTasks: List<MiniGame> = emptyList(),
    private val versusPlayer: Player? = null
) {

    private val headerFontSize = 30
    private val headerFontFamily = headerFont
    private val nameFontSize = 26
    private val nameFontFamily = FontFamily.SansSerif
    protected val fontSize = 18
    protected val fontFamily = FontFamily.SansSerif

    /**
     * This method is invoked before the Display() method
     *
     * Upon loading a new Task, we first display some information about the task that is to be
     * played next
     * @param onSurfaceClicked Invoke this method to start loading the subTasks
     */
    @Composable
    open fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = onSurfaceClicked,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            SimpleTextDisplay(
                text = getName(),
                fontSize = headerFontSize,
                fontFamily = headerFontFamily
            )

            SimpleSpacer(size = 30)

            if (player != null && versusPlayer != null) {
                SimpleTextDisplay(
                    text = "${player.getName()} versus ${versusPlayer.getName()}",
                    fontSize = nameFontSize,
                    fontFamily = nameFontFamily
                )
            } else if (player != null) {
                SimpleTextDisplay(
                    text = player.getName(),
                    fontSize = nameFontSize,
                    fontFamily = nameFontFamily
                )
                SimpleSpacer(size = 30)
            }

            Image(
                modifier = Modifier.size(size = 100.dp),
                painter = painterResource(id = getImageId()),
                contentDescription = "${getName()} Cover Image"
            )

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = getCoverDescription(),
                fontSize = fontSize,
                fontFamily = fontFamily,
                horizontalTextPadding = 15
            )
        }
    }

    /**
     * This method actually displays the current tasks content
     * @param callback Invoke this method to load the next subTask, if there is one
     */
    @Composable
    open fun Display(callback: () -> Unit) {
        var subTaskCounter by remember {
            mutableStateOf(0)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            subTasks.get(index = subTaskCounter).DisplayContent(
                player = player,
                callback = {
                    if (subTaskCounter == subTasks.size - 1) {
                        subTaskCounter = 0
                        callback()
                    } else {
                        subTaskCounter++
                    }
                }
            )
        }
    }

    /**
     * This method handles displaying a certain Task
     *
     * @param callback Invoke this method to tell the GameScreen to load the next Task
     */
    @Composable
    fun DisplayTask(callback: () -> Unit) {
        var showCover by remember {
            mutableStateOf(true)
        }

        if (showCover) {
            DisplayCover(onSurfaceClicked = { showCover = false })
        } else {
            Display(callback = {
                showCover = true
                callback()
            })
        }
    }

    protected abstract fun getName(): String

    protected abstract fun getImageId(): Int

    protected abstract fun getCoverDescription(): String
}