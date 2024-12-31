package com.example.moodysexercise.ui.digitalCards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.ui.theme.OffWhite

@Composable
fun DigitalCardView(card: DigitalCard, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = OffWhite,
                shape = RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
    ) {
        when (card) {
            is DigitalCard.TextCard -> TextCardView(card, modifier)
            is DigitalCard.TitleDescriptionCard -> TitleDescriptionCardView(card, modifier)
            is DigitalCard.ImageTitleDescriptionCard -> ImageTitleDescriptionCardView(
                card,
                modifier
            )
        }
    }
}

@Composable
fun TextContents(
    textValue: String,
    textColor: String?,
    fontSize: Int,
    paddingBottom: Dp = 0.dp,
    defaultTextColor: Color = Color.White,
    modifier: Modifier = Modifier,
) {
    val color = textColor?.let { Color(android.graphics.Color.parseColor(it)) } ?: defaultTextColor
    val size = fontSize.sp

    BasicText(
        text = textValue,
        style = TextStyle(fontSize = size, color = color),
        modifier = modifier
            .padding(bottom = paddingBottom)
            .semantics {
                contentDescription = textValue //for accessibility and testing
            },
    )
}

