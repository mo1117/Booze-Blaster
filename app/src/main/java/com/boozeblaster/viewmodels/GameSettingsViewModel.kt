package com.boozeblaster.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.boozeblaster.enums.Difficulty

/**
 * This view model is responsible for storing the set difficulty and whether adult mode is enabled
 *
 * This is needed to ensure saving the state when a user navigates between the StartGameScreen,
 * AdultModePickerScreen, and DifficultyPickerScreen
 */
class GameSettingsViewModel : ViewModel() {
    private var _difficultyState: Difficulty? by mutableStateOf(value = null)
    private var _adultmodeState: Boolean? by mutableStateOf(value = null)

    fun setAdultMode(adultMode: Boolean?) {
        _adultmodeState = adultMode
    }

    fun getAdultMode() : Boolean? = _adultmodeState

    fun setDifficulty(difficulty: Difficulty?) {
        _difficultyState = difficulty
    }

    fun getDifficulty() : Difficulty? = _difficultyState

}