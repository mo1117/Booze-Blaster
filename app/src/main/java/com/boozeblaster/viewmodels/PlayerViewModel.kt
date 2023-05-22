package com.boozeblaster.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boozeblaster.models.Player
import com.boozeblaster.repositories.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(private val playerRepository: PlayerRepository): ViewModel() {
    private val _playerListState = MutableStateFlow(listOf<Player>())
    val playerListState: StateFlow<List<Player>> = _playerListState.asStateFlow()

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

    suspend fun addPlayer(player: Player) {
        playerRepository.addPlayer(player = player)
    }

    suspend fun updatePlayer(player: Player) {
        playerRepository.updatePlayer(player = player)
    }

    fun deletePlayer(player: Player) {
        playerRepository.deletePlayer(player = player)
    }
}