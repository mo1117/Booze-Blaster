package com.boozeblaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.boozeblaster.composables.MyAlertDialog
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.navigation.Navigation
import com.boozeblaster.ui.theme.BoozeBlasterTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoozeBlasterTheme {
                var overSixteen by remember {
                    mutableStateOf(value = false)
                }
                if (!overSixteen) {
                    MyAlertDialog(
                        title = "Confirm",
                        message = "This game enforces drinking alcohol and may contain " +
                                "sensitive language, do you wish to continue?",
                        onConfirm = { overSixteen = true },
                        onDismiss = { exitProcess(status = 1) })
                }
                DarkmodeController.load(context = LocalContext.current)
                Navigation()
            }
        }
    }
}