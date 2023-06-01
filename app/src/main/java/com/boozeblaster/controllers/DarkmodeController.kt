package com.boozeblaster.controllers

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class DarkmodeController private constructor(
    private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private var darkmode by mutableStateOf(sharedPreferences.getBoolean("dark_mode", true))

    companion object {
        @Volatile
        private var INSTANCE: DarkmodeController? = null

        fun load(context: Context) {
            INSTANCE = DarkmodeController(context = context)
        }

        fun isDarkmode(): Boolean {
            if (INSTANCE != null) {
                return INSTANCE!!.darkmode
            }
            return false
        }

        fun setDarkmode(darkmode: Boolean) {
            if (INSTANCE != null) {
                INSTANCE!!.darkmode = darkmode
                INSTANCE!!.editor.putBoolean("dark_mode", darkmode)
                INSTANCE!!.editor.apply()
            }
        }
    }
}