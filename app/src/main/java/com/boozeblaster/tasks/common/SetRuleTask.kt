package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.generators.common.SetRuleGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game

class SetRuleTask(subTasks: List<MiniGame> = SetRuleGenerator().getList()) :
    CommonTask(subTasks = emptyList()) {

    override fun getName(): String = "Set A Rule"

    override fun getImageId(): Int = R.drawable.judge_hammer_black

    override fun getCoverDescription(): String = "Set any rule you want!\n\nPlayers that break " +
            "this rule have to drink ${Game.getSipMultiplier()} sips!\n\n" +
            "This rule is in effect for the rest of the game!"
}