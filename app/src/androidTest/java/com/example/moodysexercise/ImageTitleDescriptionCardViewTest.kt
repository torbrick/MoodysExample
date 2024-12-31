package com.example.moodysexercise

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moodysexercise.ui.digitalCards.ImageTitleDescriptionCardView
import com.example.moodysexercise.ui.digitalCards.getTestImageTitleDescriptionCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// TODO: Ran out of time to implement these tests properly, with more time also would have included tests for other composables

@RunWith(AndroidJUnit4::class)
class ImageTitleDescriptionCardViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun imageLoadsCorrectly() {
        val validCardData = getTestImageTitleDescriptionCard(context)
        composeTestRule.setContent {
            ImageTitleDescriptionCardView(card = validCardData)
        }

        composeTestRule.onNodeWithTag("CardImage").assertIsDisplayed()

    }

    @Test
    fun errorImageDisplayed() {
        val cardWithInvalidImageUrl = getTestImageTitleDescriptionCard(null)
        composeTestRule.setContent {
            ImageTitleDescriptionCardView(card = cardWithInvalidImageUrl)
        }

    }

    //More Time: Complete Test Image Loading
    @Test
    fun loadingImageDisplayed() {
        val validCardData = getTestImageTitleDescriptionCard(context)

        composeTestRule.setContent {
            ImageTitleDescriptionCardView(card = validCardData)
        }
    }

    @Test
    fun textContentIsDisplayedCorrectly() {
        val validCardData = getTestImageTitleDescriptionCard(context)

        composeTestRule.setContent {
            ImageTitleDescriptionCardView(card = validCardData)
        }

        composeTestRule.onNodeWithText(validCardData.title?.textValue ?: "")
            .assertIsDisplayed()
    }


    @Test
    fun backgroundNotVisible() {
        val validCardData = getTestImageTitleDescriptionCard(context)

        composeTestRule.setContent {
            ImageTitleDescriptionCardView(card = validCardData)
        }

        composeTestRule.onNodeWithTag("CardImage").assertIsDisplayed()
        Thread.sleep(1000)
        composeTestRule.onNodeWithTag("CardBackground").assertIsNotDisplayed()

    }
}
   

