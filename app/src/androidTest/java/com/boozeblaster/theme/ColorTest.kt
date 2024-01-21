package com.boozeblaster.ui.theme

import androidx.compose.ui.graphics.Color
import com.boozeblaster.enums.ButtonType
import org.junit.Test
import org.junit.Assert.assertEquals

class ColorTest {

    @Test
    fun testGetCorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.CORRECT)
        assertEquals(LightCorrectButtonColor, buttonColor)
    }

    @Test
    fun testGetIncorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.INCORRECT)
        assertEquals(LightIncorrectButtonColor, buttonColor)
    }

    @Test
    fun testGetHalfCorrectButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.HALF_CORRECT)
        assertEquals(LightHalfCorrectButtonColor, buttonColor)
    }

    @Test
    fun testGetUIButtonColor() {
        val buttonColor = getButtonColor(buttonType = ButtonType.UI)
        assertEquals(LightUiButtonColor, buttonColor)
    }

    @Test
    fun testGetBackgroundColor() {
        assertEquals(LightBackground, getBackgroundColor())
    }

    @Test
    fun testGetFontColor() {
        assertEquals(LightFontColor, getFontColor())
    }

    @Test
    fun testGetAppBarColor() {
        assertEquals(LightAppBar, getAppBarColor())
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