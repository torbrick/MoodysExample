package com.example.moodysexercise.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moodysexercise.data.persistence.dao.DigitalCardDao
import com.example.moodysexercise.data.persistence.model.DigitalCardEntity

// TODO: This feature is incomplete. Still needs testing and refinement of the logic.
@Database(entities = [DigitalCardEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun digitalCardDao(): DigitalCardDao

    // TODO: need to add migration strategy
    companion object {
        // Singleton instance of the database
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "digital_card_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

