package com.boozeblaster.generators.individual

import com.boozeblaster.R
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheSong

class GuessTheSongGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    private companion object {
        private val list = listOf(
            GuessTheSong(songName = "7 Years", artist = "Lukas Graham", resid = R.raw.seven_years),
            GuessTheSong(
                songName = "Smells Like Teen Spirit",
                artist = "Nirvana",
                resid = R.raw.smells_like_teen_spirit
            ),
            GuessTheSong(songName = "Mood", artist = "24kGoldn, iann dior", resid = R.raw.mood),
            GuessTheSong(
                songName = "Sugar",
                artist = "Robin Schulz, Francesco Yates",
                resid = R.raw.sugar
            ),
            GuessTheSong(
                songName = "Do I Wanna Know?",
                artist = "Arctic Monkeys",
                resid = R.raw.do_i_wanna_know
            ),
            GuessTheSong(
                songName = "Waiting For Love",
                artist = "Avicii",
                resid = R.raw.waiting_for_love
            ),
            GuessTheSong(songName = "Wonderwall", artist = "Oasis", resid = R.raw.wonderwall),
            GuessTheSong(
                songName = "Counting Stars",
                artist = "OneRepublic",
                resid = R.raw.counting_stars,
                duration = 12000
            ),
            GuessTheSong(
                songName = "Shape of You",
                artist = "Ed Sheeran",
                resid = R.raw.shape_of_you,
                duration = 8000
            ),
            GuessTheSong(
                songName = "2U",
                artist = "Justin Bieber",
                resid = R.raw.to_u,
                duration = 14000
            ),
            GuessTheSong(songName = "All of Me", artist = "John Legend", resid = R.raw.all_of_me),
            GuessTheSong(songName = "Am I Wrong", artist = "Nico & Vinz", resid = R.raw.am_i_wrong),
            GuessTheSong(songName = "As It Was", artist = "Harry Styles", resid = R.raw.as_it_was),
            GuessTheSong(
                songName = "Blinding Lights",
                artist = "The Weeknd",
                resid = R.raw.blinding_lights
            ),
            GuessTheSong(songName = "Breathing", artist = "Jason Derulo", resid = R.raw.breathing),
            GuessTheSong(
                songName = "Closer",
                artist = "The Chainsmokers, Halsey",
                resid = R.raw.closer
            ),
            GuessTheSong(songName = "Demons", artist = "Imagine Dragons", resid = R.raw.demons),
            GuessTheSong(
                songName = "DJ Got Us Fallin' In Love",
                artist = "Usher, Pitbull",
                resid = R.raw.dj_got_us_fallin_in_love_again
            ),
            GuessTheSong(
                songName = "Don't Let Me Down",
                artist = "The Chainsmokers, Daya",
                resid = R.raw.dont_let_me_down
            ),
            GuessTheSong(
                songName = "Don't Start Now",
                artist = "Dua Lipa",
                resid = R.raw.dont_start_now
            ),
            GuessTheSong(
                songName = "Don't You Worry Child",
                artist = "Swedish House Mafia, John Martin",
                resid = R.raw.dont_you_worry_child
            ),
            GuessTheSong(songName = "Faded", artist = "Alan Walker", resid = R.raw.faded),
            GuessTheSong(
                songName = "Fast Car",
                artist = "Jonas Blue, Dakota",
                resid = R.raw.fast_car
            ),
            GuessTheSong(
                songName = "Five More Hours",
                artist = "Chris Brown, Deorro",
                resid = R.raw.five_more_hours
            ),
            GuessTheSong(songName = "Glow", artist = "Madcon", resid = R.raw.glow),
            GuessTheSong(
                songName = "Hall of Fame",
                artist = "The Script, will.i.am",
                resid = R.raw.hall_of_fame
            ),
            GuessTheSong(
                songName = "Happier",
                artist = "Marshmello, Bastille",
                resid = R.raw.happier
            ),
            GuessTheSong(songName = "Hey Brother", artist = "Avicii", resid = R.raw.hey_brother),
            GuessTheSong(
                songName = "Holding Out for a Hero",
                artist = "Bonnie Tyler",
                resid = R.raw.holding_out_for_a_hero
            ),
            GuessTheSong(
                songName = "I Don't Care",
                artist = "Ed Sheeran, Justin Bieber",
                resid = R.raw.i_dont_care
            ),
            GuessTheSong(
                songName = "I Took A Pill In Ibiza",
                artist = "Mike Posner, Seeb",
                resid = R.raw.i_took_a_pill_in_ibiza
            ),
            GuessTheSong(
                songName = "INDUSTRY BABY",
                artist = "Lil Nas X, Jack Harlow",
                resid = R.raw.industry_baby
            ),
            GuessTheSong(
                songName = "Lean On",
                artist = "Major Lazer, MØ, DJ Snake",
                resid = R.raw.lean_on
            ),
            GuessTheSong(
                songName = "Lose Yourself",
                artist = "Eminem",
                resid = R.raw.lose_yourself
            ),
            GuessTheSong(songName = "MONTERO", artist = "Lil Nas X", resid = R.raw.montero),
            GuessTheSong(songName = "Numb", artist = "Linkin Park", resid = R.raw.numb),
            GuessTheSong(
                songName = "One Kiss",
                artist = "Calvin Harris, Dua Lipa",
                resid = R.raw.one_kiss
            ),
            GuessTheSong(
                songName = "Perfect Strangers",
                artist = "Jonas Blue, JP Cooper",
                resid = R.raw.perfect_strangers
            ),
            GuessTheSong(
                songName = "Something Just Like This",
                artist = "The Chainsmokers, Coldplay",
                resid = R.raw.something_just_like_this
            ),
            GuessTheSong(songName = "Sorry", artist = "Justin Bieber", resid = R.raw.sorry),
            GuessTheSong(
                songName = "Starboy",
                artist = "The Weeknd, Daft Punk",
                resid = R.raw.starboy
            ),
            GuessTheSong(
                songName = "STAY",
                artist = "The Kid LAROI, Justin Bieber",
                resid = R.raw.stay
            ),
            GuessTheSong(songName = "Timber", artist = "Pitbull, Kesha", resid = R.raw.timber),
            GuessTheSong(
                songName = "2U",
                artist = "David Guetta, Justin Bieber",
                resid = R.raw.to_u
            ),
            GuessTheSong(
                songName = "Uptown Funk",
                artist = "Mark Ronson, Bruno Mars",
                resid = R.raw.uptown_funk
            ),
            GuessTheSong(songName = "Wake Me Up", artist = "Avicii", resid = R.raw.wake_me_up),
            GuessTheSong(
                songName = "Watermelon Sugar",
                artist = "Harry Styles",
                resid = R.raw.watermelon_sugar
            ),
            GuessTheSong(
                songName = "Yeah!",
                artist = "Usher, Lil Jon, Ludacris",
                resid = R.raw.yeah
            ),
//            GuessTheSong(songName = "", artist = "", resid = 0),
        )
    }
}