package com.example.moodysexercise.data.network.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

//root of the json structure from the api
@Serializable
data class ProductPageResponse(
    val page: Page
)

@Serializable
data class Page(
    val cards: List<CardWrapper>
)

//this wrapper class is necessary since the discriminator(i.e. object type indicator) is NOT
//nested inside the object itself.
@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("card_type")
sealed class CardWrapper {
    abstract val type: String
    abstract val card: CardContentDto

    @Serializable
    @SerialName("text")
    data class TextCardWrapper(
        @SerialName("card_type") override val type: String,
        override val card: CardContentDto.TextCardDto
    ) : CardWrapper()

    @Serializable
    @SerialName("title_description")
    data class TitleDescriptionCardWrapper(
        @SerialName("card_type") override val type: String,
        override val card: CardContentDto.TitleDescriptionCardDto
    ) : CardWrapper()

    @Serializable
    @SerialName("image_title_description")
    data class ImageTitleDescriptionCardWrapper(
        @SerialName("card_type") override val type: String,
        override val card: CardContentDto.ImageTitleDescriptionCardDto
    ) : CardWrapper()
}
