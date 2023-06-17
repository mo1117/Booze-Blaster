package com.boozeblaster.composables

import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.getButtonColor

/**
 * Represents a simple button that can be used to display text and perform onClick actions
 */
@Composable
fun SimpleButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    fontSize: Int,
    fontFamily: FontFamily,
    color: Color? = null,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.UI
) {

    //TODO maybe we want some cool standard button onClick effects?

    val buttonColor = color ?: getButtonColor(buttonType = buttonType)

    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        shape = AbsoluteRoundedCornerShape(percent = 100)
    ) {
        SimpleTextDisplay(
            text = text,
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}