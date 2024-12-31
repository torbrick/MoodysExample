package com.example.moodysexercise.ui.digitalCards

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

//allows for the extension of digital cards use in the future
abstract class DigitalCardsViewModel: ViewModel() {
    abstract val uiState: StateFlow<DigitalCardsUiState>
}
