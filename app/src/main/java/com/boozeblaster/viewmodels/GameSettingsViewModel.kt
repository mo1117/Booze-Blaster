package com.boozeblaster.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.generators.DareTaskGenerator

/**
 * This view model is responsible for storing the set difficulty and whether adult mode is enabled
 *
 * This is needed to ensure saving the state when a user navigates between the StartGameScreen,
 * AdultModePickerScreen, and DifficultyPickerScreen
 */
class GameSettingsViewModel : ViewModel() {
    private var _difficultyState: Difficulty? by mutableStateOf(value = null)
    private var _adultModeState: Boolean? by mutableStateOf(value = null)
    private var _daresAssignedState: Boolean by mutableStateOf(value = false)

    fun setAdultMode(adultMode: Boolean?) {
        _adultModeState = adultMode
    }

    fun getAdultMode(): Boolean? = _adultModeState

    fun setDifficulty(difficulty: Difficulty?) {
        _difficultyState = difficulty
    }

    fun getDifficulty(): Difficulty? = _difficultyState
}