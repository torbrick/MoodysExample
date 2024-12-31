package com.example.moodysexercise.data.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodysexercise.data.persistence.model.DigitalCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DigitalCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: DigitalCardEntity)

    @Query("SELECT * FROM digital_cards")
    fun getAllCards(): Flow<List<DigitalCardEntity>>
}
