package com.boozeblaster.enums

enum class AnimationConstants(val durationMillis: Int) {

    SHOW_SOLUTION_FADE_IN_OUT(durationMillis = 300),

    POINTS_OR_SIPS_FADE_IN_OUT(durationMillis = 750),

    POINTS_OR_SIPS_DIALOG(durationMillis = 2000),

    SIPS_FADE_IN_OUT(durationMillis = 750),

    SIPS_DIALOG(durationMillis = 2000),

    ADD_EXISTING_PLAYERS_FADE_IN_OUT(durationMillis = 600),

    PLAYER_PICKER_FADE_IN_OUT(durationMillis = 600),

    CONTINUE_BUTTON_FADE_IN(durationMillis = 1000)

}