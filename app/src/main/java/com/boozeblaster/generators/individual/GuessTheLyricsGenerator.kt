package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.GuessTheLyrics

class GuessTheLyricsGenerator : MiniGameGenerator() {
    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    /**
     * List of GuessTheLyrics instances
     */
    private companion object {

        private val list = listOf(
            GuessTheLyrics(
                songName = "Smells Like Teen Spirit",
                artist = "Nirvana",
                lyrics = "Load up on guns, bring your friends",
                lyricsCompletion = "It's fun to lose and to pretend"
            ),
            GuessTheLyrics(
                songName = "Basket Case",
                artist = "Green Day",
                lyrics = "Do you have the time to listen to me whine?",
                lyricsCompletion = "About nothing and everything, all at once"
            ),
            GuessTheLyrics(
                songName = "Can't Stop",
                artist = "Red Hot Chili Peppers",
                lyrics = "The world I love, the tears I drop",
                lyricsCompletion = "To be part of the wave, can't stop"
            ),
            GuessTheLyrics(
                songName = "Livin' On A Prayer",
                artist = "Bon Jovi",
                lyrics = "She says, \"We've gotta hold on to what we've got\"",
                lyricsCompletion = "It doesn't make a difference if we make it or not"
            ),
            GuessTheLyrics(
                songName = "Last Resort",
                artist = "Papa Roach",
                lyrics = "Losing my sight, losing my mind",
                lyricsCompletion = "Wish somebody would tell me I'm fine"
            ),
            GuessTheLyrics(
                songName = "You Give Love A Bad Name",
                artist = "Bon Jovi",
                lyrics = "Woah-oh-oh, there's nowhere to run",
                lyricsCompletion = "No one can save me, the damage is done"
            ),
            GuessTheLyrics(
                songName = "I Was Made For Lovin' You",
                artist = "KISS",
                lyrics = "And tonight I wanna lay it at your feet",
                lyricsCompletion = "'Cause girl, I was made for you"
            ),
            GuessTheLyrics(
                songName = "21 Guns",
                artist = "Green Day",
                lyrics = "When you're at the end of the road",
                lyricsCompletion = "And you lost all sense of control"
            ),
            GuessTheLyrics(
                songName = "Numb",
                artist = "Linkin Park",
                lyrics = "'Cause everything that you thought I would be",
                lyricsCompletion = "Has fallen apart right in front of you"
            ),
            GuessTheLyrics(
                songName = "Satellite",
                artist = "Rise Against",
                lyrics = "That's why we stick to your game plans and party lines",
                lyricsCompletion = "But at night we're conspiring by candlelight"
            ),
            GuessTheLyrics(
                songName = "Castle of Glass",
                artist = "Linkin Park",
                lyrics = "Bring me home in a blinding dream",
                lyricsCompletion = "Through the secrets that I have seen"
            ),
            GuessTheLyrics(
                songName = "Remind Me to Forget",
                artist = "Kygo, Miguel",
                lyrics = "It doesn't matter where you are",
                lyricsCompletion = "You can keep my regret"
            ),
            GuessTheLyrics(
                songName = "Robbery",
                artist = "Juice WRLD",
                lyrics = "Now I'm digging up a grave from my past",
                lyricsCompletion = "I'm a whole different person"
            ),
            GuessTheLyrics(
                songName = "Heartless",
                artist = "Kanye West",
                lyrics = "In the night I hear 'em talk",
                lyricsCompletion = "The coldest story ever told"
            ),
            GuessTheLyrics(
                songName = "I Fall Apart",
                artist = "Post Malone",
                lyrics = "Now there's too many thoughts goin' through my brain, yeah",
                lyricsCompletion = "And now I'm takin' these shots like it's Novocaine, yeah"
            ),
            GuessTheLyrics(
                songName = "Run",
                artist = "OneRepublic",
                lyrics = "They tell you that the sky might fall",
                lyricsCompletion = "They'll say that you might lose it all"
            ),
            GuessTheLyrics(
                songName = "There's Nothing Holdin' Me Back",
                artist = "Shawn Mendes",
                lyrics = "You take me places that tear up my reputation",
                lyricsCompletion = "Manipulate my decisions"
            ),
            GuessTheLyrics(
                songName = "Man Of The Year",
                artist = "Juice WRLD",
                lyrics = "Talkin' to myself, do it too often",
                lyricsCompletion = "JK, Juice WRLD, you're so awesome"
            ),
            GuessTheLyrics(
                songName = "She Doesn't Mind",
                artist = "Sean Paul",
                lyrics = "We got the dance hall crazy",
                lyricsCompletion = "We got the club on fire"
            ),
            GuessTheLyrics(
                songName = "Sun Goes Down",
                artist = "Robin Schulz, Jasmine Thompson",
                lyrics = "Nothing's ever what we expect",
                lyricsCompletion = "But they keep asking where I go next"
            ),
            GuessTheLyrics(
                songName = "forget me too",
                artist = "Machine Gun Kelly, Halsey",
                lyrics = "I'm keepin' you waiting",
                lyricsCompletion = "But I won't wait on you"
            ),
            GuessTheLyrics(
                songName = "Big Time Rush",
                artist = "Big Time Rush",
                lyrics = "Go and shake it up, what you gotta lose?",
                lyricsCompletion = "Go and make your luck with the life you choose"
            ),
            GuessTheLyrics(
                songName = "INDUSTRY BABY",
                artist = "Lil Nas X, Jack Harlow",
                lyrics = "Funny how you said it was the end, yeah",
                lyricsCompletion = "Then I went did it again, yeah"
            ),
            GuessTheLyrics(
                songName = "Young, Wild & Free",
                artist = "Snoop Dogg, Wiz Khalifa, Bruno Mars",
                lyrics = "So what I keep 'em rolled up",
                lyricsCompletion = "Saggin' my pants, not caring what I show"
            ),
            GuessTheLyrics(
                songName = "Snow (Hey Oh)",
                artist = "Red Hot Chili Peppers",
                lyrics = "Come to believe that I better not leave",
                lyricsCompletion = "Before I get my chance to ride"
            ),
            GuessTheLyrics(
                songName = "Gangsta's Paradise",
                artist = "Coolio, L.V.",
                lyrics = "'Cause I've been blastin' and laughin' so long that",
                lyricsCompletion = "Even my mama thinks that my mind is gone"
            ),
            GuessTheLyrics(
                songName = "Glorious",
                artist = "Macklemore, Skylar Grey",
                lyrics = "I heard you die twice, once when they bury you in the grave",
                lyricsCompletion = "And the second time is the last time somebody mentions your name"
            ),
            GuessTheLyrics(
                songName = "No Type",
                artist = "Rae Sremmurd",
                lyrics = "I ain't check the price (I got it)",
                lyricsCompletion = "I make my own money so I spend it how I like (woo)"
            ),
            GuessTheLyrics(
                songName = "Turn Me On",
                artist = "David Guetta, Nicki Minaj",
                lyrics = "My body needs a hero",
                lyricsCompletion = "Come and save me"
            ),
            GuessTheLyrics(
                songName = "On My Way",
                artist = "Axwell /\\ Ingrosso",
                lyrics = "I'm gonna hit the throttle",
                lyricsCompletion = "I'm gonna place my bet on every step I take"
            ),
            GuessTheLyrics(
                songName = "Regulate",
                artist = "Warren G, Nate Dogg",
                lyrics = "It was a clear black night, a clear white moon",
                lyricsCompletion = "Warren G was on the streets, tryin' to consume"
            ),
            GuessTheLyrics(
                songName = "Changes",
                artist = "2Pac, Talent",
                lyrics = "I see no changes, wake up in the morning and I ask myself",
                lyricsCompletion = "Is life worth living, should I blast myself?"
            ),
            GuessTheLyrics(
                songName = "Ni**as in Paris",
                artist = "Jay-Z, Kanye West",
                lyrics = "Ball so hard, got a broke clock",
                lyricsCompletion = "Rollies that don't tick-tock"
            ),
            GuessTheLyrics(
                songName = "Happy Now",
                artist = "Kygo, Sandro Cavazza",
                lyrics = "And it's time that we see it, the fire's dying out",
                lyricsCompletion = "Can't believe that I say this, we're out of chances now"
            ),
            GuessTheLyrics(
                songName = "Viva La Vida",
                artist = "Coldplay",
                lyrics = "One minute I held the key",
                lyricsCompletion = "Next the walls were closed on me"
            ),
            GuessTheLyrics(
                songName = "Something I Need",
                artist = "OneRepublic",
                lyrics = "And I had the week that came from hell",
                lyricsCompletion = "And yes I know that you could tell"
            ),
            GuessTheLyrics(
                songName = "Hey Brother",
                artist = "Avicii",
                lyrics = "What if I lose it all?",
                lyricsCompletion = "Oh sister, I will help you out"
            ),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
            GuessTheLyrics(songName = "", artist = "", lyrics = "", lyricsCompletion = ""),
        )
    }
}