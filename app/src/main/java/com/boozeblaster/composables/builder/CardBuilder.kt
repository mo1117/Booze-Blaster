package com.boozeblaster.composables.builder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.ui.theme.backgroundColorForCard
import com.boozeblaster.ui.theme.getBackgroundColor

abstract class CardBuilder {

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

    @Composable
    abstract fun build(): @Composable () -> Unit
}