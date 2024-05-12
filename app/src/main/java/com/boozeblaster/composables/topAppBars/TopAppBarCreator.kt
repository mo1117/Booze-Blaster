package com.boozeblaster.composables.topAppBars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Switch
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.ui.theme.getAppBarColor

abstract class TopAppBarCreator {

    @Composable
    fun CreateAppBar(onBackButtonClick: () -> Unit = {}, currentRound: Int = Double.NaN.toInt()) {
        TopAppBar(
            title = getAppBarTitle(),
            modifier = getModifier(),
            navigationIcon = getNavigationIcon(onBackButtonClick = onBackButtonClick),
            actions = getActions(),
            backgroundColor = getBackgroundColor(),
            contentColor = getContentColor(),
            elevation = getElevation()
        )
    }

    @Composable
    abstract fun getAppBarTitle(): @Composable () -> Unit

    open fun getModifier(): Modifier {
        return Modifier.clip(
            shape = RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            )
        )
    }

    abstract fun getNavigationIcon(onBackButtonClick: () -> Unit): @Composable (() -> Unit)?

    open fun getActions(currentRound: Int = 0): @Composable RowScope.() -> Unit = {
        Switch(
            checked = DarkmodeController.isDarkmode(),
            onCheckedChange = {
                DarkmodeController.toggle()
            })
    }

    open fun getBackgroundColor(): Color = getAppBarColor()

    @Composable
    open fun getContentColor(): Color = contentColorFor(backgroundColor = getBackgroundColor())

    open fun getElevation(): Dp = AppBarDefaults.TopAppBarElevation

}