package com.boozeblaster.models

import com.boozeblaster.enums.Genre
import org.junit.Assert.assertEquals
import org.junit.Test

class SongTest {

    private val songName = "Paranoid"
    private val artistName = "Black Sabbath"
    private val genre = Genre.ROCK

    @Test
    fun testCorrectSongName() {
        val song = Song(songName = songName, artistName = artistName, genre = genre)
        assertEquals(songName, song.getSongName())
    }

    @Test
    fun testCorrectArtistName() {
        val song = Song(songName = songName, artistName = artistName, genre = genre)
        assertEquals(artistName, song.getArtistName())
    }

    @Test
    fun testCorrectGenre() {
        val song = Song(songName = songName, artistName = artistName, genre = genre)
        assertEquals(genre, song.getGenre())
    }
}