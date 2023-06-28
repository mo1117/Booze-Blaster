package com.boozeblaster.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.getBackgroundColor
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
    buttonType: ButtonType = ButtonType.UI,
    minWidth: Int = 150,
    minHeight: Int = 50,
    needsConfirmation: Boolean = false
) {

    val buttonColor = color ?: getButtonColor(buttonType = buttonType)

    var displayConfirmation by remember {
        mutableStateOf(value = needsConfirmation)
    }

    var buttonText by remember {
        mutableStateOf(value = text)
    }

    Button(
        onClick = {
            if (displayConfirmation) {
                displayConfirmation = false
                buttonText = "Confirm"
            } else {
                displayConfirmation = needsConfirmation
                buttonText = text
                onClick()
            }
        },
        modifier = modifier
            .sizeIn(
                minWidth = minWidth.dp,
                minHeight = minHeight.dp
            ),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        shape = AbsoluteRoundedCornerShape(percent = 100)
    ) {
        SimpleTextDisplay(
            text = buttonText,
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}

@Composable
fun SimpleChangeableButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: @Composable () -> Unit,
    fontSize: Int,
    fontFamily: FontFamily,
    color: Color? = null,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.UI,
    minWidth: Int = 150,
    minHeight: Int = 50,
    needsConfirmation: Boolean = false
) {
    val buttonColor = color ?: getButtonColor(buttonType = buttonType)

    var displayConfirmation by remember {
        mutableStateOf(value = needsConfirmation)
    }

    var buttonText by remember {
        mutableStateOf(value = text)
    }

    Button(
        onClick = {
            if (displayConfirmation) {
                displayConfirmation = false
                buttonText = {
                    SimpleTextDisplay(
                        text = "Confirm",
                        fontSize = fontSize,
                        fontFamily = fontFamily
                    )
                }
            } else {
                displayConfirmation = needsConfirmation
                buttonText = text
                onClick()
            }
        },
        modifier = modifier
            .sizeIn(
                minWidth = minWidth.dp,
                minHeight = minHeight.dp
            ),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        shape = AbsoluteRoundedCornerShape(percent = 100)
    ) {
        buttonText()
    }
}

/**
 * Simple Button that holds an image and performs onClick actions
 *
 * If needed. a text can be added that will then be displayed underneath the picture
 */
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
        colors = ButtonDefaults.buttonColors(
            backgroundColor = getBackgroundColor(),
            disabledBackgroundColor = getBackgroundColor()
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        enabled = enabled
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
