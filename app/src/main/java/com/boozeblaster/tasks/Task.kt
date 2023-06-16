package com.boozeblaster.tasks

import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.tasks.common.SetRuleTask
import com.boozeblaster.tasks.common.SipTransferTask

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
abstract class Task {

    protected val fontSize = 16
    protected val fontFamily = FontFamily.SansSerif

    /**
     * This method is invoked before the Display() method
     *
     * Upon loading a new Task, we first display some information about the task that is to be
     * played next
     * @param onSurfaceClicked Invoke this method to start loading the subTasks
     */
    @Composable
    abstract fun DisplayCover(onSurfaceClicked: () -> Unit)

    /**
     * This method actually displays the current tasks content
     * @param callback Invoke this method to load the next subTask, if there is one
     */
    @Composable
    abstract fun Display(callback: () -> Unit)

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
            if (shouldDisplayOnlyCover(task = this)) {
                showCover = true
                callback()
            } else {
                Display(callback = {
                    showCover = true
                    callback()
                })
            }
        }
    }

    /**
     * For some tasks, we might only want to show the cover and no actual content
     * @param task Task
     * @return Whether we only want to show the cover for this task
     */
    private fun shouldDisplayOnlyCover(task: Task): Boolean {
        return task is SetRuleTask || this is SipTransferTask
    }
}