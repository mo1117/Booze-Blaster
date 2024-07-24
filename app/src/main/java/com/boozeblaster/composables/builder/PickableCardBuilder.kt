package com.boozeblaster.composables.builder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.getButtonColor

class PickableCardBuilder : SimpleCardBuilder() {

    @Composable
    override fun build(): @Composable () -> Unit = {
        if (pickable) {
            var isPicked by remember {
                mutableStateOf(value = false)
            }
            backgroundColor =
                    if (isPicked) getButtonColor(ButtonType.CORRECT) else getButtonColor(ButtonType.INCORRECT)
            onClick = {
                isPicked = !isPicked
                callback()
            }
        }
        super.build()
    }
}