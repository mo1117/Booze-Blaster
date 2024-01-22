package com.boozeblaster.minigames.individual

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.individual.HigherLower
import com.boozeblaster.models.Player
import com.boozeblaster.models.SearchedTerm
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale

class HigherLowerTest {

    @get:Rule
    val testComposableRule = createComposeRule()

    @Test
    fun testHigherLowerDisplay() {
        val firstTerm = SearchedTerm(term = "First", amount = 100)
        val secondTerm = SearchedTerm(term = "Second", amount = 200)

        val higherLower = HigherLower(first = firstTerm, second = secondTerm)

        testComposableRule.setContent {
            higherLower.DisplayContent(player = Player(name = "TestPlayer"), callback = { }, versusPlayer = null)
        }

        testComposableRule.onNodeWithText(firstTerm.getTerm()).assertTextEquals(firstTerm.getTerm())

        testComposableRule.onNodeWithText(NumberFormat.getNumberInstance(Locale.US).format(firstTerm.getAmount()))
            .assertTextEquals(NumberFormat.getNumberInstance(Locale.US).format(firstTerm.getAmount()))

        testComposableRule.onNodeWithText(secondTerm.getTerm()).assertTextEquals(secondTerm.getTerm())

        testComposableRule.onNodeWithText("Higher").assertIsDisplayed()
            .assertHasClickAction()

        testComposableRule.onNodeWithText("Lower").assertIsDisplayed()
            .assertHasClickAction()
    }
}
