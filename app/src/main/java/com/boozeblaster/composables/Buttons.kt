package com.boozeblaster.composables

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

/**
 * Represents a simple button that can be used to display text and perform onClick actions
 */
@Composable
fun SimpleButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    fontSize: Int,
    fontFamily: FontFamily
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(text = text, fontFamily = fontFamily, fontSize = fontSize.sp)
    }
}