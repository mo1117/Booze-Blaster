package com.boozeblaster.viewmodelFactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.boozeblaster.repositories.PlayerRepository
import com.boozeblaster.viewmodels.PlayerViewModel

class PlayerViewModelFactory(private val playerRepository: PlayerRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            return PlayerViewModel(playerRepository = playerRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class!")
    }
}