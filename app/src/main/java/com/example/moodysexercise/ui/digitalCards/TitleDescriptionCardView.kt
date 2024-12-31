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
fun TitleDescriptionCardView(
    card: DigitalCard.TitleDescriptionCard,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {

        card.title?.apply {
            TextContents(
                textValue = textValue,
                textColor = textColor,
                fontSize = fontProperties?.size ?: 18,
                paddingBottom = 4.dp,
            )
        }

        card.description?.apply {
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
fun TitleDescriptionCardViewPreview() {
    TitleDescriptionCardView(
        card = previewTitleDescriptionCard,
        modifier = Modifier.padding(16.dp)
    )
}

val previewTitleDescriptionCard = DigitalCard.TitleDescriptionCard(
    title = TextAttributes(
        textValue = "Sample TitleDescriptionCard Title",
        textColor = "#FFC1CC",
        fontProperties = FontProperties(size = 20)
    ),
    description = TextAttributes(
        textValue = "This is a sample description for the card.",
        textColor = "#4A7FA7",
        fontProperties = FontProperties(size = 16)
    )
)
