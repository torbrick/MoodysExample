package com.example.moodysexercise.data.persistence

import com.example.moodysexercise.data.persistence.dao.DigitalCardDao
import com.example.moodysexercise.data.persistence.model.DigitalCardEntity
import kotlinx.coroutines.flow.Flow

class DigitalCardStorage (private val digitalCardDao: DigitalCardDao) : LocalDataStorage {

    override suspend fun insertCard(card: DigitalCardEntity) {
        digitalCardDao.insertCard(card)
    }

    override fun getAllCards(): Flow<List<DigitalCardEntity>> {
        return digitalCardDao.getAllCards()
    }
}
