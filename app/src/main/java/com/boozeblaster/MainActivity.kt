package com.boozeblaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.boozeblaster.navigation.Navigation
import com.boozeblaster.ui.theme.BoozeBlasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoozeBlasterTheme {
                Navigation()
            }
        }
    }
}