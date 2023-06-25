package com.boozeblaster.data

import androidx.room.*
import com.boozeblaster.models.Player
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object representing a player
 *
 * Adding, updating, deleting, and reading all players is handled here
 */
@Dao
interface PlayerDao {

    @Insert
    suspend fun addPlayer(player: Player)

    @Update
    suspend fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Query("SELECT * FROM Player")
    fun getAllPlayers(): Flow<List<Player>>

}