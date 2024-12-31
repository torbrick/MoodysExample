package com.example.moodysexercise.data.network.model

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.domain.model.FontProperties
import com.example.moodysexercise.data.domain.model.ImageDetails
import com.example.moodysexercise.data.domain.model.TextAttributes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//I prefer to have the Domain Transfer Objects(DTO) emulate the API as close as possible
//Since I don't have actually documentation, I defaulted the known objects to null values,
//if there were documentation I would use documented default values in the DTO.
@Serializable
sealed class CardContentDto {
    abstract fun toDomainModel(): DigitalCard

    @Serializable
    data class TextCardDto(
        val value: String? = null,
        val attributes: CardPropertiesDto.TextAttributesDto? = null,
    ) : CardContentDto() {
        //dictating the defaults in the conversion to the domain model implies the choice was made
        //internally and not prescribed by contract (i.e. the documentation)
        override fun toDomainModel(): DigitalCard.TextCard {
            return DigitalCard.TextCard(
                textAttributes = TextAttributes(
                    textValue = value ?: "",
                    textColor = attributes?.textColor,
                    fontProperties = FontProperties(attributes?.font?.size)
                )
            )
        }
    }

    @Serializable
    data class TitleDescriptionCardDto(
        val title: CardPropertiesDto.TitleOrDescriptionDto? = null,
        val description: CardPropertiesDto.TitleOrDescriptionDto? = null,
    ) : CardContentDto() {
        override fun toDomainModel(): DigitalCard.TitleDescriptionCard {
            return DigitalCard.TitleDescriptionCard(
                title = TextAttributes(
                    textValue = title?.value ?: "",
                    textColor = title?.attributes?.textColor,
                    fontProperties = FontProperties(title?.attributes?.font?.size)
                ), description = TextAttributes(
                    textValue = description?.value ?: "",
                    textColor = description?.attributes?.textColor,
                    fontProperties = FontProperties(description?.attributes?.font?.size)
                )
            )
        }
    }

    @Serializable
    data class ImageTitleDescriptionCardDto(
        @SerialName("image") val imagePropertiesDto: CardPropertiesDto.ImagePropertiesDto? = null,
        val title: CardPropertiesDto.TitleOrDescriptionDto? = null,
        val description: CardPropertiesDto.TitleOrDescriptionDto? = null,
    ) : CardContentDto() {
        override fun toDomainModel(): DigitalCard {
            return DigitalCard.ImageTitleDescriptionCard(
                imageDetails = ImageDetails(
                    url = imagePropertiesDto?.url,
                    width = imagePropertiesDto?.size?.width,
                    height = imagePropertiesDto?.size?.height
                ), title = TextAttributes(
                    textValue = title?.value ?: "",
                    textColor = title?.attributes?.textColor,
                    fontProperties = FontProperties(title?.attributes?.font?.size)
                ), description = TextAttributes(
                    textValue = description?.value ?: "",
                    textColor = description?.attributes?.textColor,
                    fontProperties = FontProperties(description?.attributes?.font?.size)
                )
            )
        }
    }
}
