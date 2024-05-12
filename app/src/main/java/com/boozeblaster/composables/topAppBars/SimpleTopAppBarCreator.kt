package com.boozeblaster.composables.topAppBars

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.boozeblaster.ui.theme.getFontColor

class SimpleTopAppBarCreator : TopAppBarCreator() {

    @Composable
    override fun getAppBarTitle(): @Composable () -> Unit {
        return {
            Text(
                text = "Booze Blaster",
                color = getFontColor()
            )
        }
    }

    override fun getNavigationIcon(onBackButtonClick: () -> Unit): @Composable() (() -> Unit)? {
        return {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "BackButton",
                    tint = getFontColor()
                )
            }
        }
    }
}