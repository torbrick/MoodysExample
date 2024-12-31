package com.example.moodysexercise.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class CardPropertiesDto {
    @Serializable
    data class ImagePropertiesDto(
        val url: String? = null,
        val size: ImageSize? = null,
    ) {
        @Serializable
        data class ImageSize(
            val width: Int? = null,
            val height: Int? = null,
        )
    }

    @Serializable
    data class TitleOrDescriptionDto(
        val value: String? = null,
        val attributes: TextAttributesDto? = null,
    )

    @Serializable
    data class TextAttributesDto(
        @SerialName("text_color") val textColor: String? = null,
        val font: Font? = null,
    ) {
        @Serializable
        data class Font(val size: Int? = null)
    }
}
