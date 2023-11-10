package com.boozeblaster.generators.individual

import com.boozeblaster.enums.Genre
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Song
import java.util.stream.Collectors

class GuessTheLyricsGenerator : MiniGameGenerator() {

    @Override
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

    /**
     * List of GuessTheLyrics instances
     */
    private companion object {
        private val list = listOf(
            GuessTheLyrics(
                song = Song(
                    songName = "Smells Like Teen Spirit",
                    artistName = "Nirvana",
                    genre = Genre.ROCK
                ),
                lyrics = "Load up on guns, bring your friends",
                lyricsCompletion = "It's fun to lose and to pretend"
            ),
            GuessTheLyrics(
                song = Song(songName = "Basket Case", artistName = "Green Day", genre = Genre.ROCK),
                lyrics = "Do you have the time to listen to me whine?",
                lyricsCompletion = "About nothing and everything, all at once"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Can't Stop",
                    artistName = "Red Hot Chili Peppers",
                    genre = Genre.ROCK
                ),
                lyrics = "The world I love, the tears I drop",
                lyricsCompletion = "To be part of the wave, can't stop"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Livin' On A Prayer",
                    artistName = "Bon Jovi",
                    genre = Genre.ROCK
                ),
                lyrics = "She says, \"We've gotta hold on to what we've got\"",
                lyricsCompletion = "It doesn't make a difference if we make it or not"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Last Resort",
                    artistName = "Papa Roach",
                    genre = Genre.ROCK
                ),
                lyrics = "Losing my sight, losing my mind",
                lyricsCompletion = "Wish somebody would tell me I'm fine"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "You Give Love A Bad Name",
                    artistName = "Bon Jovi",
                    genre = Genre.ROCK
                ),
                lyrics = "Woah-oh-oh, there's nowhere to run",
                lyricsCompletion = "No one can save me, the damage is done"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "I Want It That Way",
                    artistName = "Backstreet Boys",
                    genre = Genre.POP
                ),
                lyrics = "But we are two worlds apart",
                lyricsCompletion = "Can't reach to your heart"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "I Was Made For Lovin' You",
                    artistName = "KISS",
                    genre = Genre.ROCK
                ),
                lyrics = "And tonight I wanna lay it at your feet",
                lyricsCompletion = "'Cause girl, I was made for you"
            ),
            GuessTheLyrics(
                song = Song(songName = "21 Guns", artistName = "Green Day", genre = Genre.ROCK),
                lyrics = "When you're at the end of the road",
                lyricsCompletion = "And you lost all sense of control"
            ),
            GuessTheLyrics(
                song = Song(songName = "Numb", artistName = "Linkin Park", genre = Genre.ROCK),
                lyrics = "'Cause everything that you thought I would be",
                lyricsCompletion = "Has fallen apart right in front of you"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Satellite",
                    artistName = "Rise Against",
                    genre = Genre.ROCK
                ),
                lyrics = "That's why we stick to your game plans and party lines",
                lyricsCompletion = "But at night we're conspiring by candlelight"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Castle of Glass",
                    artistName = "Linkin Park",
                    genre = Genre.ROCK
                ),
                lyrics = "Bring me home in a blinding dream",
                lyricsCompletion = "Through the secrets that I have seen"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Remind Me to Forget",
                    artistName = "Kygo, Miguel",
                    genre = Genre.POP
                ),
                lyrics = "It doesn't matter where you are",
                lyricsCompletion = "You can keep my regret"
            ),
            GuessTheLyrics(
                song = Song(songName = "Robbery", artistName = "Juice WRLD", genre = Genre.RAP),
                lyrics = "Now I'm digging up a grave from my past",
                lyricsCompletion = "I'm a whole different person"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Heartless",
                    artistName = "Kanye West",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "In the night I hear 'em talk",
                lyricsCompletion = "The coldest story ever told"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "I Fall Apart",
                    artistName = "Post Malone",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "Now there's too many thoughts goin' through my brain, yeah",
                lyricsCompletion = "And now I'm takin' these shots like it's Novocaine, yeah"
            ),
            GuessTheLyrics(
                song = Song(songName = "Run", artistName = "OneRepublic", genre = Genre.POP),
                lyrics = "They tell you that the sky might fall",
                lyricsCompletion = "They'll say that you might lose it all"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "There's Nothing Holdin' Me Back",
                    artistName = "Shawn Mendes",
                    genre = Genre.POP
                ),
                lyrics = "You take me places that tear up my reputation",
                lyricsCompletion = "Manipulate my decisions"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Man Of The Year",
                    artistName = "Juice WRLD",
                    genre = Genre.RAP
                ),
                lyrics = "Talkin' to myself, do it too often",
                lyricsCompletion = "JK, Juice WRLD, you're so awesome"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "She Doesn't Mind",
                    artistName = "Sean Paul",
                    genre = Genre.POP
                ),
                lyrics = "We got the dance hall crazy",
                lyricsCompletion = "We got the club on fire"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Sun Goes Down",
                    artistName = "Robin Schulz, Jasmine Thompson",
                    genre = Genre.POP
                ),
                lyrics = "Nothing's ever what we expect",
                lyricsCompletion = "But they keep asking where I go next"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "forget me too",
                    artistName = "Machine Gun Kelly, Halsey",
                    genre = Genre.ROCK
                ), lyrics = "I'm keepin' you waiting", lyricsCompletion = "But I won't wait on you"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Big Time Rush",
                    artistName = "Big Time Rush",
                    genre = Genre.POP
                ),
                lyrics = "Go and shake it up, what you gotta lose?",
                lyricsCompletion = "Go and make your luck with the life you choose"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "INDUSTRY BABY",
                    artistName = "Lil Nas X, Jack Harlow",
                    genre = Genre.RAP
                ),
                lyrics = "Funny how you said it was the end, yeah",
                lyricsCompletion = "Then I went did it again, yeah"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Young, Wild & Free",
                    artistName = "Snoop Dogg, Wiz Khalifa, Bruno Mars",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "So what I keep 'em rolled up",
                lyricsCompletion = "Saggin' my pants, not caring what I show"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Snow (Hey Oh)",
                    artistName = "Red Hot Chili Peppers",
                    genre = Genre.ROCK
                ),
                lyrics = "Come to believe that I better not leave",
                lyricsCompletion = "Before I get my chance to ride"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Gangsta's Paradise",
                    artistName = "Coolio, L.V.",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "'Cause I've been blastin' and laughin' so long that",
                lyricsCompletion = "Even my mama thinks that my mind is gone"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Glorious",
                    artistName = "Macklemore, Skylar Grey",
                    genre = Genre.RAP
                ),
                lyrics = "I heard you die twice, once when they bury you in the grave",
                lyricsCompletion = "And the second time is the last time somebody mentions your name"
            ),
            GuessTheLyrics(
                song = Song(songName = "No Type", artistName = "Rae Sremmurd", genre = Genre.RAP),
                lyrics = "I ain't check the price (I got it)",
                lyricsCompletion = "I make my own money so I spend it how I like (woo)"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Turn Me On",
                    artistName = "David Guetta, Nicki Minaj",
                    genre = Genre.POP
                ),
                lyrics = "My body needs a hero",
                lyricsCompletion = "Come and save me"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "On My Way",
                    artistName = "Axwell /\\ Ingrosso",
                    genre = Genre.POP
                ),
                lyrics = "I'm gonna hit the throttle",
                lyricsCompletion = "I'm gonna place my bet on every step I take"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Regulate",
                    artistName = "Warren G, Nate Dogg",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "It was a clear black night, a clear white moon",
                lyricsCompletion = "Warren G was on the streets, tryin' to consume"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Changes",
                    artistName = "2Pac, Talent",
                    genre = Genre.HIP_HOP
                ),
                lyrics = "I see no changes, wake up in the morning and I ask myself",
                lyricsCompletion = "Is life worth living, should I blast myself?"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Ni**as in Paris",
                    artistName = "Jay-Z, Kanye West",
                    genre = Genre.RAP
                ),
                lyrics = "Ball so hard, got a broke clock",
                lyricsCompletion = "Rollies that don't tick-tock"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Happy Now",
                    artistName = "Kygo, Sandro Cavazza",
                    genre = Genre.POP
                ),
                lyrics = "And it's time that we see it, the fire's dying out",
                lyricsCompletion = "Can't believe that I say this, we're out of chances now"
            ),
            GuessTheLyrics(
                song = Song(songName = "Viva La Vida", artistName = "Coldplay", genre = Genre.ROCK),
                lyrics = "One minute I held the key",
                lyricsCompletion = "Next the walls were closed on me"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Something I Need",
                    artistName = "OneRepublic",
                    genre = Genre.POP
                ),
                lyrics = "And I had the week that came from hell",
                lyricsCompletion = "And yes I know that you could tell"
            ),
            GuessTheLyrics(
                song = Song(songName = "Hey Brother", artistName = "Avicii", genre = Genre.POP),
                lyrics = "What if I lose it all?",
                lyricsCompletion = "Oh sister, I will help you out"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Blinding Lights",
                    artistName = "The Weeknd",
                    genre = Genre.POP
                ),
                lyrics = "I said, ooh, I'm drowning in the night",
                lyricsCompletion = "Oh, when I'm like this, you're the one I trust"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Hollywood",
                    artistName = "LA Vision, Gigi D'Agostino",
                    genre = Genre.POP
                ),
                lyrics = "The dark is taking my mind",
                lyricsCompletion = "Don't wanna leave you behind"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Watermelon Sugar",
                    artistName = "Harry Styles",
                    genre = Genre.POP
                ),
                lyrics = "I'm just thinking out loud",
                lyricsCompletion = "I don't know if I could ever go without"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Do I Wanna Know?",
                    artistName = "Arctic Monkeys",
                    genre = Genre.ROCK
                ),
                lyrics = "That the nights were mainly made for sayin' things",
                lyricsCompletion = "That you can't say tomorrow day"
            ),
            GuessTheLyrics(
                song = Song(songName = "The Nights", artistName = "Avicii", genre = Genre.POP),
                lyrics = "\"When thunderclouds start pouring down\nLight a fire they can't put out",
                lyricsCompletion = "Carve your name into those shining stars\""
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Closer",
                    artistName = "The Chainsmokers, Halsey",
                    genre = Genre.POP
                ),
                lyrics = "You, look as good as the day I met you",
                lyricsCompletion = "I forget just why I left you, I was insane"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Happier",
                    artistName = "Marshmello, Bastille",
                    genre = Genre.POP
                ),
                lyrics = "Then only for a minute\nI want to change my mind 'cause",
                lyricsCompletion = "This just don't feel right to me"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Last Friday Night",
                    artistName = "Katy Perry",
                    genre = Genre.POP
                ),
                lyrics = "Yeah, we maxed our credit cards and got kicked out of the bar",
                lyricsCompletion = "So we hit the boulevard last Friday Night"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "International Love",
                    artistName = "Pitbull, Chris Brown",
                    genre = Genre.POP
                ),
                lyrics = "In Romania, she pulled me to the side and told me",
                lyricsCompletion = "\"Pit, you can have me and my sister\""
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Summer Jam",
                    artistName = "R.I.O, U-Jean",
                    genre = Genre.POP
                ),
                lyrics = "Hot chicks, cool drinks make the summer jam",
                lyricsCompletion = "We gonna party as much as we can"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Solo Dance",
                    artistName = "Martin Jensen",
                    genre = Genre.POP
                ),
                lyrics = "But you can cool it down",
                lyricsCompletion = "Not here to fool around"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Lose Yourself",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                lyrics = "He's nervous, but on the surface he looks calm and ready",
                lyricsCompletion = "To drops bombs, but he keeps on forgetting"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Without Me",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                lyrics = "Now this looks like a job for me so everybody just follow me",
                lyricsCompletion = "'Cause we need a little controversy"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Not Afraid",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                lyrics = "His gift is a curse, forget the Earth, he's got the urge to pull his dick from the dirt",
                lyricsCompletion = "And fuck the whole universe"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Mockingbird",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                lyrics = "I can see you're sad, even when you smile, even when you laugh",
                lyricsCompletion = "I can see it in your eyes, deep inside you wanna cry"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "Love the Way You Lie",
                    artistName = "Eminem, Rihanna",
                    genre = Genre.RAP
                ),
                lyrics = "I can't tell you what it really is",
                lyricsCompletion = "I can only tell you what it feels like"
            ),
            GuessTheLyrics(
                song = Song(
                    songName = "When I'm Gone",
                    artistName = "Eminem",
                    genre = Genre.RAP
                ),
                lyrics = "But what happens when karma turns right around and bites you?",
                lyricsCompletion = "And everything you stand for turns on you to spite you?"
            ),
        )
    }
}