package com.boozeblaster.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.boozeblaster.models.Player

/**
 * The database for the Player(s)
 *
 * Implemented as singleton since we do not want more than one instance of this database
 */
@Database(
    entities = [Player::class],
    version = 2,
    exportSchema = false
)

abstract class PlayerDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        private var INSTANCE: PlayerDatabase? = null

        fun getInstance(context: Context): PlayerDatabase {
            return INSTANCE ?: synchronized(lock = this) {
                Room.databaseBuilder(
                    context = context, klass = PlayerDatabase::class.java,
                    name = "player_db"
                ).addCallback(
                    object : Callback() {
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                        }
                    }
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}