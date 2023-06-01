package com.boozeblaster.composables

import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.ui.theme.DarkAppBar
import com.boozeblaster.ui.theme.DarkFontColor
import com.boozeblaster.ui.theme.LightAppBar
import com.boozeblaster.ui.theme.LightFontColor
import kotlin.system.exitProcess

@Composable
fun HomeTopAppBar() {
    var showMenu by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(
                text = "Booze Blaster",
                color = if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                showMenu = true
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
                )
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(onClick = { exitProcess(1) }) {
                    Text(text = "Quit")
                }
            }
        },
        actions = {
            Switch(
                checked = DarkmodeController.isDarkmode(),
                onCheckedChange = {
                    DarkmodeController.setDarkmode(darkmode = !DarkmodeController.isDarkmode())
                })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = if (DarkmodeController.isDarkmode()) DarkAppBar else LightAppBar
    )
}

@Composable
fun SimpleTopAppBar(onBackButtonClick: () -> Unit) {
    val sharedPreferences =
        LocalContext.current.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    TopAppBar(
        title = {
            Text(
                text = "Booze Blaster",
                color = if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "BackButton",
                    tint = if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
                )
            }
        },
        actions = {
            Switch(
                checked = DarkmodeController.isDarkmode(),
                onCheckedChange = {
                    DarkmodeController.setDarkmode(darkmode = !DarkmodeController.isDarkmode())
                })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = if (DarkmodeController.isDarkmode()) DarkAppBar else LightAppBar
    )
}