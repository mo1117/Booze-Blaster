package com.boozeblaster.filters

import android.util.Log
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

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

                val string = response.body.toString()

                if (response.body!!.string() == "true") {
                    return true
                }
                return false
            } catch (e: Exception) {
                Log.e("ProfanityFilter", "Something went wrong!")
                e.printStackTrace()
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
        private val offlineList =
            listOf(
                "retard",
                "asshole",
                "idiot",
                "ass",
                "stupid",
                "mongoloid",
                "douche",
                "gay",
                "lesbian",
                "fuck",
                "fucker",
                "pussy",
                "weewee",
                "scum",
                "douchebag"
            )
    }
}