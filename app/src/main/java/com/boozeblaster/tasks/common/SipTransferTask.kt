package com.boozeblaster.tasks.common

import com.boozeblaster.R
import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.tasks.CommonTask

class SipTransferTask(subTasks: List<SipTransfer>) : CommonTask(subTasks = subTasks) {

    override fun getName(): String = "Sip Transfer"

    override fun getImageId(): Int = R.drawable.handshake //TODO

    override fun getCoverDescription(): String = "The last round has started!\n\nYou will now " +
            "have limited time to trade points for sips!\n\nStart making offers to your teammates!"
}