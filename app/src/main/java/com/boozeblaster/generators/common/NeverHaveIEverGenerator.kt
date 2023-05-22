package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.common.NeverHaveIEver

class NeverHaveIEverGenerator : MiniGameGenerator() {
    override fun getList(): List<NeverHaveIEver> {
        return super.getList(list = list) as List<NeverHaveIEver>
    }

    /**
     * Two lists consisting of NeverHaveIEver instances
     *
     * If adult mode is enabled, we can call super.getList with a combination of both lists
     */
    private companion object {
        val list = listOf(
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
        )
        val adultModeList = listOf(
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
            NeverHaveIEver(statement = ""),
        )
    }
}