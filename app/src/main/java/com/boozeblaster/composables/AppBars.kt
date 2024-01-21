package com.boozeblaster.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getAppBarColor
import com.boozeblaster.ui.theme.getFontColor
import kotlin.system.exitProcess

@Composable
fun HomeTopAppBar() {
    var showMenu by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            SimpleTextDisplay(
                text = "Booze Blaster",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        },
        navigationIcon = {
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
        },
        actions = {
            Switch(
                checked = DarkmodeController.isDarkmode(),
                onCheckedChange = {
                    DarkmodeController.toggle()
                })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = getAppBarColor()
    )
}

@Composable
fun SimpleTopAppBar(onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Booze Blaster",
                color = getFontColor()
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "BackButton",
                    tint = getFontColor()
                )
            }
        },
        actions = {
            Switch(
                checked = DarkmodeController.isDarkmode(),
                onCheckedChange = {
                    DarkmodeController.toggle()
                })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = getAppBarColor()
    )
}

@Composable
fun GameScreenAppBar(
    onBackButtonClick: () -> Unit,
    currentRound: Int,
    onRestartClicked: () -> Unit
) {
    val totalRounds = Game.getRounds()
    var showScore by remember {
        mutableStateOf(value = false)
    }
    var displayRuleBreaker by remember {
        mutableStateOf(value = false)
    }

    if (showScore) {
        DisplayScore(callback = { showScore = false })
    }

    if (displayRuleBreaker) {
        DisplayRuleBreaker(callback = { displayRuleBreaker = false })
    }

    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "BackButton",
                    tint = getFontColor()
                )
            }
        },
        actions = {
            IconButton(onClick = { displayRuleBreaker = true }) {
                Image(
                    modifier = Modifier.size(size = 35.dp),
                    painter = painterResource(
                        id = R.drawable.judge_hammer_black
                    ),
                    contentDescription = "Rule Breaker Icon"
                )
            }
            SimpleSpacer(size = 10)

            IconButton(onClick = { showScore = true }) {
                Image(
                    modifier = Modifier.size(size = 35.dp),
                    painter = painterResource(id = R.drawable.scoreboard),
                    contentDescription = "Scoreboard Icon"
                )
            }

            SimpleSpacer(size = 10)
            SimpleTextDisplay(
                text = "Round $currentRound / $totalRounds",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif
            )
            SimpleSpacer(size = 10)
            Switch(
                checked = DarkmodeController.isDarkmode(),
                onCheckedChange = {
                    DarkmodeController.toggle()
                })
        },
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        ),
        backgroundColor = getAppBarColor()
    )
}