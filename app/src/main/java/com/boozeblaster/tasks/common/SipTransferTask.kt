package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.generators.common.SipTransferGenerator
import com.boozeblaster.minigames.MiniGame

class SipTransferTask(subTasks: List<MiniGame> = SipTransferGenerator().getList()) :
    CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Sip Transfer"

    override fun getImageId(): Int = R.drawable.handshake

    override fun getCoverDescription(): String = "The last round has started!\n\nYou will now " +
            "have limited time to trade points for sips!\n\nStart making offers to your teammates!"
}