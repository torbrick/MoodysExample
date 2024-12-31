package com.example.moodysexercise.ui.digitalCards

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.moodysexercise.R
import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.domain.model.FontProperties
import com.example.moodysexercise.data.domain.model.ImageDetails
import com.example.moodysexercise.data.domain.model.TextAttributes

@Composable
fun ImageTitleDescriptionCardView(
    card: DigitalCard.ImageTitleDescriptionCard,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .aspectRatio(card.imageDetails.aspectRatio)
        .background(Color.Gray)
        .testTag("CardBackground") //you should never see the background, so this will indicate a bug
    ) {
        card.imageDetails.apply {
            AsyncImage(
                model = url,
                contentDescription = altText,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(aspectRatio)
                    .testTag("CardImage"),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.placeholder_image_24),
                error = painterResource(R.drawable.broken_image_24)
            )
        }

        //text container
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {

            card.title?.let { title ->
                TextContents(
                    textValue = title.textValue,
                    textColor = title.textColor,
                    fontSize = title.fontProperties?.size ?: 18,
                    paddingBottom = 4.dp
                )
            }

            card.description?.let { description ->
                TextContents(
                    textValue = description.textValue,
                    textColor = description.textColor,
                    fontSize = description.fontProperties?.size ?: 14,
                    paddingBottom = 4.dp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageTitleDescriptionCardViewPreview() {
    val imageTitleDescriptionCard = getTestImageTitleDescriptionCard(LocalContext.current)

    ImageTitleDescriptionCardView(
        card = imageTitleDescriptionCard
    )
}

fun getResourceUri(
    context: Context,
    @DrawableRes resourceId: Int = R.drawable.testimagemoodys
): String {
    // With more time this would be tested for validity
    return "android.resource://${context.packageName}/drawable/${resourceId}"
}

fun getTestImageTitleDescriptionCard(localContext : Context?): DigitalCard.ImageTitleDescriptionCard {
    return  DigitalCard.ImageTitleDescriptionCard(
        imageDetails = ImageDetails(
            url = if (localContext != null) getResourceUri(localContext) else "BROKEN_URL",
            altText = "Example image"
        ),
        title = TextAttributes(
            textValue = "25% off merch at MLBshop.com",
            textColor = "#FFFFFF",
            fontProperties = FontProperties(size = 36)
        ),
        description = TextAttributes(
            textValue = "Tap to see offer dates and restrictions.",
            textColor = "#FFFFFF",
            fontProperties = FontProperties(size = 18)
        )
    )
}
