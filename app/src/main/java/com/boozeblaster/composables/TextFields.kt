package com.boozeblaster.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.ui.theme.DarkFontColor
import com.boozeblaster.ui.theme.LightFontColor

@Composable
fun SimpleTextField(
    modifier: Modifier,
    value: String,
    label: String,
    errorMsg: String = "",
    isError: Boolean,
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    onDone: () -> Unit = {},
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(fraction = 1f),
        value = value,
        label = { Text(text = label) },
        isError = isError,
        singleLine = singleLine,
        onValueChange = { onChange(it) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        keyboardActions = KeyboardActions(
            onDone = { onDone() }
        )
    )
    if (isError) {
        SimpleTextDisplay(text = errorMsg, fontSize = 16, fontFamily = FontFamily.SansSerif)
    }
}

@Composable
fun SimpleTextDisplay(
    text: String,
    fontSize: Int,
    fontFamily: FontFamily
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontFamily = fontFamily,
        softWrap = true,
        textAlign = TextAlign.Center,
        color = if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
    )
}