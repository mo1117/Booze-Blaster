package com.boozeblaster.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun MyAnimatedVisibilityTopToTop(
    visible: Boolean,
    animationDuration: Int,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = animationDuration),
            initialOffsetY = { -500 })
                + expandVertically(
            expandFrom = Alignment.Bottom
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = animationDuration),
            targetOffsetY = { -500 }
        ) + shrinkVertically(
            shrinkTowards = Alignment.Bottom
        ) + fadeOut(targetAlpha = 0.3f)
    ) {
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}