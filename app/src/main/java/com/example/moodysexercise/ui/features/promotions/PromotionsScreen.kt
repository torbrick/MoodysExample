package com.example.moodysexercise.ui.features.promotions

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moodysexercise.data.domain.model.DigitalCard
import com.example.moodysexercise.data.network.DataResult
import com.example.moodysexercise.data.repository.TestRepository
import com.example.moodysexercise.ui.digitalCards.DigitalCardView
import com.example.moodysexercise.ui.digitalCards.DigitalCardsUiState
import com.example.moodysexercise.ui.digitalCards.getTestImageTitleDescriptionCard
import com.example.moodysexercise.ui.digitalCards.previewTextCardView
import com.example.moodysexercise.ui.digitalCards.previewTitleDescriptionCard

// TODO: this screen has no way to "refresh", good functionality to add in future
@Composable
fun PromotionsScreen(
    modifier: Modifier = Modifier,
    promotionsViewModel: PromotionsViewModel
){
    val uiState by promotionsViewModel.uiState.collectAsState()

    val cards = when (uiState) {
        is DigitalCardsUiState.Error -> emptyList() // TODO: error contingency
        is DigitalCardsUiState.Loading -> emptyList() // TODO: loading contingency
        is DigitalCardsUiState.Success -> (uiState as DigitalCardsUiState.Success).digitalCards
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 1.dp,
                bottom = 1.dp
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(
                items = cards,
                key = { card -> card.id }) { card ->
                DigitalCardView(card)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionsScreenPreview(){
    val localContext: Context = LocalContext.current

    val digitalCardList: List<DigitalCard> = listOf(
        previewTextCardView,
        previewTitleDescriptionCard,
        getTestImageTitleDescriptionCard(localContext)
    )

    val testViewModel = PromotionsViewModel(
        TestRepository(DataResult.Success(digitalCardList))
    )

    PromotionsScreen(
        promotionsViewModel = testViewModel
    )
}
