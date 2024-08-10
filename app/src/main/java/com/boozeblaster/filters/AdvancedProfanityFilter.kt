package com.boozeblaster.filters

import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request

class AdvancedProfanityFilter : ProfanityFilter {

    private var successor: ((String) -> Boolean)? = null

    override fun setSuccessor(successor: ((String) -> Boolean)?) {
        this.successor = successor
    }

    override fun getFilter(): ((String) -> Boolean)? {
        if (isAdvancedProfanityFilterWorking()) {
            return ::handleRequest
        }
        if (successor != null) {
            return successor
        }
        return null
    }

    private fun handleRequest(input: String): Boolean {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://community-purgomalum.p.rapidapi.com/json?text=$input")
            .get()
            .addHeader("x-rapidapi-key", "c590643c5cmsh3299bc899151159p1782d8jsn1476007870da")
            .addHeader("x-rapidapi-host", "community-purgomalum.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            if (responseBody != null) {
                val gson = Gson()
                val jsonObject = gson.fromJson(responseBody, JsonObject::class.java)
                val result = jsonObject.get("result").asString
                return result != input
            }
        }
        return false
    }

    private fun isAdvancedProfanityFilterWorking(): Boolean {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://community-purgomalum.p.rapidapi.com/json?text=test")
            .get()
            .addHeader("x-rapidapi-key", "c590643c5cmsh3299bc899151159p1782d8jsn1476007870da")
            .addHeader("x-rapidapi-host", "community-purgomalum.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        return response.isSuccessful
    }
}