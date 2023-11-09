package com.boozeblaster.composables

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ClickableSurfaceWithColumn(
    onSurfaceClicked: () -> Unit,
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(fraction = 1f)
            .clickable(onClick = onSurfaceClicked)
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            content()
        }
    }
}

@Composable
fun SurfaceWithColumn(
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Surface(
        modifier = Modifier.fillMaxSize(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.background(
                color = getBackgroundColor()
            ).verticalScroll(state = ScrollState(initial = 0))
        ) {
            content()
        }
    }
}

@Composable
fun DisplayScore(
    callback: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    var isVisible by remember {
        mutableStateOf(value = false)
    }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    MyAnimatedVisibilityTopToTop(
        visible = isVisible,
        animationDuration = AnimationConstants.SHOW_SCOREBOARD_FADE_IN_OUT.durationMillis
    ) {
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val players = Game.getPlayersByPointsDescending()

            SimpleTextDisplay(text = "Scoreboard", fontSize = 30, fontFamily = headerFont)
            SimpleSpacer(size = 30)

            LazyColumn(
                modifier = Modifier
                    .height(height = 300.dp)
                    .fillMaxWidth(fraction = 0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                content = {
                    items(players) { player ->
                        Row {
                            SimpleTextDisplay(
                                text = "${player.getName()} | ${player.getPoints()} Points | " +
                                        "${player.getSips()} Sips\n",
                                fontSize = 20,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                })

            SimpleSpacer(size = 30)
            SimpleButton(
                onClick = {
                    coroutineScope.launch {
                        isVisible = false
                        delay(timeMillis = AnimationConstants.SHOW_SCOREBOARD_FADE_IN_OUT.durationMillis.toLong())
                        callback()
                    }
                },
                text = "Continue",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Composable
fun DisplayRuleBreaker(
    callback: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    var isVisible by remember {
        mutableStateOf(value = false)
    }

    var showDialog by remember {
        mutableStateOf(value = false)
    }

    var pickedPlayers by remember {
        mutableStateOf(value = emptyList<Player>())
    }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    MyAnimatedVisibilityTopToTop(
        visible = isVisible,
        animationDuration = AnimationConstants.SHOW_RULEBREAKER_FADE_IN_OUT.durationMillis
    ) {
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "Pick Players that have broken a rule!",
                fontSize = 30,
                fontFamily = headerFont
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(height = 400.dp)
                    .fillMaxWidth(fraction = 0.9f),
                content = {
                    items(items = Game.getPlayers()) { player ->
                        SimpleSpacer(size = 10)

                        SimpleButton(
                            onClick = {
                                pickedPlayers = if (pickedPlayers.contains(element = player)) {
                                    pickedPlayers.minus(element = player)
                                } else {
                                    pickedPlayers.plus(element = player)
                                }
                            },
                            text = player.getName(),
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif,
                            buttonType = if (pickedPlayers.contains(element = player))
                                ButtonType.CORRECT else ButtonType.INCORRECT,
                            enabled = !showDialog
                        )
                    }
                })

            SimpleSpacer(size = 30)

            SimpleButton(
                onClick = { showDialog = true },
                text = "Check",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif,
                needsConfirmation = true,
                enabled = !showDialog
            )

            SimpleSpacer(size = 50)

            if (showDialog) {
                AskPlayersToDrinkDialog(
                    players = pickedPlayers,
                    sips = Game.getSipMultiplier(),
                    callback = {
                        for (player in pickedPlayers) {
                            player.addSips(sips = Game.getSipMultiplier())
                        }
                        coroutineScope.launch {
                            isVisible = false
                            delay(timeMillis = AnimationConstants.SHOW_SCOREBOARD_FADE_IN_OUT.durationMillis.toLong())
                            pickedPlayers = emptyList()
                            showDialog = false
                            callback()
                        }
                    })
            }
        }
    }
}