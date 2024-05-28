package com.boozeblaster.composables.builder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.backgroundColorForCard
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getButtonColor

class CardBuilder {

    var modifier: Modifier = Modifier
    var width = 220.dp
    var height = 120.dp
    var onClick = {}
    var callback = {}
    var shape = AbsoluteRoundedCornerShape(size = 20.dp)
    var backgroundColor = getBackgroundColor().backgroundColorForCard()
    var border: BorderStroke? = null
    var elevation = 4.dp
    var padding = 16.dp
    var enabled = true
    var content: @Composable BoxScope.() -> Unit = {}
    var pickable = false

    @Composable
    fun build() {
        if (pickable) {
            var isPicked by remember {
                mutableStateOf(value = false)
            }
            val color =
                if (isPicked) getButtonColor(ButtonType.CORRECT) else getButtonColor(ButtonType.INCORRECT)
            onClick = {
                isPicked = !isPicked
                callback()
            }
        }

        Card(
            modifier = modifier
                .size(width = width, height = height)
                .clickable(onClick = onClick, enabled = enabled)
                .padding(all = padding),
            shape = shape,
            backgroundColor = backgroundColor,
            border = border,
            elevation = elevation
        ) {
            Box(
                contentAlignment = Alignment.Center,
                content = content,
                modifier = Modifier.background(color = backgroundColor)
            )
        }
    }
}