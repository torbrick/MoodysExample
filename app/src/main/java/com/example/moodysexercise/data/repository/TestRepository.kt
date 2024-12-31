package com.example.moodysexercise.data.repository

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.network.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TestRepository(private val testResult: DataResult<List<DigitalCard>>) : Repository {
    override fun fetchDigitalPromotionCards(dispatcher: CoroutineDispatcher): Flow<DataResult<List<DigitalCard>>> =
        flow {
            emit(DataResult.Loading)
            emit(testResult)
        }.flowOn(dispatcher)
}
