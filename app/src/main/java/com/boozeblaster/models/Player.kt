package com.boozeblaster.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.boozeblaster.minigames.individual.Dare
import java.util.Date

/**
 * The class representing an instance of a player
 *
 * @property Entity We want to store players in our database persistent
 */
@Entity
data class Player(
    @PrimaryKey(autoGenerate = true)
    private val id: Int = 0,
    private var name: String,
    private var birthDate: Date
) {

    @Ignore()
    private var dare: Dare = Dare(dare = "")
    @Ignore()
    private var points: Int = 0
    @Ignore()
    private var sips: Int = 0

    fun getId(): Int = this.id

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String = this.name

    fun setBirthDate(birthDate: Date) {
        this.birthDate = birthDate
    }

    fun getBirthDate(): Date = this.birthDate

    fun setDare(dare: Dare) {
        this.dare = dare
    }

    fun getDare(): Dare = this.dare

    fun setPoints(points: Int) {
        this.points = points
    }

    fun addPoints(points: Int) {
        this.points += points
        if (this.points < 0) {
            this.points = 0
        }
    }

    fun getPoints(): Int = this.points


    fun setSips(sips: Int) {
        this.sips = sips
    }

    fun addSips(sips: Int) {
        this.sips += sips
    }

    fun getSips(): Int = this.sips
}