package com.boozeblaster.composables.builder

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

open class SimpleCardBuilder : CardBuilder() {

    @Composable
    override fun build(): @Composable () -> Unit = {
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