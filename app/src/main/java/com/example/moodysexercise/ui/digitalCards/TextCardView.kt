package com.example.moodysexercise.ui.digitalCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.domain.model.FontProperties
import com.example.moodysexercise.data.domain.model.TextAttributes

@Composable
fun TextCardView(
    card: DigitalCard.TextCard,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {

        card.textAttributes.apply {
            TextContents(
                textValue = textValue,
                textColor = textColor,
                fontSize = fontProperties?.size ?: 18,
                paddingBottom = 4.dp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextCardViewPreview() {
    TextCardView(card = previewTextCardView, modifier = Modifier.padding(16.dp))
}

val previewTextCardView = DigitalCard.TextCard(
    textAttributes = TextAttributes(
        textValue = "Sample TextCard Title",
        textColor = "#FF5733",
        fontProperties = FontProperties(size = 20)
    )
)
