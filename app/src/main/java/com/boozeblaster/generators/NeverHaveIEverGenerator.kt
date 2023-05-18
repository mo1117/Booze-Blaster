package com.boozeblaster.generators

import com.boozeblaster.minigames.common.NeverHaveIEver

class NeverHaveIEverGenerator : MiniGameGenerator() {
    override fun getList(): List<NeverHaveIEver> {
        return super.getList(list = list) as List<NeverHaveIEver>
    }

    private companion object {
        val list = listOf<NeverHaveIEver>()
    }
}