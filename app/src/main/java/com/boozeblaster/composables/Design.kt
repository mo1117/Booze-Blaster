package com.boozeblaster.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun ClickableSurfaceWithColumn(
    onSurfaceClicked: () -> Unit,
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
            .clickable(onClick = { onSurfaceClicked() })
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            content()
        }
    }
}

@Composable
fun SurfaceWithColumn(
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            content()
        }
    }
}