package com.boozeblaster.generators.individual

import com.boozeblaster.R
import com.boozeblaster.enums.Genre
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheSong
import com.boozeblaster.models.Song
import java.util.stream.Collectors

class GuessTheSongGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3, resetAllToUnused = true)
    }

    fun getListForGenre(genre: Genre): List<MiniGame> {
        return super.getList(
            list = list.stream().filter { element -> element.getSong().getGenre() == genre }
                .collect(
                    Collectors.toList()
                ), amount = 3, resetAllToUnused = false
        )
    }

    private companion object {
        private val list = listOf(
            GuessTheSong(
                song = Song(
                    songName = "7 Years",
                    artistName = "Lukas Graham",
                    genre = Genre.POP
                ),
                resid = R.raw.seven_years
            ),
            GuessTheSong(
                song = Song(
                    songName = "Smells Like Teen Spirit",
                    artistName = "Nirvana",
                    genre = Genre.ROCK
                ),
                resid = R.raw.smells_like_teen_spirit
            ),
            GuessTheSong(
                song = Song(
                    songName = "Mood",
                    artistName = "24kGoldn, iann dior",
                    genre = Genre.POP
                ),
                resid = R.raw.mood
            ),
            GuessTheSong(
                song = Song(
                    songName = "Sugar",
                    artistName = "Robin Schulz, Francesco Yates",
                    genre = Genre.POP
                ),
                resid = R.raw.sugar
            ),
            GuessTheSong(
                song = Song(
                    songName = "Do I Wanna Know?",
                    artistName = "Arctic Monkeys",
                    genre = Genre.ROCK
                ),
                resid = R.raw.do_i_wanna_know
            ),
            GuessTheSong(
                song = Song(
                    songName = "Waiting For Love",
                    artistName = "Avicii",
                    genre = Genre.POP
                ),
                resid = R.raw.waiting_for_love
            ),
            GuessTheSong(
                song = Song(
                    songName = "Wonderwall",
                    artistName = "Oasis",
                    genre = Genre.ROCK
                ),
                resid = R.raw.wonderwall
            ),
            GuessTheSong(
                song = Song(
                    songName = "Counting Stars",
                    artistName = "OneRepublic",
                    genre = Genre.POP
                ),
                resid = R.raw.counting_stars,
                duration = 12000
            ),
            GuessTheSong(
                song = Song(
                    songName = "Shape of You",
                    artistName = "Ed Sheeran",
                    genre = Genre.POP
                ),
                resid = R.raw.shape_of_you,
                duration = 8000
            ),
            GuessTheSong(
                song = Song(
                    songName = "2U",
                    artistName = "Justin Bieber",
                    genre = Genre.POP
                ),
                resid = R.raw.to_u,
                duration = 14000
            ),
            GuessTheSong(
                song = Song(
                    songName = "All of Me",
                    artistName = "John Legend",
                    genre = Genre.POP
                ),
                resid = R.raw.all_of_me
            ),
            GuessTheSong(
                song = Song(
                    songName = "Am I Wrong",
                    artistName = "Nico & Vinz",
                    genre = Genre.POP
                ),
                resid = R.raw.am_i_wrong
            ),
            GuessTheSong(
                song = Song(
                    songName = "As It Was",
                    artistName = "Harry Styles",
                    genre = Genre.POP
                ),
                resid = R.raw.as_it_was
            ),
            GuessTheSong(
                song = Song(
                    songName = "Blinding Lights",
                    artistName = "The Weeknd",
                    genre = Genre.POP
                ),
                resid = R.raw.blinding_lights
            ),
            GuessTheSong(
                song = Song(
                    songName = "Breathing",
                    artistName = "Jason Derulo",
                    genre = Genre.POP
                ),
                resid = R.raw.breathing
            ),
            GuessTheSong(
                song = Song(
                    songName = "Closer",
                    artistName = "The Chainsmokers, Halsey",
                    genre = Genre.POP
                ),
                resid = R.raw.closer
            ),
            GuessTheSong(
                song = Song(
                    songName = "Demons",
                    artistName = "Imagine Dragons",
                    genre = Genre.POP
                ),
                resid = R.raw.demons
            ),
            GuessTheSong(
                song = Song(
                    songName = "DJ Got Us Fallin' In Love",
                    artistName = "Usher, Pitbull",
                    genre = Genre.POP
                ),
                resid = R.raw.dj_got_us_fallin_in_love_again
            ),
            GuessTheSong(
                song = Song(
                    songName = "Don't Let Me Down",
                    artistName = "The Chainsmokers, Daya",
                    genre = Genre.POP
                ),
                resid = R.raw.dont_let_me_down
            ),
            GuessTheSong(
                song = Song(
                    songName = "Don't Start Now",
                    artistName = "Dua Lipa",
                    genre = Genre.POP
                ),
                resid = R.raw.dont_start_now
            ),
            GuessTheSong(
                song = Song(
                    songName = "Don't You Worry Child",
                    artistName = "Swedish House Mafia, John Martin",
                    genre = Genre.POP
                ),
                resid = R.raw.dont_you_worry_child
            ),
            GuessTheSong(
                song = Song(
                    songName = "Faded",
                    artistName = "Alan Walker",
                    genre = Genre.POP
                ),
                resid = R.raw.faded
            ),
            GuessTheSong(
                song = Song(
                    songName = "Fast Car",
                    artistName = "Jonas Blue, Dakota",
                    genre = Genre.POP
                ),
                resid = R.raw.fast_car
            ),
            GuessTheSong(
                song = Song(
                    songName = "Five More Hours",
                    artistName = "Chris Brown, Deorro",
                    genre = Genre.POP
                ),
                resid = R.raw.five_more_hours
            ),
            GuessTheSong(
                song = Song(
                    songName = "Glow",
                    artistName = "Madcon",
                    genre = Genre.POP
                ),
                resid = R.raw.glow
            ),
            GuessTheSong(
                song = Song(
                    songName = "Hall of Fame",
                    artistName = "The Script, will.i.am",
                    genre = Genre.POP
                ),
                resid = R.raw.hall_of_fame
            ),
            GuessTheSong(
                song = Song(
                    songName = "Happier",
                    artistName = "Marshmello, Bastille",
                    genre = Genre.POP
                ),
                resid = R.raw.happier
            ),
            GuessTheSong(
                song = Song(
                    songName = "Hey Brother",
                    artistName = "Avicii",
                    genre = Genre.POP
                ),
                resid = R.raw.hey_brother
            ),
            GuessTheSong(
                song = Song(
                    songName = "Holding Out for a Hero",
                    artistName = "Bonnie Tyler",
                    genre = Genre.POP
                ),
                resid = R.raw.holding_out_for_a_hero
            ),
            GuessTheSong(
                song = Song(
                    songName = "I Don't Care",
                    artistName = "Ed Sheeran, Justin Bieber",
                    genre = Genre.POP
                ),
                resid = R.raw.i_dont_care
            ),
            GuessTheSong(
                song = Song(
                    songName = "I Took A Pill In Ibiza",
                    artistName = "Mike Posner, Seeb",
                    genre = Genre.POP
                ),
                resid = R.raw.i_took_a_pill_in_ibiza
            ),
            GuessTheSong(
                song = Song(
                    songName = "INDUSTRY BABY",
                    artistName = "Lil Nas X, Jack Harlow",
                    genre = Genre.RAP
                ),
                resid = R.raw.industry_baby
            ),
            GuessTheSong(
                song = Song(
                    songName = "Lean On",
                    artistName = "Major Lazer, MØ, DJ Snake",
                    genre = Genre.POP
                ),
                resid = R.raw.lean_on
            ),
            GuessTheSong(
                song = Song(
                    songName = "Lose Yourself",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                resid = R.raw.lose_yourself
            ),
            GuessTheSong(
                song = Song(
                    songName = "MONTERO",
                    artistName = "Lil Nas X",
                    genre = Genre.RAP
                ),
                resid = R.raw.montero
            ),
            GuessTheSong(
                song = Song(
                    songName = "Numb",
                    artistName = "Linkin Park",
                    genre = Genre.ROCK
                ),
                resid = R.raw.numb
            ),
            GuessTheSong(
                song = Song(
                    songName = "One Kiss",
                    artistName = "Calvin Harris, Dua Lipa",
                    genre = Genre.POP
                ),
                resid = R.raw.one_kiss
            ),
            GuessTheSong(
                song = Song(
                    songName = "Perfect Strangers",
                    artistName = "Jonas Blue, JP Cooper",
                    genre = Genre.POP
                ),
                resid = R.raw.perfect_strangers
            ),
            GuessTheSong(
                song = Song(
                    songName = "Something Just Like This",
                    artistName = "The Chainsmokers, Coldplay",
                    genre = Genre.POP
                ),
                resid = R.raw.something_just_like_this
            ),
            GuessTheSong(
                song = Song(
                    songName = "Sorry",
                    artistName = "Justin Bieber",
                    genre = Genre.POP
                ),
                resid = R.raw.sorry
            ),
            GuessTheSong(
                song = Song(
                    songName = "Starboy",
                    artistName = "The Weeknd, Daft Punk",
                    genre = Genre.POP
                ),
                resid = R.raw.starboy
            ),
            GuessTheSong(
                song = Song(
                    songName = "STAY",
                    artistName = "The Kid LAROI, Justin Bieber",
                    genre = Genre.POP
                ),
                resid = R.raw.stay
            ),
            GuessTheSong(
                song = Song(
                    songName = "Timber",
                    artistName = "Pitbull, Kesha",
                    genre = Genre.POP
                ),
                resid = R.raw.timber
            ),
            GuessTheSong(
                song = Song(
                    songName = "2U",
                    artistName = "David Guetta, Justin Bieber",
                    genre = Genre.POP
                ),
                resid = R.raw.to_u
            ),
            GuessTheSong(
                song = Song(
                    songName = "Uptown Funk",
                    artistName = "Mark Ronson, Bruno Mars",
                    genre = Genre.POP
                ),
                resid = R.raw.uptown_funk
            ),
            GuessTheSong(
                song = Song(
                    songName = "Wake Me Up",
                    artistName = "Avicii",
                    genre = Genre.POP
                ),
                resid = R.raw.wake_me_up
            ),
            GuessTheSong(
                song = Song(
                    songName = "Watermelon Sugar",
                    artistName = "Harry Styles",
                    genre = Genre.POP
                ),
                resid = R.raw.watermelon_sugar
            ),
            GuessTheSong(
                song = Song(
                    songName = "Yeah!",
                    artistName = "Usher, Lil Jon, Ludacris",
                    genre = Genre.HIP_HOP
                ),
                resid = R.raw.yeah
            ),
            GuessTheSong(
                song = Song(
                    songName = "Infinity",
                    artistName = "Timmy Trumpet",
                    genre = Genre.POP
                ),
                resid = R.raw.infinity,
                duration = 12000
            ),
            GuessTheSong(
                song = Song(
                    songName = "Afterglow",
                    artistName = "Wilkinson, Becky Hill",
                    genre = Genre.POP
                ),
                resid = R.raw.afterglow
            ),
            GuessTheSong(
                song = Song(
                    songName = "Boulevard of Broken Dreams",
                    artistName = "Green Day",
                    genre = Genre.ROCK
                ),
                resid = R.raw.boulevard_of_broken_dreams
            ),
            GuessTheSong(
                song = Song(
                    songName = "Californication",
                    artistName = "Red Hot Chili Peppers",
                    genre = Genre.ROCK
                ),
                resid = R.raw.californication
            ),
            GuessTheSong(
                song = Song(
                    songName = "Can't Stop",
                    artistName = "Red Hot Chili Peppers",
                    genre = Genre.ROCK
                ),
                resid = R.raw.cant_stop
            ),
            GuessTheSong(
                song = Song(
                    songName = "CASTLE OF GLASS",
                    artistName = "Linkin Park",
                    genre = Genre.ROCK
                ),
                resid = R.raw.castle_of_glass
            ),
            GuessTheSong(
                song = Song(
                    songName = "Changes",
                    artistName = "2Pac, Talent",
                    genre = Genre.HIP_HOP
                ),
                resid = R.raw.changes
            ),
            GuessTheSong(
                song = Song(
                    songName = "Empire State Of Mind",
                    artistName = "JAY-Z, Alicia Keys",
                    genre = Genre.RAP
                ),
                resid = R.raw.empire_state_of_mind
            ),
            GuessTheSong(
                song = Song(
                    songName = "Ni**as In Paris",
                    artistName = "JAY-Z, Kanye West",
                    genre = Genre.RAP
                ),
                resid = R.raw.fellas_in_paris
            ),
            GuessTheSong(
                song = Song(
                    songName = "Freed From Desire",
                    artistName = "Gala",
                    genre = Genre.POP
                ),
                resid = R.raw.free_from_desire
            ),
            GuessTheSong(
                song = Song(
                    songName = "Gangsta's Paradise",
                    artistName = "Coolio, L.V.",
                    genre = Genre.RAP
                ),
                resid = R.raw.gangstas_paradise
            ),
            GuessTheSong(
                song = Song(
                    songName = "Hey, Soul Sister",
                    artistName = "Train",
                    genre = Genre.POP
                ),
                resid = R.raw.hey_soul_sister
            ),
            GuessTheSong(
                song = Song(
                    songName = "Highway to Hell",
                    artistName = "AC/DC",
                    genre = Genre.ROCK
                ),
                resid = R.raw.highway_to_hell
            ),
            GuessTheSong(
                song = Song(
                    songName = "I Was Made For Lovin' You",
                    artistName = "KISS",
                    genre = Genre.ROCK
                ),
                resid = R.raw.i_was_made_for_lovin_you
            ),
            GuessTheSong(
                song = Song(
                    songName = "In the End",
                    artistName = "Linkin Park",
                    genre = Genre.ROCK
                ),
                resid = R.raw.in_the_end
            ),
            GuessTheSong(
                song = Song(
                    songName = "L'Amour Toujours",
                    artistName = "Gigi D'Agostino",
                    genre = Genre.POP
                ),
                resid = R.raw.lamour_toujours
            ),
            GuessTheSong(
                song = Song(
                    songName = "Last Resort",
                    artistName = "Papa Roach",
                    genre = Genre.ROCK
                ),
                resid = R.raw.last_resort
            ),
            GuessTheSong(
                song = Song(
                    songName = "Love Me Again",
                    artistName = "John Newman",
                    genre = Genre.POP
                ),
                resid = R.raw.love_me_again
            ),
            GuessTheSong(
                song = Song(
                    songName = "Mamma Mia",
                    artistName = "ABBA",
                    genre = Genre.POP
                ),
                resid = R.raw.mamma_mia
            ),
            GuessTheSong(
                song = Song(
                    songName = "Satellite",
                    artistName = "Rise Against",
                    genre = Genre.ROCK
                ),
                resid = R.raw.satellite
            ),
            GuessTheSong(
                song = Song(
                    songName = "Summer",
                    artistName = "Calvin Harris",
                    genre = Genre.POP
                ),
                resid = R.raw.summer
            ),
            GuessTheSong(
                song = Song(
                    songName = "Treasure",
                    artistName = "Bruno Mars",
                    genre = Genre.POP
                ),
                resid = R.raw.treasure
            ),
            GuessTheSong(
                song = Song(
                    songName = "21 Guns",
                    artistName = "Green Day",
                    genre = Genre.ROCK
                ),
                resid = R.raw.twenty_one_guns
            ),
            GuessTheSong(
                song = Song(
                    songName = "U Can't Touch This",
                    artistName = "MC Hammer",
                    genre = Genre.HIP_HOP
                ),
                resid = R.raw.u_cant_touch_this
            ),
            GuessTheSong(
                song = Song(
                    songName = "Viva La Vida",
                    artistName = "Coldplay",
                    genre = Genre.ROCK
                ),
                resid = R.raw.viva_la_vida
            ),
            GuessTheSong(
                song = Song(
                    songName = "Waka Waka",
                    artistName = "Shakira",
                    genre = Genre.POP
                ),
                resid = R.raw.waka_waka
            ),
            GuessTheSong(
                song = Song(
                    songName = "Wavin' Flag",
                    artistName = "K'NAAN",
                    genre = Genre.POP
                ),
                resid = R.raw.wavin_flag
            ),
            GuessTheSong(
                song = Song(
                    songName = "Bad Romance",
                    artistName = "Lady Gaga",
                    genre = Genre.POP
                ),
                resid = R.raw.bad_romance
            ),
            GuessTheSong(
                song = Song(
                    songName = "Blue (Da Ba Dee)",
                    artistName = "Eiffel 65, Gabry Ponte",
                    genre = Genre.POP
                ),
                resid = R.raw.blue
            ),
            GuessTheSong(
                song = Song(
                    songName = "Firestone",
                    artistName = "Kygo, Conrad Sewell",
                    genre = Genre.POP
                ),
                resid = R.raw.firestone
            ),
            GuessTheSong(
                song = Song(
                    songName = "Gimme! Gimme! Gimme! (A Man After Midnight)",
                    artistName = "ABBA",
                    genre = Genre.POP
                ),
                resid = R.raw.gimme_gimme_gimme
            ),
            GuessTheSong(
                song = Song(
                    songName = "Stole the Show",
                    artistName = "Kygo, Parson James",
                    genre = Genre.POP
                ),
                resid = R.raw.stole_the_show
            ),
            GuessTheSong(
                song = Song(
                    songName = "Sweet Dreams (Are Made of This)",
                    artistName = "Eurythmics, Annie Lennox, Dave Stewart",
                    genre = Genre.POP
                ),
                resid = R.raw.sweet_dreams
            ),
            GuessTheSong(
                song = Song(
                    songName = "The Nights",
                    artistName = "Avicii",
                    genre = Genre.POP
                ),
                resid = R.raw.the_nights
            ),
            GuessTheSong(
                song = Song(
                    songName = "We Found Love",
                    artistName = "Rihanna, Calvin Harris",
                    genre = Genre.POP
                ),
                resid = R.raw.we_found_love
            ),
            GuessTheSong(
                song = Song(
                    songName = "No Money",
                    artistName = "Galantis",
                    genre = Genre.POP
                ),
                resid = R.raw.no_money,
                duration = 12000
            ),
            GuessTheSong(
                song = Song(
                    songName = "Scared to Be Lonely",
                    artistName = "Martin Garrix, Dua Lipa",
                    genre = Genre.POP
                ),
                resid = R.raw.scared_to_be_lonely,
                duration = 14000
            ),
            GuessTheSong(
                song = Song(
                    songName = "A Thousand Miles",
                    artistName = "Vanessa Carlton",
                    genre = Genre.POP
                ),
                resid = R.raw.a_thousand_miles
            ),
            GuessTheSong(
                song = Song(
                    songName = "Africa",
                    artistName = "TOTO",
                    genre = Genre.ROCK
                ),
                resid = R.raw.africa
            ),
            GuessTheSong(
                song = Song(
                    songName = "Ain't Nobody (Loves Me Better)",
                    artistName = "Felix Jaehn, Jasmine Thompson",
                    genre = Genre.POP
                ),
                resid = R.raw.aint_nobody
            ),
            GuessTheSong(
                song = Song(
                    songName = "Low",
                    artistName = "Flo Rida, T-Pain",
                    genre = Genre.HIP_HOP
                ),
                resid = R.raw.low
            ),
            GuessTheSong(
                song = Song(
                    songName = "Pepas",
                    artistName = "Farruko",
                    genre = Genre.POP
                ),
                resid = R.raw.pepas
            ),
            GuessTheSong(
                song = Song(
                    songName = "Pong Dance",
                    artistName = "Vigiland",
                    genre = Genre.POP
                ),
                resid = R.raw.pong_dance
            ),
            GuessTheSong(
                song = Song(
                    songName = "Rather Be",
                    artistName = "Clean Bandit, Jess Glynne",
                    genre = Genre.POP
                ),
                resid = R.raw.rather_be
            ),
            GuessTheSong(
                song = Song(
                    songName = "Snow (Hey Oh)",
                    artistName = "Red Hot Chili Peppers",
                    genre = Genre.ROCK
                ),
                resid = R.raw.snow
            ),
            GuessTheSong(
                song = Song(
                    songName = "Bad Habits",
                    artistName = "Ed Sheeran",
                    genre = Genre.POP
                ),
                resid = R.raw.bad_habits
            ),
        )
    }
}