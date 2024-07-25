import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import com.boozeblaster.composables.builder.SimpleCardBuilder
import org.junit.Rule
import org.junit.Test

class CardBuilderTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun test() {
        composableTestRule.setContent {
            val builder = SimpleCardBuilder()
            builder.backgroundColor = Color.Blue
            builder.content = { Text(text = "hi") }
            val t = System.currentTimeMillis()
            builder.build()()
            println(System.currentTimeMillis() - t)
        }
        println("test")
    }

}