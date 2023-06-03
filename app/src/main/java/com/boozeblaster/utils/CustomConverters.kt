package com.boozeblaster.utils

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class CustomConverters {

    @TypeConverter
    fun dateToString(date: Date): String = date.toString()

    @TypeConverter
    fun stringToDate(string: String): Date = SimpleDateFormat().parse(string)
}