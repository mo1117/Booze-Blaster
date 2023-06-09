package com.boozeblaster.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getFontColor
import kotlinx.coroutines.delay

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    errorMsg: String = "",
    isError: Boolean,
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    onDone: () -> Unit = {},
    onChange: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = getBackgroundColor(),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            value = value,
            label = { Text(text = label, color = if (isError) Color.Red else Color.Green) },
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
    }

    if (isError) {
        SimpleTextDisplay(text = errorMsg, fontSize = 16, fontFamily = FontFamily.SansSerif)
    }
}

@Composable
fun SimpleTextDisplay(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int,
    fontFamily: FontFamily,
    horizontalTextPadding: Int = 10
) {
    Text(
        modifier = modifier.padding(horizontal = horizontalTextPadding.dp),
        text = text,
        fontSize = fontSize.sp,
        fontFamily = fontFamily,
        softWrap = true,
        textAlign = TextAlign.Center,
        color = getFontColor()
    )
}

@Composable
fun AnimatingText(
    text: String,
    fontSize: Int,
    fontFamily: FontFamily
) {

    var textState by remember {
        mutableStateOf(value = text)
    }

    SimpleTextDisplay(text = textState, fontSize = fontSize, fontFamily = fontFamily)

    LaunchedEffect(Unit) {
        while (true) {
            textState = textState.uppercase()
            delay(timeMillis = 500)
            textState = textState.lowercase()
            delay(timeMillis = 500)
        }
    }
}