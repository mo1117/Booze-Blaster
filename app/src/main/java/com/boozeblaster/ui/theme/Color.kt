package com.boozeblaster.ui.theme

import androidx.compose.ui.graphics.Color
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.enums.ButtonType

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val DarkAppBar = Color(0xFF6A1B9A)
val DarkBackGround = Color(0xFF0D47A1)
val DarkFontColor = Color.White

val LightAppBar = Color(0xFFFFF8E1)
val LightBackground = Color(0xFFFFCDD2)
val LightFontColor = Color.Black

// Button Colors

val LightCorrectButtonColor = Color(0xFF07EE1F)
val DarkCorrectButtonColor = Color(0xFF2A8834)

val LightIncorrectButtonColor = Color(0xFFEC0909)
val DarkIncorrectButtonColor = Color(0xFF581818)

val LightHalfCorrectButtonColor = Color(0xFFFD5D01)
val DarkHalfCorrectButtonColor = Color(0xFF924222)

val LightUiButtonColor = Color(0xFF36BB96)
val DarkUiButtonColor = Color(0xFF1D2947)

/**
 * Returns the button color, based on which kind of button it is and if darkmode is enabled or not
 * @param buttonType ButtonType
 * @return Color
 */
fun getButtonColor(buttonType: ButtonType = ButtonType.UI): Color {
    val darkmode = DarkmodeController.isDarkmode()
    return when (buttonType) {
        ButtonType.CORRECT -> if (darkmode) DarkCorrectButtonColor else LightCorrectButtonColor
        ButtonType.INCORRECT -> if (darkmode) DarkIncorrectButtonColor else LightIncorrectButtonColor
        ButtonType.HALF_CORRECT -> if (darkmode) DarkHalfCorrectButtonColor else LightHalfCorrectButtonColor
        ButtonType.UI -> if (darkmode) DarkUiButtonColor else LightUiButtonColor
    }
}

/**
 * Background color
 * @return Color
 */
fun getBackgroundColor(): Color {
    return if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
}

/**
 * Font Color
 * @return Color
 */
fun getFontColor(): Color {
    return if (DarkmodeController.isDarkmode()) DarkFontColor else LightFontColor
}

/**
 * AppBar Color
 * @return Color
 */
fun getAppBarColor(): Color {
    return if (DarkmodeController.isDarkmode()) DarkAppBar else LightAppBar
}