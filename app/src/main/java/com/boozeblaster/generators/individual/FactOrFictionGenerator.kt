package com.boozeblaster.generators.individual

import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.FactOrFiction

class FactOrFictionGenerator : MiniGameGenerator() {

    override fun getList(): List<MiniGame> {
        return super.getList(list = list, amount = 3)
    }

    /**
     * List of FactOrFiction instances
     */
    private companion object {
        private val list = listOf(
            FactOrFiction(
                question = "Some cats are allergic to people.",
                isCorrect = true),
            FactOrFiction(
                question = "Cows can walk upstairs, but they cannot walk downstairs.",
                isCorrect = false),
            FactOrFiction(
                question = "Bananas are berries, while strawberries are not.",
                isCorrect = true),
            FactOrFiction(
                question = "The Great Wall of China is visible from space without aid (e.g. telescopic lenses).",
                isCorrect = false),
            FactOrFiction(
                question = "Humans only use 10% of their brain.",
                isCorrect = false),
            FactOrFiction(
                question = "The Spanish Flu first started in Spain?",
                isCorrect = false),
            FactOrFiction(
                question = "The Canary Islands are named after dogs, not birds?",
                isCorrect = true),
            FactOrFiction(
                question = "A man has one less rib than a woman?",
                isCorrect = false),
            FactOrFiction(
                question = "The longest place name on the planet is in Wales?",
                isCorrect = false),
            FactOrFiction(
                question = "The national animal of Scotland is the unicorn?",
                isCorrect = true),
            FactOrFiction(
                question = "There are more stars in space than grains of sand on every beach in the world?",
                isCorrect = true),
            FactOrFiction(
                question = "Vikings wore horns on their helmets?",
                isCorrect = false),
            FactOrFiction(
                question = "Birds do not urinate?",
                isCorrect = true),
            FactOrFiction(
                question = "Ostriches stick their heads in the sand to hide from enemies?",
                isCorrect = false),
            FactOrFiction(
                question = "Camels store water in their humps?",
                isCorrect = false),
            FactOrFiction(
                question = "Carrots help you see better in the dark?",
                isCorrect = false),
            FactOrFiction(
                question = "Brazil is home to the biggest Japanese population outside of Japan?",
                isCorrect = true),
            FactOrFiction(
                question = "Goldfish have a three-second memory?",
                isCorrect = false),
            FactOrFiction(
                question = "In 1752, Britons went to bed on September 2 and woke up on September 14?",
                isCorrect = true),
            FactOrFiction(
                question = "Mercury is the warmest planet in the Solar System?",
                isCorrect = false),
            FactOrFiction(
                question = "Shaving makes hair grow back faster?",
                isCorrect = false),
            FactOrFiction(
                question = "Houseflies have an average lifespan of 20 to 30 days?",
                isCorrect = true),
            FactOrFiction(
                question = "Vincent Van Gogh only sold one painting in his lifetime?",
                isCorrect = true),
            FactOrFiction(
                question = "Sharks can smell a drop of blood from several miles away?",
                isCorrect = false),
            FactOrFiction(
                question = "Bats are blind?",
                isCorrect = false),
            FactOrFiction(
                question = "Alcohol destroys brain cells?",
                isCorrect = false),
            FactOrFiction(
                question = "The Eiffel Tower grows up to 6 inches over the summer.",
                isCorrect = true),
            FactOrFiction(
                question = "The composition of a star is fire and ice.",
                isCorrect = false),
            FactOrFiction(
                question = "The human heart beats 27 times per minute.",
                isCorrect = false),
            FactOrFiction(
                question = "Venus is one of two planets that rotate clockwise.",
                isCorrect = true),
            FactOrFiction(
                question = "Your eyes can always see your nose but your brain ignores it.",
                isCorrect = true),
            FactOrFiction(
                question = "Uranus was originally named “Georgium Sidus,” or George for short.",
                isCorrect = false),
            FactOrFiction(
                question = "The Celsius and Fahrenheit scales are the same at -40 degrees.",
                isCorrect = true),
            FactOrFiction(
                question = "The newest addition to the periodic table was added in 2012.",
                isCorrect = false),
            FactOrFiction(
                question = "There are more individual species of mosquitoes than general species of mammals.",
                isCorrect = false),
            FactOrFiction(
                question = "At the start of its voyage, the Titanic had 20,000 bottles of beer, 1,500 bottles of wine, and 8,000 cigars on board. ",
                isCorrect = true),
            FactOrFiction(
                question = "During WWI Australian troops smuggled kangaroos to the warfront as mascots.",
                isCorrect = true),
            FactOrFiction(
                question = "The Caesar salad was named for Julius Caesar. ",
                isCorrect = false),
            FactOrFiction(
                question = "The shortest war in history lasted only 38 minutes. ",
                isCorrect = true),
            FactOrFiction(
                question = "The Netherlands was the first country to officially legalize same-sex marriage.",
                isCorrect = true),
            FactOrFiction(
                question = "NYT crossword puzzle editor Will Shortz helped Jon Stewart propose to his girlfriend.",
                isCorrect = true),
            FactOrFiction(
                question = "Selena Gomez can play many instruments, including the cello, violin, and trumpet.",
                isCorrect = false),
            FactOrFiction(
                question = "Game of Thrones’ Night Watch cloaks are made out of rugs from IKEA. ",
                isCorrect = true),
            FactOrFiction(
                question = "Dolly Parton once lost a Dolly Parton lookalike contest.",
                isCorrect = true),
            FactOrFiction(
                question = "Sydney is the capital of Australia",
                isCorrect = false),
            FactOrFiction(
                question = "Electricity is basically a flow of atoms from one place to another.",
                isCorrect = false),
            FactOrFiction(
                question = "Stephen King is a famous American writer of romantic novels.",
                isCorrect = false),
            FactOrFiction(
                question = "Samba is a lively dance that originated in Argentina.",
                isCorrect = false),
            FactOrFiction(
                question = " The official currency in Singapore is the Singapore dollar.",
                isCorrect = true)
        )
    }
}