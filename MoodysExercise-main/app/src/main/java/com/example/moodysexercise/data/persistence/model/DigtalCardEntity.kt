package com.example.moodysexercise.data.persistence.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "digital_cards")
data class DigitalCardEntity(
    @PrimaryKey val id: String,
    val type: String, // Type discriminator
    @Embedded(prefix = "text_") val textAttributes: TextAttributesEntity? = null,
    @Embedded(prefix = "title_") val title: TextAttributesEntity? = null,
    @Embedded(prefix = "description_") val description: TextAttributesEntity? = null,
    @Embedded(prefix = "image_") val imageDetails: ImageDetailsEntity? = null
)

data class TextAttributesEntity(
    val textValue: String,
    val textColor: String?,
    @Embedded(prefix = "font_") val fontProperties: FontPropertiesEntity?
)

data class FontPropertiesEntity(
    val size: Int?,
    val family: String?,
    val style: String?
)

data class ImageDetailsEntity(
    val url: String?, // TODO: This needs an entire caching strategy of its own, just saving the URL doesn't help
    val altText: String,
    val width: Int?,
    val height: Int?
)

