package com.example.moodysexercise.data.persistence.model

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.domain.model.FontProperties
import com.example.moodysexercise.data.domain.model.ImageDetails
import com.example.moodysexercise.data.domain.model.TextAttributes

fun DigitalCardEntity.toDomain(): DigitalCard {
    return when (this.type) {
        "text" -> DigitalCard.TextCard(
            id = id,
            textAttributes = textAttributes!!.toDomain()
        )
        "image_title_description" -> DigitalCard.ImageTitleDescriptionCard(
            id = id,
            title = title?.toDomain(),
            description = description?.toDomain(),
            imageDetails = imageDetails?.toDomain() ?: ImageDetails()
        )
        "title_description" -> DigitalCard.TitleDescriptionCard(
            id = id,
            title = title?.toDomain(),
            description = description?.toDomain()
        )
        else -> throw IllegalArgumentException("Unknown type: $type")
    }
}

fun TextAttributesEntity.toDomain(): TextAttributes {
    return TextAttributes(
        textValue = this.textValue,
        textColor = this.textColor,
        fontProperties = this.fontProperties?.toDomain()
    )
}

fun FontPropertiesEntity.toDomain(): FontProperties {
    return FontProperties(
        size = this.size,
        family = this.family,
        style = this.style
    )
}

fun ImageDetailsEntity.toDomain(): ImageDetails {
    return ImageDetails(
        url = this.url,
        altText = this.altText,
        width = this.width,
        height = this.height
    )
}
