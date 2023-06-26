package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.Dare
import com.boozeblaster.models.Game

class DareGenerator : MiniGameGenerator() {

    /**
     * Here we return the complete list of dares, matching the dares to the players is done in our
     * DareTaskGenerator
     * @see com.boozeblaster.generators.DareTaskGenerator
     */
    override fun getList(): List<MiniGame> {
        return if (Game.isAdultMode()) adultModeList else normalList
    }

    /**
     * Normal list and adult mode list - make it inconvenient ;)
     */
    private companion object {
        private val normalList = listOf(
            Dare(dare = "Hug someone in this room!"),
            Dare(dare = "Ask your neighbor for some tea."),
            Dare(dare = "Attempt a cartwheel."),
            Dare(dare = "Tell a joke."),
            Dare(dare = "Yell out the first word that comes to your mind."),
            Dare(dare = "Do a magic trick."),
            Dare(dare = "Do your favorite TikTok dance."),
            Dare(dare = "Bark like a dog."),
            Dare(dare = "Pet somebody as if they are a dog."),
            Dare(dare = "Let someone go through your one for a minute."),
        )
        private val adultModeList = listOf(
            Dare(dare = "Drink a mystery drink created by the rest of the group."),
            Dare(dare = "Let the rest of the group DM someone from your Instagram."),
            Dare(dare = "Finish your drink."),
            Dare(dare = "Not allowed to talk until you finish your drink."),
            Dare(dare = "Reply to the first five Instagram stories on your timeline."),
            Dare(dare = "Let the other players go through your phone for one minute."),
            Dare(dare = "Take 3 shots."),
            Dare(dare = "Drink whatever the person to your left gives you."),
            Dare(dare = "Text your ex or finish your drink."),
            Dare(dare = "Chug down a beer!"),
            Dare(dare = "Do a back-flip!"),
            Dare(dare = "Remove your T-shirt!")
        )
    }
}