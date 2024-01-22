package com.boozeblaster.composables

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.backgroundColorForCard
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getButtonColor

@Composable
fun SimpleCard(
    modifier: Modifier = Modifier,
    width: Dp = 220.dp,
    height: Dp = 120.dp,
    onClick: () -> Unit = {},
    shape: Shape = AbsoluteRoundedCornerShape(20.dp),
    backgroundColor: Color = getBackgroundColor().backgroundColorForCard(),
    border: BorderStroke? = null,
    elevation: Dp = 4.dp,
    padding: Dp = 16.dp,
    enabled: Boolean = true,
    content: @Composable (BoxScope.() -> Unit)
) {
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

@Composable
fun SimplePickableCard(
    modifier: Modifier = Modifier,
    width: Dp = 220.dp,
    height: Dp = 120.dp,
    shape: Shape = AbsoluteRoundedCornerShape(20.dp),
    border: BorderStroke? = null,
    elevation: Dp = 4.dp,
    padding: Dp = 16.dp,
    callback: () -> Unit,
    content: @Composable (BoxScope.() -> Unit)
) {
    var isPicked by remember {
        mutableStateOf(value = false)
    }
    val color = if (isPicked) getButtonColor(ButtonType.CORRECT) else getButtonColor(ButtonType.INCORRECT)


    SimpleCard(
        modifier = modifier,
        width = width,
        height = height,
        onClick = {
            isPicked = !isPicked
            callback()
        },
        shape = shape,
        backgroundColor = color,
        border = border,
        elevation = elevation,
        padding = padding,
        content = content
    )
}