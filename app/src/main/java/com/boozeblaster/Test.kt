package com.boozeblaster

import android.content.Context
import java.io.File

fun main() {
    File("app/src/main/assets/higher_lower.txt").forEachLine {
        println(it)
    }
}