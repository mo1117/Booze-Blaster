package com.boozeblaster.minigames.versus

import com.boozeblaster.models.Player
import org.junit.Test

class SingASongTest {

    private val player = Player(name = "John")
    private val versusPlayer = Player(name = "Johanna")

    @Test
    fun test() {
        val singASong = SingASong(statement = "Sing something that...")
//        singASong.DisplayContent(player = player, callback = { /*TODO*/ }, versusPlayer = versusPlayer)
    }
}