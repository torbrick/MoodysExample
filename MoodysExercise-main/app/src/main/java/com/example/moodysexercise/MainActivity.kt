package com.example.moodysexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.moodysexercise.data.repository.ProductionRepository
import com.example.moodysexercise.ui.features.promotions.PromotionsScreen
import com.example.moodysexercise.ui.features.promotions.PromotionsViewModel
import com.example.moodysexercise.ui.theme.MoodysExerciseTheme
import com.example.moodysexercise.ui.theme.PaleGrey
import com.example.moodysexercise.ui.theme.PaleSkyBlue

// TODO: This app is implemented directly in the main activity, with more time would have introduced navigation
// TODO: There are a lot of unused declarations that are examples feature extension
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodysExerciseTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    PromotionsScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        PaleSkyBlue,
                                        PaleGrey
                                    )
                                )
                            ),
                        promotionsViewModel = PromotionsViewModel(ProductionRepository.getInstance(context = this))
                    )
                }
            }
        }
    }
}
