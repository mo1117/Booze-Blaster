package com.boozeblaster.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun SimpleImage(
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    imageId: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imageId),
        contentDescription = contentDescription
    )
}