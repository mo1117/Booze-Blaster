package com.boozeblaster.composables

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

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
    Button(
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(color)
    ) {
        SimpleTextDisplay(text = text, fontSize = fontSize, fontFamily = fontFamily)
    }
}