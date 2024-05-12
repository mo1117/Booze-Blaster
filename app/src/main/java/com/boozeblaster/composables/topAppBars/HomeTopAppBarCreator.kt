package com.boozeblaster.composables.topAppBars

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.ui.theme.getFontColor
import kotlin.system.exitProcess

class HomeTopAppBarCreator : TopAppBarCreator() {

    @Composable
    override fun getAppBarTitle(): @Composable () -> Unit {
        return {
            SimpleTextDisplay(
                text = "Booze Blaster",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }

    override fun getNavigationIcon(onBackButtonClick: () -> Unit): @Composable() (() -> Unit)? {
        return {
            var showMenu by remember {
                mutableStateOf(false)
            }
            IconButton(onClick = {
                showMenu = true
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = getFontColor()
                )
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(onClick = { exitProcess(status = 1) }) {
                    Text(text = "Quit")
                }
            }
        }
    }
}