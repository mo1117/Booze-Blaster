package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.models.Game

class NeverHaveIEverGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        val list = if (Game.isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = 3, resetAllToUnused = false)
    }

    /**
     * Two lists consisting of NeverHaveIEver instances
     *
     * One list for the normal mode, and one for adult mode
     */
    private companion object {
        private val normalList = listOf(
            NeverHaveIEver(statement = "Never have I ever jumped out to scare someone."),
            NeverHaveIEver(statement = "Never have I ever eaten breakfast food for dinner."),
            NeverHaveIEver(statement = "Never have I ever fallen out of bed."),
            NeverHaveIEver(statement = "Never have I ever been left hanging for a high-five."),
            NeverHaveIEver(statement = "Never have I ever imagined I was someone else."),
            NeverHaveIEver(statement = "Never have I ever incorrectly answered a simple question " +
                    "about myself, such as “How old are you?”"),
            NeverHaveIEver(statement = "Never have I ever copied the work of the person next to me."),
            NeverHaveIEver(statement = "Never have I ever passed notes in class."),
            NeverHaveIEver(statement = "Never have I ever rode a motorcycle"),
            NeverHaveIEver(statement = "Never have I ever lost a bet"),
            NeverHaveIEver(statement = "Never have I ever broken a bone"),
            NeverHaveIEver(statement = "Never have I ever sang karaoke"),
            NeverHaveIEver(statement = "Never have I ever been on TV"),
            NeverHaveIEver(statement = "Never have I ever broken up with someone"),
            NeverHaveIEver(statement = "Never have I ever used someone else’s toothbrush"),
            NeverHaveIEver(statement = "Never have I ever fallen asleep in public"),
            NeverHaveIEver(statement = "Never have I ever lied to a boss"),
            NeverHaveIEver(statement = "Never have I ever regifted a gift"),
            NeverHaveIEver(statement = "Never have I ever gone on a road trip"),
            NeverHaveIEver(statement = "Never have I ever gone on a solo vacation"),
            NeverHaveIEver(statement = "Never have I ever gone 24 hours without showering"),
            NeverHaveIEver(statement = "Never have I ever gone viral online"),
            NeverHaveIEver(statement = "Never have I ever wanted to be on a reality TV show"),
            NeverHaveIEver(statement = "Never have I ever run a marathon"),
            NeverHaveIEver(statement = "Never have I ever been to a Disney park"),
            NeverHaveIEver(statement = "Never have I ever left someone on read"),
            NeverHaveIEver(statement = "Never have I ever lied about my age"),
            NeverHaveIEver(statement = "Never have I ever participated in a protest"),
            NeverHaveIEver(statement = "Never have I ever believed something was haunted"),
            NeverHaveIEver(statement = "Never have I ever regretted an apology"),
            NeverHaveIEver(statement = "Never have I ever disliked something that I cooked"),
            NeverHaveIEver(statement = "Never have I ever traveled to America"),
            NeverHaveIEver(statement = "Never have I ever met someone famous"),
            NeverHaveIEver(statement = "Never have I ever been on a sports team"),
            NeverHaveIEver(statement = "Never have I ever donated to a charity"),
            NeverHaveIEver(statement = "Never have I ever pretended to be sick to get out of something"),
            NeverHaveIEver(statement = "Never have I ever been fired. "),
            NeverHaveIEver(statement = "Never have I ever seen a ghost."),
            NeverHaveIEver(statement = "Never have I ever cheated in a board/card game."),
            NeverHaveIEver(statement = "Never have I ever Googled myself."),
            NeverHaveIEver(statement = "Never have I ever gotten a tattoo."),
            NeverHaveIEver(statement = "Never have I ever been to a psychic."),
            NeverHaveIEver(statement = "Never have I ever stayed up all night."),
            NeverHaveIEver(statement = "Never have I ever been on a cruise."),
            NeverHaveIEver(statement = "Never have I ever beaten a video game."),
            NeverHaveIEver(statement = "Never have I ever dyed my hair."),
            NeverHaveIEver(statement = "Never have I ever sleepwalked."),
            NeverHaveIEver(statement = "Never have I ever fainted."),
            NeverHaveIEver(statement = "Never have I ever wanted to go skydiving."),
            NeverHaveIEver(statement = "Never have I ever lived alone."),
        )
        private val adultModeList = listOf(
            NeverHaveIEver(statement = "Never have I ever done Cocaine in Munich."),
            NeverHaveIEver(statement = "Never have I ever wished someone would try something " +
                    "new in the bedroom."),
            NeverHaveIEver(statement = "Never have I ever fantasized about someone in this " +
                    "group while having alone time."),
            NeverHaveIEver(statement = "Never have I ever had dirty dreams about someone in this group."),
            NeverHaveIEver(statement = "Never have I ever looked up tips to be better in bed."),
            NeverHaveIEver(statement = "Never have I ever read a spicy book to get in the mood."),
            NeverHaveIEver(statement = "Never have I ever taken a secret picture of someone."),
            NeverHaveIEver(statement = "Never have I ever thought about having an open relationship."),
            NeverHaveIEver(statement = "Never have I ever wanted to bring sex toys into the bed."),
            NeverHaveIEver(statement = "Never have I ever gone skinny dipping."),
            NeverHaveIEver(statement = "Never have I ever faked an orgasm."),
            NeverHaveIEver(statement = "Never have I ever had sex in a public place."),
            NeverHaveIEver(statement = "Never have I ever been to an adult store."),
            NeverHaveIEver(statement = "Never have I ever taken a naked selfie."),
            NeverHaveIEver(statement = "Never have I ever sent nude photos to someone."),
            NeverHaveIEver(statement = "Never have I ever made a home sex video."),
            NeverHaveIEver(statement = "Never have I ever had phone sex."),
            NeverHaveIEver(statement = "Never have I ever kissed my best friend."),
            NeverHaveIEver(statement = "Never have I ever said I loved someone and didn’t mean it."),
            NeverHaveIEver(statement = "Never have I ever tried a flavored condom."),
            NeverHaveIEver(statement = "Never have I ever hooked up with a friend’s ex."),
            NeverHaveIEver(statement = "Never have I ever had sex in a swimming pool."),
            NeverHaveIEver(statement = "Never have I ever had sex in the ocean or on the beach."),
            NeverHaveIEver(statement = "Never have I ever worn a sexy Halloween costume."),
            NeverHaveIEver(statement = "Never have I ever use a vibrator."),
            NeverHaveIEver(statement = "Never have I ever flirted with a teacher or professor."),
            NeverHaveIEver(statement = "Never have I ever hooked up with a coworker."),
            NeverHaveIEver(statement = "Never have I ever slept with someone on the first date."),
            NeverHaveIEver(statement = "Never have I ever been catfished by someone"),
            NeverHaveIEver(statement = "Never have I ever drunk-dialed my ex."),
            NeverHaveIEver(statement = "Never have I ever dropped acid."),
            NeverHaveIEver(statement = "Never have I ever tried hard drugs."),
            NeverHaveIEver(statement = "Never have I ever smoked a joint."),
            NeverHaveIEver(statement = "Never have I ever been nude in public."),
            NeverHaveIEver(statement = "Never have I ever flashed someone."),
            NeverHaveIEver(statement = "Never have I ever got drunk playing these games."),
            NeverHaveIEver(statement = "Never have I ever thrown up when drunk."),
            NeverHaveIEver(statement = "Never have I ever had a threesome."),
            NeverHaveIEver(statement = "Never have I ever had sex in a bathroom."),
            NeverHaveIEver(statement = "Never have I ever shoplifted."),
            NeverHaveIEver(statement = "Never have I ever been arrested."),
            NeverHaveIEver(statement = "Never have I ever danced on a table."),
            NeverHaveIEver(statement = "Never have I ever been kicked out of a pub/bar/club."),
            NeverHaveIEver(statement = "Never have I ever had friends with benefits."),
            NeverHaveIEver(statement = "Never have I ever been in handcuffs."),
            NeverHaveIEver(statement = "Never have I ever quietly farted at work and then left the room."),
            NeverHaveIEver(statement = "Never have I ever partied for more than twenty-four hours straight."),
            NeverHaveIEver(statement = "Never have I ever pretended to get a text to leave a date."),
            NeverHaveIEver(statement = "Never have I ever talked about my ex on a first date.")
        )
    }
}