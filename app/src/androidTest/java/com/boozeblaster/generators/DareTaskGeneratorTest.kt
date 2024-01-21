package com.boozeblaster.generators

import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Player
import org.junit.Test
import org.junit.Assert.assertTrue

class DareTaskGeneratorTest {

    private val players = listOf(Player(name = "John"), Player(name = "Mary"))

    @Test
    fun testUsedDaresAreEmptyInitially() {
        val usedDaresField = DareTaskGenerator::class.java.getDeclaredField("usedDares")
        usedDaresField.isAccessible = true
        assertTrue((usedDaresField.get(null) as Array<Dare>).isEmpty())
    }

    @Test
    fun testAssignDares() {
        DareTaskGenerator.assignDares(players = players)
        assertTrue(players.stream().allMatch{player -> player.getDare() != null})
    }

    @Test
    fun testAssignDaresAddsDaresToUsedDares() {
        val usedDaresField = DareTaskGenerator::class.java.getDeclaredField("usedDares")
        usedDaresField.isAccessible = true
        DareTaskGenerator.assignDares(players = players)
        assertTrue((usedDaresField.get(null) as Array<Dare>).isNotEmpty())
    }

    @Test
    fun testResetUsedDares() {
        val usedDaresField = DareTaskGenerator::class.java.getDeclaredField("usedDares")
        usedDaresField.isAccessible = true
        DareTaskGenerator.assignDares(players = players)
        DareTaskGenerator.resetUsedDares()
        assertTrue((usedDaresField.get(null) as Array<Dare>).isEmpty())
    }
}