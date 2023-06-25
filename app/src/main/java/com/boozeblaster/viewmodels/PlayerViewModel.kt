package com.boozeblaster.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.models.getPlayers
import com.boozeblaster.repositories.PlayerRepository
import com.boozeblaster.screens.AddPlayerUIEvent
import com.boozeblaster.screens.AddPlayerUIState
import com.boozeblaster.utils.Validator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val playerRepository: PlayerRepository) : ViewModel() {
    private val _playerListState = MutableStateFlow(listOf<Player>())
    val playerListState: StateFlow<List<Player>> = _playerListState.asStateFlow()


    var playerUIState by mutableStateOf(AddPlayerUIState())
        private set

    init {
        viewModelScope.launch {
            playerRepository.getAllPlayers()
                .collect { listOfPlayers ->
                    _playerListState.value = listOfPlayers
                }
        }
    }

    fun getAllPlayers(): Flow<List<Player>> {
        return playerRepository.getAllPlayers()
    }

    suspend fun addPlayer() {
        val player = playerUIState.toPlayer()
        playerRepository.addPlayer(player)
        //Game.addPlayer(player)
    }



    suspend fun updatePlayer(player: Player) {
        playerRepository.updatePlayer(player = player)
    }

    fun deletePlayer(player: Player) {
        playerRepository.deletePlayer(player = player)
    }

    fun updateUIState(newPlayerUIState: AddPlayerUIState, event: AddPlayerUIEvent) {
        var state = AddPlayerUIState()

        when (event) {
            is AddPlayerUIEvent.UsernameChanged -> {
                val usernameResult =
                    Validator.validateUsername(username = newPlayerUIState.name)
                state =
                    if (!usernameResult.success) {
                        newPlayerUIState.copy(nameError = true)
                    } else newPlayerUIState.copy(
                        nameError = false
                    )
            }
            else -> {}
        }

        playerUIState = state.copy(actionEnabled = !newPlayerUIState.hasError())
    }
}