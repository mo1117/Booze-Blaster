package com.boozeblaster.models

import com.boozeblaster.enums.Genre

/**
 * Abstract class Song used for both GuessTheLyrics and GuessTheSong minigames
 */
class Song(
    private val songName: String,
    private val artistName: String,
    private val genre: Genre
) {

    fun getSongName() = this.songName
    fun getArtistName() = this.artistName

    fun getGenre() = this.genre
}