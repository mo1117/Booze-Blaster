package com.boozeblaster.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getButtonColor
import com.boozeblaster.ui.theme.getFontColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
        onClick = { onClick() },
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

@Composable
fun SimpleIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color? = null,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.UI,
    imageVector: ImageVector,
    contentDescription: String = ""
) {

    val buttonColor = color ?: getButtonColor(buttonType = buttonType)

    Button(
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = getFontColor()
        )
    }
}

@Composable
fun SimpleImageButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentDescription: String = "",
    text: String? = null,
    imageId: Int,
    fontFamily: FontFamily = FontFamily.SansSerif,
    fontSize: Int = 20
) {


    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = getBackgroundColor()),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        )
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = imageId),
            contentDescription = contentDescription,
        )
    }
    if (text != null) {
        SimpleTextDisplay(text = text, fontSize = fontSize, fontFamily = fontFamily)
    }
}