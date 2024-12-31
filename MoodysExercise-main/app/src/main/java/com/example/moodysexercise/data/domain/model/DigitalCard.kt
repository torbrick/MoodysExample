package com.example.moodysexercise.data.domain.model

import java.util.UUID

sealed class DigitalCard {
    open val id: String = UUID.randomUUID().toString()

    data class TextCard(
        override val id: String = UUID.randomUUID().toString(),
        val textAttributes: TextAttributes
    ) : DigitalCard()

    data class TitleDescriptionCard(
        override val id: String = UUID.randomUUID().toString(),
        val title: TextAttributes? = null,
        val description: TextAttributes? = null
    ) : DigitalCard()

    data class ImageTitleDescriptionCard(
        override val id: String = UUID.randomUUID().toString(),
        val imageDetails: ImageDetails = ImageDetails(),
        val title: TextAttributes? = null,
        val description: TextAttributes? = null
    ) : DigitalCard()
}

data class TextAttributes(
    val textValue: String,
    val textColor: String? = null,
    val fontProperties: FontProperties? = null
)

data class FontProperties(
    val size: Int? = null,
    val family: String? = null, // example of possible API extension
    val style: String? = null // example of possible API extension
)

data class ImageDetails(
    val url: String? = null,
    val altText: String = "",
    val width: Int? = null,
    val height: Int? = null
){
    val aspectRatio: Float by lazy {
        if (width != null && height != null && height != 0) {
            width.toFloat() / height.toFloat()
        } else {
            1f
        }
    }
}
