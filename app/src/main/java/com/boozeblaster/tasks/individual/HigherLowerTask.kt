package com.boozeblaster.tasks.individual

import com.boozeblaster.R
import com.boozeblaster.generators.individual.HigherLowerGenerator
import com.boozeblaster.models.Player

class HigherLowerTask(
    player: Player
) : IndividualTask(player = player, subTasks = HigherLowerGenerator().getList()) {

    override fun getName(): String = "Higher / Lower"

    override fun getImageId(): Int = R.drawable.higher_lower

    override fun getCoverDescription(): String = "You'll be presented with a specific term and " +
            "a corresponding number, indicating its average monthly Google search frequency.\n\n" +
            "Following that, a second term will be provided, and your task is to determine whether " +
            "it is searched more frequently or less frequently than the initial term!"
}