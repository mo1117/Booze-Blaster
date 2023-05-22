package com.boozeblaster.repositories

import com.boozeblaster.data.PlayerDao
import com.boozeblaster.models.Player
import kotlinx.coroutines.flow.Flow

class PlayerRepository(private val playerDao: PlayerDao) {

    suspend fun addPlayer(player: Player) {
        playerDao.addPlayer(player = player)
    }

    suspend fun updatePlayer(player: Player) {
        playerDao.updatePlayer(player = player)
    }

    fun deletePlayer(player: Player) {
        playerDao.deletePlayer(player = player)
    }

    fun getAllPlayers(): Flow<List<Player>> {
        return playerDao.getAllPlayers()
    }

    companion object {
        @Volatile
        private var INSTANCE: PlayerRepository? = null

        fun getInstance(playerDao: PlayerDao): PlayerRepository {
            return INSTANCE ?: synchronized(lock = this) {
                INSTANCE ?: PlayerRepository(playerDao = playerDao).also {
                    INSTANCE = it
                }
            }
        }
    }
}