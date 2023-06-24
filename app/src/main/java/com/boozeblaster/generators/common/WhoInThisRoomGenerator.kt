package com.boozeblaster.generators.common

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.common.WhoInThisRoom
import com.boozeblaster.models.Game

class WhoInThisRoomGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        val list = if (Game.isAdultMode()) adultModeList else normalList
        return super.getList(list = list, amount = 4)
    }

    /**
     * Each question starts with "Who in this room..."
     *
     * One list for the normal mode, and one list for adult mode
     */
    private companion object {
        private val normalList = listOf(
            WhoInThisRoom(statement = "Is most likely to drive drunk?"),
            WhoInThisRoom(statement = "Is the biggest alcoholic?"),
            WhoInThisRoom(statement = "Speaks English most fluently?"),
            WhoInThisRoom(statement = "Speaks the most languages?"),
            WhoInThisRoom(statement = "Is the best car driver?"),
            WhoInThisRoom(statement = "Is the worst car driver?"),
            WhoInThisRoom(statement = "Is most likely to become a parent first?"),
            WhoInThisRoom(statement = "Looks the best?"),
            WhoInThisRoom(statement = "Smells the best?"),
            WhoInThisRoom(statement = "Smells the worst?"),
            WhoInThisRoom(statement = "Most likely to go to space?"),
            WhoInThisRoom(statement = "Most likely to live the longest?"),
            WhoInThisRoom(statement = "Most likely to become famous?"),
            WhoInThisRoom(statement = "Most likely to become a politician?"),
            WhoInThisRoom(statement = "Most likely to retire young?"),
            WhoInThisRoom(statement = "Most likely to be the favourite sibling?"),
            WhoInThisRoom(statement = "Most likely to win in a race?"),
            WhoInThisRoom(statement = "Most likely to give a sarcastic comment?"),
            WhoInThisRoom(statement = "Most likely to give money to charity?"),
            WhoInThisRoom(statement = "Most likely to do a nature poo?"),
            WhoInThisRoom(statement = "Most likely to blame something on someone else?"),
            WhoInThisRoom(statement = "Most likely to go a week without showering?"),
            WhoInThisRoom(statement = "Most likely to live in the wild?"),
            WhoInThisRoom(statement = "Most likely to go on a cruise?"),
            WhoInThisRoom(statement = "Most likely to become a pirate?"),
            WhoInThisRoom(statement = "Most likely to climb Everest?"),
            WhoInThisRoom(statement = "Most likely to visit every continent?"),
            WhoInThisRoom(statement = "Most likely to live abroad?"),
            WhoInThisRoom(statement = "Most likely to stay in a 1-star hotel?"),
            WhoInThisRoom(statement = "Most likely to stay in a 5-star hotel?"),
            WhoInThisRoom(statement = "Most likely to go travelling for 6 months?"),
            WhoInThisRoom(statement = "Most likely to marry their high school sweetheart?"),
            WhoInThisRoom(statement = "Most likely to cry during their wedding?"),
            WhoInThisRoom(statement = "Most likely to be a cool parent?"),
            WhoInThisRoom(statement = "Most likely to have kids?"),
            WhoInThisRoom(statement = "Most likely to cheat on a test?"),
            WhoInThisRoom(statement = "Most likely to win an Oscar?"),
            WhoInThisRoom(statement = "Most likely to move away?"),
            WhoInThisRoom(statement = "Most likely to survive a zombie apocalypse?"),
            WhoInThisRoom(statement = "Most likely to solve a Rubik’s Cube in less than 60 seconds?"),
            WhoInThisRoom(statement = "Who is most likely to make a sarcastic comment?"),
            WhoInThisRoom(statement = "Who is most likely to get stranded on an island?"),
            WhoInThisRoom(statement = "Who is most likely to look young forever?"),
            WhoInThisRoom(statement = "Who is most likely to eat pizza for breakfast?"),
            WhoInThisRoom(statement = "Who is most likely to keep a secret forever?"),
            WhoInThisRoom(statement = "Who is most likely to believe in aliens?"),
            WhoInThisRoom(statement = "Who is most likely to always cheat in a card game?"),
            WhoInThisRoom(statement = "Who is most likely to have a long and happy marriage?"),
            WhoInThisRoom(statement = "Who is most likely to get into a fight with anyone who touches their food?"),
            WhoInThisRoom(statement = "Who is most likely to tip very poorly?"),
        )
        private val adultModeList = listOf(
            WhoInThisRoom(statement = "Most likely to marry their cousin?"),
            WhoInThisRoom(statement = "Most likely to kiss on a first date?"),
            WhoInThisRoom(statement = "Most likely to pick up a stranger at a bar?"),
            WhoInThisRoom(statement = "Most likely to participate in an orgy?"),
            WhoInThisRoom(statement = "Most likely to eat gone off cheese?"),
            WhoInThisRoom(statement = "Most likely to have sex with another person in the room?"),
            WhoInThisRoom(statement = "Most likely to pass out in the club?"),
            WhoInThisRoom(statement = "Most likely to fall asleep on the toilet?"),
            WhoInThisRoom(statement = "Most likely to ghost someone?"),
            WhoInThisRoom(statement = "Most likely to talk dirty on the telephone?"),
            WhoInThisRoom(statement = "Most likely to lose their clothes on a night out?"),
            WhoInThisRoom(statement = "Most likely to text their crush on a night out?"),
            WhoInThisRoom(statement = "Most likely to have sex in the club?"),
            WhoInThisRoom(statement = "Most likely to get naked in public?"),
            WhoInThisRoom(statement = "Most likely to pay for everyone’s drinks?"),
            WhoInThisRoom(statement = "Most likely to swim in the nude?"),
            WhoInThisRoom(statement = "Most likely to text their ex when drunk?"),
            WhoInThisRoom(statement = "Most likely to double book a date?"),
            WhoInThisRoom(statement = "Most likely to do shots with the bar staff?"),
            WhoInThisRoom(statement = "Most likely to date two guys/girls at once?"),
            WhoInThisRoom(statement = "Most likely to forget the name of a person they hooked up with?"),
            WhoInThisRoom(statement = "Most likely to build a sex dungeon?"),
            WhoInThisRoom(statement = "Most likely to get caught with their ex?"),
            WhoInThisRoom(statement = "Most likely to hook up with their boss?"),
            WhoInThisRoom(statement = "Most likely to try a threesome?"),
            WhoInThisRoom(statement = "Most likely to make a sex tape?"),
            WhoInThisRoom(statement = "Most likely to be caught watching porn?"),
            WhoInThisRoom(statement = "Most likely to not use protection?"),
            WhoInThisRoom(statement = "Most likely to cheat on their partner?"),
            WhoInThisRoom(statement = "Most likely to moan the loudest during sex?"),
            WhoInThisRoom(statement = "Most likely to be into BDSM?"),
            WhoInThisRoom(statement = "Most likely to sleep with a colleague?"),
            WhoInThisRoom(statement = "Most likely to marry more than once?"),
            WhoInThisRoom(statement = "Most likely to end up in jail?"),
            WhoInThisRoom(statement = "Most likely to get away with murder?"),
            WhoInThisRoom(statement = "Most likely to die first if you were in a horror film?"),
            WhoInThisRoom(statement = "Most likely to shoplift?"),
            WhoInThisRoom(statement = "Most likely to end a relationship over text?"),
            WhoInThisRoom(statement = "Most likely to wake up without a hangover?"),
            WhoInThisRoom(statement = "Most likely to have a drink every day?"),
            WhoInThisRoom(statement = "Who is most likely to party hard every weekend?"),
            WhoInThisRoom(statement = "Who is most likely to sleep naked?"),
            WhoInThisRoom(statement = "Who is most likely to call their date by the wrong name?"),
            WhoInThisRoom(statement = "Who is most likely to send a nude picture?"),
            WhoInThisRoom(statement = "Who is most likely to doze off during sex?"),
            WhoInThisRoom(statement = "Who is most likely to have sex on a flight?"),
            WhoInThisRoom(statement = "Who is most likely to have a secret affair?"),
            WhoInThisRoom(statement = "Who is most likely to do a walk of shame?"),
            WhoInThisRoom(statement = "Who is most likely to say the wrong name while having sex?"),
            WhoInThisRoom(statement = "Who is most likely to try role-play?"),
        )
    }
}