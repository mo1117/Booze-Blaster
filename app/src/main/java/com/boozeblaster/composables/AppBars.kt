package com.boozeblaster.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.boozeblaster.ui.theme.*
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlin.system.exitProcess

@Composable
fun HomeTopAppBar(
) {

    var showMenu by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(
                text = "Booze Blaster", color = if (true) { //TODO darkmode
                    DarkFontColor
                } else {
                    LightFontColor
                }
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                showMenu = true
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(onClick = { exitProcess(1) }) {
                    Text(text = "Quit")
                }
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "User")
            }
            Switch(checked = true, onCheckedChange = {  }) //TODO darkmode
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = if (true) {
            DarkAppBar
        } else {
            LightAppBar
        }
    )
}

@Composable
fun SimpleTopAppBar(onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Booze Blaster", color = if (true) { //TODO darkmode
                    DarkFontColor
                } else {
                    LightFontColor
                }
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "User")
            }
            Switch(checked = true, onCheckedChange = { })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = if (true) {
            DarkAppBar
        } else {
            LightAppBar
        }
    )
}