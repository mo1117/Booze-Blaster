package com.boozeblaster.models

import com.boozeblaster.minigames.individual.Dare
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class PlayerTest {

    private val playerName = "John"
    private val player = Player(name = playerName)
    private val dare = Dare(dare = "Do something")

    @Test
    fun testGetID() {
        assertEquals(0, player.getId())
    }

    @Test
    fun testGetName() {
        assertEquals(playerName, player.getName())
    }

    @Test
    fun testSetGetDare() {
        assertNull("The initial dare should be null!", player.getDare())
        player.setDare(dare = dare)
        assertEquals(dare, player.getDare())
    }

    @Test
    fun testGetSetPoints() {
        player.setPoints(points = 5)
        assertEquals(5, player.getPoints())
    }

    @Test
    fun testAddPoints() {
        player.addPoints(points = 4)
        assertEquals(4, player.getPoints())
    }

    @Test
    fun testSubtractPoints() {
        player.setPoints(points = 10)
        player.subtractPoints(points = 7)
        assertEquals(3, player.getPoints())
    }

//    @Test
//    fun testSubtractPointsShouldTriggerLogWarning() {
//        player.setPoints(points = 3)
//        player.subtractPoints(points = 4)
//    }

    @Test
    fun testGetSetSips() {
        player.setSips(sips = 5)
        assertEquals(5, player.getSips())
    }

    @Test
    fun testAddSips() {
        player.setSips(sips = 5)
        player.addSips(sips = 12)
        assertEquals(17, player.getSips())
    }
}