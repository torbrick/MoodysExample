package com.example.moodysexercise.data.repository

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.network.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

interface Repository {
    /**
     * @param dispatcher this allows us to inject a dispatcher for testing purposes
     */
    fun fetchDigitalPromotionCards(dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<DataResult<List<DigitalCard>>>
}
