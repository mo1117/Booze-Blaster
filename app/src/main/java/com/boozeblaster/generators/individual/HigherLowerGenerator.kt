package com.boozeblaster.generators.individual

import android.content.res.AssetManager
import com.boozeblaster.generators.MiniGameGenerator
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.minigames.individual.HigherLower
import com.boozeblaster.models.SearchedTerm
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import kotlin.random.Random

class HigherLowerGenerator : MiniGameGenerator() {

    @Override
    override fun getList(): List<MiniGame> {
//        val listOfSearchedTerms = getListOfSearchedTerms(assetManager = assets)
//        val randoms = generateRandomIndexes(size = listOfSearchedTerms.size)
//        val list = listOf(
//            HigherLower(
//                first = listOfSearchedTerms.get(index = randoms.get(index = 0)),
//                second = listOfSearchedTerms.get(index = randoms.get(index = 1))
//            ),
//            HigherLower(
//                first = listOfSearchedTerms.get(index = randoms.get(index = 1)),
//                second = listOfSearchedTerms.get(index = randoms.get(index = 2))
//            ),
//            HigherLower(
//                first = listOfSearchedTerms.get(index = randoms.get(index = 2)),
//                second = listOfSearchedTerms.get(index = randoms.get(index = 3))
//            ),
//            HigherLower(
//                first = listOfSearchedTerms.get(index = randoms.get(index = 3)),
//                second = listOfSearchedTerms.get(index = randoms.get(index = 4))
//            )
//        )
//        return super.getList(list = list, amount = 4, resetAllToUnused = false)
        TODO()
    }

    private fun getListOfSearchedTerms(assetManager: AssetManager): List<SearchedTerm> {
        val list = mutableListOf<SearchedTerm>()
        val reader = BufferedReader(InputStreamReader(assetManager.open("higher_lower.txt")))
        assetManager.open("higher_lower.txt").available()
        reader.forEachLine { string ->
            list.add(
                element = SearchedTerm(
                    term = string.substring(
                        startIndex = 0,
                        endIndex = string.indexOf(char = ':') - 1
                    ),
                    amount = string.substring(
                        startIndex = string.indexOf(char = ':') + 2,
                        endIndex = 0
                    ).toInt()
                )
            )
        }
//        File(assetManager.open("higher_lower.txt")).forEachLine { string ->
//            list.add(
//                element = SearchedTerm(
//                    term = string.substring(
//                        startIndex = 0,
//                        endIndex = string.indexOf(char = ':') - 1
//                    ),
//                    amount = string.substring(
//                        startIndex = string.indexOf(char = ':') + 2,
//                        endIndex = 0
//                    ).toInt()
//                )
//            )
//        }
        return list
    }

    private fun generateRandomIndexes(size: Int): Array<Int> {
        var randoms = arrayOf<Int>()
        if (size < 4) {
            throw Exception("Loading a list of searched terms not working(?)")
        }
        while (randoms.size < 4) {
            val random = Random.nextInt(from = 0, until = size)
            if (!randoms.contains(element = random)) {
                randoms = randoms.plus(element = random)
            }
        }
        return randoms
    }
}