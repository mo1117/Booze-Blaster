package com.boozeblaster.theme

import androidx.compose.ui.graphics.Color
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.*
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class ColorTest {

    @Test
    fun testGetCorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.CORRECT)
        assertTrue(LightCorrectButtonColor == buttonColor || DarkCorrectButtonColor == buttonColor)
    }

    @Test
    fun testGetIncorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.INCORRECT)
        assertTrue(LightIncorrectButtonColor == buttonColor || DarkIncorrectButtonColor == buttonColor)
    }

    @Test
    fun testGetHalfCorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.HALF_CORRECT)
        assertTrue(LightHalfCorrectButtonColor == buttonColor || DarkHalfCorrectButtonColor == buttonColor)
    }

    @Test
    fun testGetUIButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.UI)
        assertTrue(LightUiButtonColor == buttonColor || DarkUiButtonColor == buttonColor)
    }

    @Test
    fun testGetBackgroundColor() {
        assertTrue(LightBackground == getBackgroundColor() || DarkBackGround == getBackgroundColor())
    }

    @Test
    fun testGetFontColor() {
        assertTrue(LightFontColor == getFontColor() || DarkFontColor == getFontColor())
    }

    @Test
    fun testGetAppBarColor() {
        assertTrue(LightAppBar == getAppBarColor() || DarkAppBar == getAppBarColor())
    }

    @Test
    fun testGetBackGroundColorForCard() {
        val color = Color.Red
        val newColor = color.copy(
            alpha = color.alpha,
            red = color.red * 0.75f,
            green = color.green * 0.75f,
            blue = color.blue * 0.75f
        )
        assertEquals(newColor, color.backgroundColorForCard())
    }
}