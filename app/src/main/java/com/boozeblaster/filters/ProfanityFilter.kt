package com.boozeblaster.filters

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File

/**
 * The ProfanityFilter is used to check if a username contains profanity
 *
 * When the API call fails for whatever reason, we still want to filter some bad words
 */
class ProfanityFilter {

    companion object {
        /**
         * This method is used to check if some input contains profanity
         * @param input String
         * @return True if there is any obscene input, false else
         */
        fun containsProfanity(input: String): Boolean {
            try {
                val client = OkHttpClient()

                val request = Request.Builder()
                    .url(url = "https://community-purgomalum.p.rapidapi.com/containsprofanity?text=$input")
                    .get()
                    .addHeader(
                        name = "X-RapidAPI-Key",
                        value = "c590643c5cmsh3299bc899151159p1782d8jsn1476007870da"
                    )
                    .addHeader(
                        name = "X-RapidAPI-Host",
                        value = "community-purgomalum.p.rapidapi.com"
                    )
                    .build()
                val response = client.newCall(request).execute()

                if (response.body!!.string() == "true") {
                    return true
                }
                return false
            } catch (e: Exception) {
                for (curseWord in offlineList) {
                    // Do NOT use .contains Method or e.g. Assassin will be filtered xD
                    if (input.equals(other = curseWord, ignoreCase = true)) {
                        return true
                    }
                }
                return false
            }
        }

        /**
         * Used to filter some bad words in case the API call throws and exception
         */
        private val offlineList = listOf("retard")

        private fun loadOfflineList(): List<String> {
            val list = arrayListOf<String>()
            File("app/src/main/assets/bad_words.txt").forEachLine(
                charset = Charsets.UTF_8,
                action = {
                    list.add(element = it)
                })
            return list
        }
    }
}