package com.boozeblaster.utils

import android.content.Context
import com.boozeblaster.data.PlayerDatabase
import com.boozeblaster.repositories.PlayerRepository
import com.boozeblaster.viewmodelFactories.PlayerViewModelFactory

object InjectorUtils {

    private fun getPlayerRepository(context: Context): PlayerRepository {
        return PlayerRepository.getInstance(
            PlayerDatabase.getInstance(context.applicationContext).playerDao()
        )
    }

    fun providePlayerViewModelFactory(context: Context): PlayerViewModelFactory {
        val playerRepository = getPlayerRepository(context = context)
        return PlayerViewModelFactory(playerRepository = playerRepository)
    }
}