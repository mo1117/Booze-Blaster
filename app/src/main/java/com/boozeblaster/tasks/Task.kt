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
import com.boozeblaster.composables.PickGenre
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.Genre
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.common.SetRuleTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont
import com.boozeblaster.utils.GenrePicker

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
    private var subTasks: List<MiniGame> = emptyList(),
    private val versusPlayer: Player? = null
) {

    private val headerFontSize = 30
    private val headerFontFamily = headerFont
    private val nameFontSize = 26
    private val nameFontFamily = FontFamily.SansSerif
    protected val fontSize = 20
    protected val fontFamily = FontFamily.SansSerif

    /**
     * This method is invoked before the Display() method
     *
     * Upon loading a new Task, we first display some information about the task that is to be
     * played next
     * @param onSurfaceClicked Invoke this method to start loading the subTasks
     */
    @Composable
    fun DisplayCover(onSurfaceClicked: () -> Unit) {
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
            }

            SimpleSpacer(size = 30)

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
    fun Display(callback: () -> Unit) {
        var subTaskCounter by remember {
            mutableStateOf(value = 0)
        }

        var genre: Genre? by remember {
            mutableStateOf(value = null)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            if (genre == null && subTasks.shouldAskForGenre()) {
                PickGenre(
                    pickRock = {
                        genre = Genre.ROCK
                        setSubTasksBasedOnGenre(genre = genre!!)
                    },
                    pickRap = {
                        genre = Genre.RAP
                        setSubTasksBasedOnGenre(genre = genre!!)
                    },
                    pickHipHop = {
                        genre = Genre.HIP_HOP
                        setSubTasksBasedOnGenre(genre = genre!!)
                    },
                    pickPop = {
                        genre = Genre.POP
                        setSubTasksBasedOnGenre(genre = genre!!)
                    }
                )
            } else {
                subTasks.get(index = subTaskCounter).DisplayContent(
                    player = player,
                    callback = {
                        if (subTaskCounter == subTasks.size - 1) {
                            subTaskCounter = 0
                            callback()
                        } else {
                            subTaskCounter++
                        }
                    },
                    versusPlayer = versusPlayer
                )
            }
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
            DisplayCover(onSurfaceClicked = {
                if (shouldOnlyDisplayCover()) {
                    callback()
                } else {
                    showCover = false
                }
            })
        } else {
            Display(callback = {
                showCover = true
                callback()
            })
        }
    }

    private fun shouldOnlyDisplayCover(): Boolean {
        return this is SetRuleTask
    }

    abstract fun getName(): String

    abstract fun getImageId(): Int

    abstract fun getCoverDescription(): String

    private fun List<MiniGame>.shouldAskForGenre(): Boolean {
        return this.all { it is GenrePicker }
    }

    private fun setSubTasksBasedOnGenre(genre: Genre) {
        subTasks = (subTasks.get(index = 0) as GenrePicker).getListForGenre(genre = genre)
    }
}