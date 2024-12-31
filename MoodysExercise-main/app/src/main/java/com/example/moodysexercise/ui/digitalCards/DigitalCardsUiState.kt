package com.example.moodysexercise.ui.digitalCards

import com.example.moodysexercise.data.domain.model.DigitalCard

sealed interface DigitalCardsUiState {
    data class Success(val digitalCards: List<DigitalCard>) : DigitalCardsUiState
    data class Error(val message: String) : DigitalCardsUiState
    data object Loading : DigitalCardsUiState
}
