package com.example.moodysexercise.data.repository

import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.network.DataResult
import com.example.moodysexercise.data.network.retrofit.RetrofitClient
import com.example.moodysexercise.data.persistence.AppDatabase
import com.example.moodysexercise.data.persistence.DigitalCardStorage
import com.example.moodysexercise.data.persistence.model.toDomain
import com.example.moodysexercise.data.persistence.model.toEntity
import com.example.moodysexercise.tools.ErrorHandler.Companion.handleError
import com.example.moodysexercise.tools.LogHandling
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

//This manual singleton (e.g. not using kotlin's "object") allows for constructor injection, which
//we are using for testing, and allows this to have dependencies injected in the future.
class ProductionRepository private constructor(context: android.content.Context) : Repository {

    private val dataBase = AppDatabase.getDatabase(context)
    private val localDigitalCardStorage = DigitalCardStorage(dataBase.digitalCardDao())
    private val tmobileApiService: RetrofitClient.TmobileApiService = RetrofitClient.tmobileApiService

    companion object {
        @Volatile
        private var instance: ProductionRepository? = null

        fun getInstance(context: android.content.Context): ProductionRepository {
            return instance ?: synchronized(this) {
                instance ?: ProductionRepository(context).also { instance = it }
            }
        }
    }

    override fun fetchDigitalPromotionCards(dispatcher: CoroutineDispatcher): Flow<DataResult<List<DigitalCard>>> =
        flow {
            emit(DataResult.Loading)
            val networkResponse = if (networkAvailable()) {
                getDigitalPromotionCardsFromNetwork()
            } else {
                DataResult.Error("No network available")
            }
            when (networkResponse) {
                is DataResult.Success -> {
                    storeDigitalPromotionCardsInLocalCache(networkResponse.data)
                }
                is DataResult.Error -> handleError(networkResponse.message)
                DataResult.Loading -> handleError("Loading shouldn't be a possible result")
                DataResult.Empty -> LogHandling.warning("Empty response from network")
            }

            if(networkResponse !is DataResult.Success){
                val localResponse = getDigitalPromotionCardsFromLocalCache()
                emit(
                    if(localResponse.isNotEmpty()){
                        DataResult.Success(localResponse)
                    } else {
                        DataResult.Empty
                    }
                )
            } else {
                emit(networkResponse)
            }
        }.flowOn(dispatcher)

    private suspend fun getDigitalPromotionCardsFromNetwork(): DataResult<List<DigitalCard>> {
        val errorTitle = "Page Response Network Error: "

        return try {
            val pageResponse = tmobileApiService.getPage()

            if (pageResponse.isSuccessful) {
                val cards = pageResponse.body()?.page?.cards
                if (cards?.isNotEmpty() == true) {
                    val domainDigitalCardsList = mutableListOf<DigitalCard>()

                    cards.forEach { cardWrapper ->
                        cardWrapper.card.let {
                            domainDigitalCardsList.add(it.toDomainModel())
                        }
                    }

                    DataResult.Success(domainDigitalCardsList)
                } else {
                    DataResult.Empty
                }
            } else {
                val errorMessage = "Error: ${pageResponse.code()}"
                DataResult.Error(errorTitle + errorMessage)
            }
        } catch (e: Exception) {
            val errorMessage = e.message ?: "Unknown error"
            DataResult.Error(errorTitle + errorMessage)
        }
    }

    private suspend fun getDigitalPromotionCardsFromLocalCache(): List<DigitalCard> {
        return localDigitalCardStorage.getAllCards()
            .first()
            .map { digitalCardEntity -> digitalCardEntity.toDomain() }
    }

    private suspend fun storeDigitalPromotionCardsInLocalCache(cards: List<DigitalCard>) {
        cards.forEach{card ->
            localDigitalCardStorage.insertCard(card.toEntity())
        }
    }

    private fun networkAvailable(): Boolean {
        // TODO: implement network availability check
        return true
    }
}
