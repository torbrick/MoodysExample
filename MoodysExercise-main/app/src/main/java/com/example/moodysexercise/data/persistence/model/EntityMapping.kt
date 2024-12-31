package com.example.moodysexercise.data.persistence.model

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.domain.model.FontProperties
import com.example.moodysexercise.data.domain.model.ImageDetails
import com.example.moodysexercise.data.domain.model.TextAttributes

fun DigitalCard.toEntity(): DigitalCardEntity {
    return when (this) {
        is DigitalCard.TextCard -> DigitalCardEntity(
            id = id,
            type = "text",
            textAttributes = textAttributes.toEntity(),
        )
        is DigitalCard.ImageTitleDescriptionCard -> DigitalCardEntity(
            id = id,
            type = "image_title_description",
            textAttributes = null,
            title = title?.toEntity(),
            description = description?.toEntity(),
            imageDetails = imageDetails.toEntity()
        )
        is DigitalCard.TitleDescriptionCard -> DigitalCardEntity(
            id = id,
            type = "title_description",
            textAttributes = null,
            title = title?.toEntity(),
            description = description?.toEntity(),
            imageDetails = null
        )
    }
}

fun TextAttributes.toEntity() : TextAttributesEntity {
    return TextAttributesEntity(
        textValue = this.textValue,
        textColor = this.textColor,
        fontProperties = this.fontProperties?.toEntity()
    )
}

fun FontProperties.toEntity(): FontPropertiesEntity {
    return FontPropertiesEntity(
        size = this.size,
        family = this.family,
        style = this.style
    )
}

fun ImageDetails.toEntity(): ImageDetailsEntity {
    return ImageDetailsEntity(
        url = this.url,
        altText = this.altText,
        width = this.width,
        height = this.height
    )
}
