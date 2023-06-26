package com.boozeblaster.viewmodels

import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boozeblaster.models.Player
import com.boozeblaster.repositories.PlayerRepository
import com.boozeblaster.screens.AddPlayerUIEvent
import com.boozeblaster.screens.AddPlayerUIState
import com.boozeblaster.utils.Validator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val playerRepository: PlayerRepository) : ViewModel() {
    private val _playerListState = MutableStateFlow(listOf<Player>())

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
    }

    suspend fun updatePlayer(player: Player) {
        playerRepository.updatePlayer(player = player)
    }

    suspend fun deletePlayer(player: Player) {
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