package com.boozeblaster.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun MyAnimatedVisibility(
    visible: Boolean,
    animationDuration: Int,
    content: @Composable() () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = animationDuration),
            initialOffsetY = { 500 })
                + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = animationDuration),
            targetOffsetY = { 500 }
        ) + shrinkVertically() + fadeOut()
    ) {
        Surface(modifier = Modifier.fillMaxSize(fraction = 1f)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(color = getBackgroundColor())
            ) {
                content()
            }
        }
    }
}

@Composable
fun MyAnimatedImageChanger(
    visible: Boolean,
    animationDuration: Int,
    content: @Composable() () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = animationDuration),
            initialOffsetY = { 700 })
                + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = animationDuration),
            targetOffsetY = { -700 }
        ) + shrinkVertically() + fadeOut()
    ) {
        Surface(modifier = Modifier.fillMaxSize(fraction = 1f)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(color = getBackgroundColor())
            ) {
                content()
            }
        }
    }
}