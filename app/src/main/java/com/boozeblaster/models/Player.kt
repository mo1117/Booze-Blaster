package com.boozeblaster.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The class representing an instance of a player
 *
 * @property Entity We want to store players in our database persistent
 */
@Entity
class Player(
    @PrimaryKey(autoGenerate = true)
    private val id: Int,
    private var name: String,
    private var birthDate: String,
    private var dare: String,
    private var points: Int = 0
) {

    fun getId(): Int = this.id

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String = this.name

    fun setBirthDate(birthDate: String) {
        this.birthDate = birthDate
    }

    fun getBirthDate(): String = this.birthDate

    fun setDare(dare: String) {
        this.dare = dare
    }

    fun getDare(): String = this.dare

    fun addPoints(points: Int) {
        this.points += points
        if (this.points < 0) {
            this.points = 0
        }
    }

    fun getPoints(): Int = this.points
}