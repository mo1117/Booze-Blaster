package com.boozeblaster.utils

import com.boozeblaster.enums.Genre
import com.boozeblaster.minigames.MiniGame

interface GenrePicker {

    fun getListForGenre(genre: Genre) : List<MiniGame>

}