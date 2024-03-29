package com.boozeblaster.tasks.versus

import com.boozeblaster.R
import com.boozeblaster.minigames.versus.SingASong
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.VersusTask

class SingASongTask(player: Player, subTasks: List<SingASong>, versusPlayer: Player) :
    VersusTask(player = player, subTasks = subTasks, versusPlayer = versusPlayer) {
    override fun getName(): String = "Sing A Song"

    override fun getImageId(): Int = R.drawable.karaoke

    override fun getCoverDescription(): String = "Prepare your vocal chords - you will have " +
            "to sing!\n\nHand the phone over to an unbiased referee that will then read each " +
            "instruction loud and clear.\n\nWhoever starts singing first will receive points, " +
            "the other one has to drink!\n\nFor some songs, the crowd will decide if it was " +
            "appropriate or not!\n\nIf someone sings a false / unsuitable song the other player " +
            "wins by default!"
}