package com.boozeblaster.minigames.individual

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class FactOrFiction(
    private val question: String,
    private val isCorrect: Boolean
) : MiniGame {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { callback() })
        ) {
            Text(text = "$question\n$isCorrect")
        }
    }
}