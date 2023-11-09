package com.boozeblaster.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun SimpleCard(
    modifier: Modifier = Modifier,
    width: Dp = 220.dp,
    height: Dp = 120.dp,
    onClick: () -> Unit = {},
    shape: Shape = AbsoluteRoundedCornerShape(20.dp),
    backgroundColor: Color = getBackgroundColor(),
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 10.dp,
    content: @Composable (BoxScope.() -> Unit)
) {
    Card(
        modifier = modifier
            .size(width = width, height = height)
            .clickable(onClick = onClick),
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = border,
        elevation = elevation
    ) {
        Box(contentAlignment = Alignment.Center, content = content)
    }
}