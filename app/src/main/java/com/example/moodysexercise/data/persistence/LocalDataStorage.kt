package com.example.moodysexercise.data.persistence

import com.example.moodysexercise.data.persistence.model.DigitalCardEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataStorage {
    suspend fun insertCard(card: DigitalCardEntity)
    fun getAllCards(): Flow<List<DigitalCardEntity>>
}
