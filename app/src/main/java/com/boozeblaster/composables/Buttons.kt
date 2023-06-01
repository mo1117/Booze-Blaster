package com.boozeblaster.composables

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Represents a simple button that can be used to display text and perform onClick actions
 */
@Composable
fun SimpleButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    fontSize: Int,
    fontFamily: FontFamily,
    color: Color,
    enabled: Boolean = true
) {

    //TODO maybe we want some cool standard button onClick effects?

    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(color),
        shape = AbsoluteRoundedCornerShape(percent = 100)
    ) {
        SimpleTextDisplay(
            text = text,
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}