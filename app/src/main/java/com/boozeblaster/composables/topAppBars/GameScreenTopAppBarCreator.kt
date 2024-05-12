package com.boozeblaster.composables.topAppBars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
import com.boozeblaster.composables.DisplayRuleBreaker
import com.boozeblaster.composables.DisplayScore
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getFontColor

class GameScreenTopAppBarCreator : TopAppBarCreator() {
    @Composable
    override fun getAppBarTitle(): @Composable () -> Unit {
        return {}
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

    override fun getActions(currentRound: Int): @Composable() (RowScope.() -> Unit) {
        return {
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
        }
    }
}