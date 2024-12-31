package com.example.moodysexercise.ui.features.promotions

import androidx.lifecycle.viewModelScope
import com.example.moodysexercise.data.network.DataResult
import com.example.moodysexercise.data.repository.Repository
import com.example.moodysexercise.ui.digitalCards.DigitalCardsUiState
import com.example.moodysexercise.ui.digitalCards.DigitalCardsViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

//in a larger project, would use dedicated dependency injection library like hilt
class PromotionsViewModel(private val productionRepository: Repository) : DigitalCardsViewModel() {
    private val _uiState = MutableStateFlow<DigitalCardsUiState>(DigitalCardsUiState.Loading)

    override val uiState: StateFlow<DigitalCardsUiState> = _uiState

    init {
        getDigitalPromotionCards()
            .onEach { uiState ->
                _uiState.value = uiState
            }
            .launchIn(viewModelScope)
    }

    private fun getDigitalPromotionCards(): Flow<DigitalCardsUiState> {
        return productionRepository.fetchDigitalPromotionCards()
            .map { networkResult ->
                when (networkResult) {
                    DataResult.Empty -> DigitalCardsUiState.Success(emptyList())
                    DataResult.Loading -> DigitalCardsUiState.Loading
                    is DataResult.Error -> DigitalCardsUiState.Error(networkResult.message)
                    is DataResult.Success -> DigitalCardsUiState.Success(networkResult.data)
                }
            }
            .onEach { uiState ->
                _uiState.value = uiState
            }
    }
}
