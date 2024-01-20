package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.minigames.individual.HigherLower
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class HigherLowerTask(
    player: Player,
    subTasks: List<HigherLower>
) : IndividualTask(player = player, subTasks = subTasks) {

    override fun getName(): String = "Higher / Lower"

    override fun getImageId(): Int = R.drawable.higher_lower

    override fun getCoverDescription(): String = "monkaS"
}