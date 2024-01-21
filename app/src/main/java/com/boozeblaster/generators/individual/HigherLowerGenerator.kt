package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.HigherLower
import com.boozeblaster.models.SearchedTerm
import kotlin.random.Random

class HigherLowerGenerator : MiniGameGenerator() {

    @Override
    override fun getList(): List<MiniGame> {
        val randoms = generateRandomIndexes(size = list.size)
        val higherLowerList = listOf(
            HigherLower(
                first = list.get(index = randoms.get(index = 0)),
                second = list.get(index = randoms.get(index = 1))
            ),
            HigherLower(
                first = list.get(index = randoms.get(index = 1)),
                second = list.get(index = randoms.get(index = 2))
            ),
            HigherLower(
                first = list.get(index = randoms.get(index = 2)),
                second = list.get(index = randoms.get(index = 3))
            ),
            HigherLower(
                first = list.get(index = randoms.get(index = 3)),
                second = list.get(index = randoms.get(index = 4))
            ),
            HigherLower(
                first = list.get(index = randoms.get(index = 4)),
                second = list.get(index = randoms.get(index = 5))
            )
        )
        return super.getList(list = higherLowerList, amount = 5, resetAllToUnused = false)
    }

    private companion object {
        private fun generateRandomIndexes(size: Int): Array<Int> {
            var randoms = arrayOf<Int>()
            if (size < 6) {
                throw Exception("Loading a list of searched terms not working(?)")
            }
            while (randoms.size < size) {
                val random = Random.nextInt(from = 0, until = size)
                if (!randoms.contains(element = random)) {
                    randoms = randoms.plus(element = random)
                }
            }
            return randoms
        }

        private val list = listOf(
            SearchedTerm(term = "Downton Abbey", amount = 673000),
            SearchedTerm(term = "Breaking Bad", amount = 2240000),
            SearchedTerm(term = "Mad Men", amount = 550000),
            SearchedTerm(term = "Cancer", amount = 823000),
            SearchedTerm(term = "Kobe Bryant", amount = 823000),
            SearchedTerm(term = "Kuala Lumpur", amount = 550000),
            SearchedTerm(term = "Hillsborough Disaster", amount = 33100),
            SearchedTerm(term = "E-Cigarettes", amount = 368000),
            SearchedTerm(term = "KKK", amount = 1220000),
            SearchedTerm(term = "Amnesty", amount = 135000),
            SearchedTerm(term = "Goodfellas", amount = 450000),
            SearchedTerm(term = "Magic Johnson", amount = 450000),
            SearchedTerm(term = "Pittsburgh Penguins", amount = 1220000),
            SearchedTerm(term = "Jerusalem", amount = 823000),
            SearchedTerm(term = "Zoella", amount = 368000),
            SearchedTerm(term = "Doctor Strange", amount = 1220000),
            SearchedTerm(term = "The Secret Garden", amount = 90500),
            SearchedTerm(term = "Chicago Blackhawks", amount = 550000),
            SearchedTerm(term = "Tas Pappas", amount = 3600),
            SearchedTerm(term = "No Mans Sky", amount = 550000),
            SearchedTerm(term = "Amazon", amount = 277000000),
            SearchedTerm(term = "Scooby Doo", amount = 1220000),
            SearchedTerm(term = "Save The Children", amount = 165000),
            SearchedTerm(term = "Moon Landing", amount = 90500),
            SearchedTerm(term = "Borussia Dortmund", amount = 1500000),
            SearchedTerm(term = "Baidu", amount = 2240000),
            SearchedTerm(term = "Pablo Picasso", amount = 450000),
            SearchedTerm(term = "Ketamine", amount = 301000),
            SearchedTerm(term = "Chicago Bulls", amount = 1000000),
            SearchedTerm(term = "Noahs Ark", amount = 246000),
            SearchedTerm(term = "XXX", amount = 151000000),
            SearchedTerm(term = "Making a Murderer", amount = 201000),
            SearchedTerm(term = "12 Years A Slave", amount = 246000),
            SearchedTerm(term = "Eagles", amount = 1830000),
            SearchedTerm(term = "Miami Dolphins", amount = 1500000),
            SearchedTerm(term = "Recipes", amount = 1220000),
            SearchedTerm(term = "Back to the Future", amount = 550000),
            SearchedTerm(term = "Corn Flakes", amount = 135000),
            SearchedTerm(term = "Syrian Civil War", amount = 201000),
            SearchedTerm(term = "Star Trek", amount = 1220000),
            SearchedTerm(term = "Lung Cancer", amount = 201000),
            SearchedTerm(term = "Andre the Giant", amount = 301000),
            SearchedTerm(term = "Nineteen Eighty Four", amount = 14800),
            SearchedTerm(term = "Immigration", amount = 823000),
            SearchedTerm(term = "Tumblr", amount = 13600000),
            SearchedTerm(term = "Mona Lisa", amount = 823000),
            SearchedTerm(term = "Germany", amount = 1220000),
            SearchedTerm(term = "Scented Candles", amount = 40500),
            SearchedTerm(term = "Pizza", amount = 7480000),
            SearchedTerm(term = "Pac-Man", amount = 5000000),
            SearchedTerm(term = "Menopause", amount = 450000),
            SearchedTerm(term = "The Establishment", amount = 14800),
            SearchedTerm(term = "Gangnam Style", amount = 673000),
            SearchedTerm(term = "ABBA", amount = 673000),
            SearchedTerm(term = "Rosa Parks", amount = 450000),
            SearchedTerm(term = "Trafficking", amount = 60500),
            SearchedTerm(term = "Jaws", amount = 368000),
            SearchedTerm(term = "Inter Milan", amount = 823000),
            SearchedTerm(term = "Harvey Weinstein", amount = 2240000),
            SearchedTerm(term = "Counselling", amount = 550000),
            SearchedTerm(term = "Pug", amount = 1500000),
            SearchedTerm(term = "Red Nose Day", amount = 201000),
            SearchedTerm(term = "Robert Redford", amount = 550000),
            SearchedTerm(term = "South Korea", amount = 550000),
            SearchedTerm(term = "Gawker", amount = 60500),
            SearchedTerm(term = "Notts County", amount = 90500),
            SearchedTerm(term = "Fencing", amount = 1220000),
            SearchedTerm(term = "Hoover Dam", amount = 246000),
            SearchedTerm(term = "Heart Disease", amount = 135000),
            SearchedTerm(term = "Golden Retriever", amount = 1830000),
            SearchedTerm(term = "Darren Aronofsky", amount = 301000),
            SearchedTerm(term = "Dark Souls III", amount = 74000),
            SearchedTerm(term = "Threesome", amount = 550000),
            SearchedTerm(term = "iPhone x", amount = 11100000),
            SearchedTerm(term = "Islam", amount = 823000),
            SearchedTerm(term = "Lays", amount = 368000),
            SearchedTerm(term = "The Wire", amount = 450000),
            SearchedTerm(term = "Spectre", amount = 450000),
            SearchedTerm(term = "Rocky", amount = 450000),
            SearchedTerm(term = "Mother Teresa", amount = 368000),
            SearchedTerm(term = "Ticketmaster", amount = 9140000),
            SearchedTerm(term = "Tampax", amount = 74000),
            SearchedTerm(term = "NWA", amount = 368000),
            SearchedTerm(term = "Deutsche Bank", amount = 3350000),
            SearchedTerm(term = "The Joe Rogan Experience", amount = 49500),
            SearchedTerm(term = "Jordan", amount = 2740000),
            SearchedTerm(term = "Mercury", amount = 550000),
            SearchedTerm(term = "Truman Show", amount = 246000),
            SearchedTerm(term = "France", amount = 1500000),
            SearchedTerm(term = "The Prestige", amount = 301000),
            SearchedTerm(term = "Doctors Without Borders", amount = 74000),
            SearchedTerm(term = "Xi Jinping", amount = 201000),
            SearchedTerm(term = "Pensions", amount = 49500),
            SearchedTerm(term = "Canoeing", amount = 90500),
            SearchedTerm(term = "Rod Stewart", amount = 550000),
            SearchedTerm(term = "Parascending", amount = 2400),
            SearchedTerm(term = "Teeth Whitening", amount = 301000),
            SearchedTerm(term = "Vietnam War", amount = 550000),
            SearchedTerm(term = "Michigan Stadium", amount = 14800),
            SearchedTerm(term = "13 Reasons Why", amount = 6120000),
            SearchedTerm(term = "Canada", amount = 2240000),
            SearchedTerm(term = "Argentina", amount = 1500000),
            SearchedTerm(term = "Vandalism", amount = 450000),
            SearchedTerm(term = "Bitcoin", amount = 11100000),
            SearchedTerm(term = "Bilderberg Group", amount = 22200),
            SearchedTerm(term = "The Supremes", amount = 40500),
            SearchedTerm(term = "Weightlifting", amount = 40500),
            SearchedTerm(term = "Katy Perry", amount = 4090000),
            SearchedTerm(term = "New York Jets", amount = 246000),
            SearchedTerm(term = "Vietnam", amount = 1220000),
            SearchedTerm(term = "Gladiator", amount = 673000),
            SearchedTerm(term = "David Beckham", amount = 1000000),
            SearchedTerm(term = "Myspace", amount = 1220000),
            SearchedTerm(term = "Wembley Stadium", amount = 201000),
            SearchedTerm(term = "Rugby Union", amount = 74000),
            SearchedTerm(term = "Reykjavik", amount = 368000),
            SearchedTerm(term = "Currency Converter", amount = 6120000),
            SearchedTerm(term = "Taipei", amount = 301000),
            SearchedTerm(term = "The Rolling Stones", amount = 165000),
            SearchedTerm(term = "Citizen Kane", amount = 165000),
            SearchedTerm(term = "Protein Shakes", amount = 201000),
            SearchedTerm(term = "Sunglasses", amount = 673000),
            SearchedTerm(term = "Timer", amount = 3350000),
            SearchedTerm(term = "eBay", amount = 124000000),
            SearchedTerm(term = "Leonardo Da Vinci", amount = 1220000),
            SearchedTerm(term = "United States", amount = 823000),
            SearchedTerm(term = "Real Madrid", amount = 20400000),
            SearchedTerm(term = "Hurricane Matthew", amount = 110000),
            SearchedTerm(term = "Rafael Nadal", amount = 1500000),
            SearchedTerm(term = "DuckDuckGo", amount = 2740000),
            SearchedTerm(term = "Marvin Gaye", amount = 368000),
            SearchedTerm(term = "Ramadan", amount = 673000),
            SearchedTerm(term = "The Rock", amount = 1500000),
            SearchedTerm(term = "Karma", amount = 823000),
            SearchedTerm(term = "Triple H", amount = 368000),
            SearchedTerm(term = "The Powerpuff Girls", amount = 40500),
            SearchedTerm(term = "Kanye West", amount = 2240000),
            SearchedTerm(term = "The Little Prince", amount = 135000),
            SearchedTerm(term = "Piano", amount = 6120000),
            SearchedTerm(term = "Chevrolet", amount = 3350000),
            SearchedTerm(term = "Only Fools and Horses", amount = 90500),
            SearchedTerm(term = "Mein Kampf", amount = 301000),
            SearchedTerm(term = "Schizophrenia", amount = 1000000),
            SearchedTerm(term = "Nits", amount = 301000),
            SearchedTerm(term = "Cheese Fondue", amount = 40500),
            SearchedTerm(term = "Badminton", amount = 1000000),
            SearchedTerm(term = "Teenage Pregnancy", amount = 90500),
            SearchedTerm(term = "Wonka", amount = 22200),
            SearchedTerm(term = "BMW", amount = 6120000),
            SearchedTerm(term = "Free Climbing", amount = 12100),
            SearchedTerm(term = "Requiem For A Dream", amount = 368000),
            SearchedTerm(term = "European Union", amount = 823000),
            SearchedTerm(term = "The Shining", amount = 450000),
            SearchedTerm(term = "Candy Crush Saga", amount = 7480000),
            SearchedTerm(term = "Deadpool", amount = 2740000),
            SearchedTerm(term = "Jeremy Clarkson", amount = 246000),
            SearchedTerm(term = "Halloween", amount = 4090000),
            SearchedTerm(term = "Casablanca", amount = 673000),
            SearchedTerm(term = "Meningitis", amount = 1000000),
            SearchedTerm(term = "Arrested Development", amount = 368000),
            SearchedTerm(term = "iPhone 8", amount = 16600000),
            SearchedTerm(term = "True Detective", amount = 450000),
            SearchedTerm(term = "Hillary Clinton", amount = 1500000),
            SearchedTerm(term = "Amsterdam", amount = 2240000),
            SearchedTerm(term = "Birthday Cake", amount = 2240000),
            SearchedTerm(term = "Therapy", amount = 301000),
            SearchedTerm(term = "Manuel Neuer", amount = 368000),
            SearchedTerm(term = "Chichen Itza", amount = 301000),
            SearchedTerm(term = "Rowing", amount = 60500),
            SearchedTerm(term = "HSBC", amount = 9140000),
            SearchedTerm(term = "Kristen Stewart", amount = 2240000),
            SearchedTerm(term = "Road Runner", amount = 368000),
            SearchedTerm(term = "New York Yankees", amount = 1220000),
            SearchedTerm(term = "Abraham Lincoln", amount = 823000),
            SearchedTerm(term = "Marie Curie", amount = 550000),
            SearchedTerm(term = "Harassment", amount = 246000),
            SearchedTerm(term = "Toy Story", amount = 1000000),
            SearchedTerm(term = "Theresa May", amount = 1000000),
            SearchedTerm(term = "Feminism", amount = 550000),
            SearchedTerm(term = "Neptune", amount = 368000),
            SearchedTerm(term = "Man on Wire", amount = 27100),
            SearchedTerm(term = "Homer Simpson", amount = 246000),
            SearchedTerm(term = "David Copperfield", amount = 201000),
            SearchedTerm(term = "Memento", amount = 368000),
            SearchedTerm(term = "Water Pollution", amount = 201000),
            SearchedTerm(term = "Abortion", amount = 368000),
            SearchedTerm(term = "The OC", amount = 301000),
            SearchedTerm(term = "Super Bowl", amount = 1830000),
            SearchedTerm(term = "Electrician", amount = 301000),
            SearchedTerm(term = "Andrea Pirlo", amount = 135000),
            SearchedTerm(term = "Scabies", amount = 823000),
            SearchedTerm(term = "How I Met Your Mother", amount = 1000000),
            SearchedTerm(term = "Milgram Experiment", amount = 49500),
            SearchedTerm(term = "The Catcher in the Rye", amount = 246000),
            SearchedTerm(term = "Springer Spaniel", amount = 165000),
            SearchedTerm(term = "Parkinsons Disease", amount = 368000),
            SearchedTerm(term = "Translate", amount = 277000000),
            SearchedTerm(term = "Palm Islands", amount = 49500),
            SearchedTerm(term = "Sky Dive", amount = 22200),
            SearchedTerm(term = "Mariah Carey", amount = 2740000),
            SearchedTerm(term = "Benjamin Franklin", amount = 550000),
            SearchedTerm(term = "Jerry Rice", amount = 90500),
            SearchedTerm(term = "Four Tops", amount = 22200),
            SearchedTerm(term = "Hair Transplant", amount = 110000),
            SearchedTerm(term = "Tunisia", amount = 301000),
            SearchedTerm(term = "London", amount = 2740000),
            SearchedTerm(term = "Golden Gate Bridge", amount = 368000),
            SearchedTerm(term = "Masai Mara", amount = 49500),
            SearchedTerm(term = "Midwifery", amount = 135000),
            SearchedTerm(term = "Adderall", amount = 823000),
            SearchedTerm(term = "Jim Brown", amount = 74000),
            SearchedTerm(term = "Fleetwood Mac", amount = 450000),
            SearchedTerm(term = "Honda", amount = 5000000),
            SearchedTerm(term = "Mirrors Edge", amount = 135000),
            SearchedTerm(term = "IKEA", amount = 37200000),
            SearchedTerm(term = "Paul Mccartney", amount = 823000),
            SearchedTerm(term = "Toronto Maple Leafs", amount = 1000000),
            SearchedTerm(term = "William Shakespeare", amount = 550000),
            SearchedTerm(term = "Antidepressants", amount = 201000),
            SearchedTerm(term = "Flute", amount = 246000),
            SearchedTerm(term = "Taxi", amount = 2240000),
            SearchedTerm(term = "Child Marriage", amount = 27100),
            SearchedTerm(term = "Braveheart", amount = 450000),
            SearchedTerm(term = "Chris Brown", amount = 1830000),
            SearchedTerm(term = "Yorkshire Terrier", amount = 550000),
            SearchedTerm(term = "Periodic Table", amount = 3350000),
            SearchedTerm(term = "Shawn Michaels", amount = 165000),
            SearchedTerm(term = "Mortgage Calculator", amount = 3350000),
            SearchedTerm(term = "Prague", amount = 823000),
            SearchedTerm(term = "Dating Websites", amount = 74000),
            SearchedTerm(term = "Minimum Wage", amount = 550000),
            SearchedTerm(term = "Minecraft", amount = 45500000),
            SearchedTerm(term = "Vaseline", amount = 301000),
            SearchedTerm(term = "The Usual Suspects", amount = 165000),
            SearchedTerm(term = "Urban Dictionary", amount = 6120000),
            SearchedTerm(term = "Malaria", amount = 550000),
            SearchedTerm(term = "Carpenter", amount = 301000),
            SearchedTerm(term = "Julian Assange", amount = 368000),
            SearchedTerm(term = "Tara Palmer Tompkinson", amount = 301000),
            SearchedTerm(term = "The Sabbath", amount = 4400),
            SearchedTerm(term = "Human Rights", amount = 246000),
            SearchedTerm(term = "Tai Chi", amount = 301000),
            SearchedTerm(term = "The Secret Life of Pets", amount = 550000),
            SearchedTerm(term = "Saudi Arabia", amount = 823000),
            SearchedTerm(term = "Jeff Bezos", amount = 823000),
            SearchedTerm(term = "Car Insurance", amount = 1220000),
            SearchedTerm(term = "Disney", amount = 2740000),
            SearchedTerm(term = "Sex Positions", amount = 1830000),
            SearchedTerm(term = "Chronic Fatigue Syndrome", amount = 165000)
        )
    }
}