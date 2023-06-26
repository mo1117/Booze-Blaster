package com.boozeblaster.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Player

/**
 * This view model is responsible for storing the set difficulty and whether adult mode is enabled
 *
 * This is needed to ensure saving the state when a user navigates between the StartGameScreen,
 * AdultModePickerScreen, and DifficultyPickerScreen
 */
class GameSettingsViewModel : ViewModel() {
    private var _difficultyState: Difficulty? by mutableStateOf(value = null)
    private var _adultModeState: Boolean? by mutableStateOf(value = null)
    private var _addedPlayersState: MutableList<Player> by mutableStateOf(value = mutableListOf())
    private var _roundsState: Int by mutableStateOf(value = 0)

    fun setAdultMode(adultMode: Boolean?) {
        _adultModeState = adultMode
    }

    fun getAdultMode(): Boolean? = _adultModeState

    fun setDifficulty(difficulty: Difficulty?) {
        _difficultyState = difficulty
    }

    fun getDifficulty(): Difficulty? = _difficultyState

    fun setPlayers(players: List<Player>) {
        _addedPlayersState = players as MutableList<Player>
    }

    fun getAddedPlayers(): List<Player> = _addedPlayersState

    fun resetAddedPlayers() {
        _addedPlayersState = mutableListOf()
    }

    fun getSelectedRounds(): Int = _roundsState

    fun setSelectedRounds(rounds: Int) {
        _roundsState = rounds
    }
}