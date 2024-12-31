package com.example.moodysexercise.data.network.retrofit

import com.example.moodysexercise.data.network.model.ProductPageResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/"

    interface TmobileApiService {
        @GET("test/home")
        suspend fun getPage(): Response<ProductPageResponse>
    }



    private val cardContentJson = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)  // Set the base URL
        .addConverterFactory(
            cardContentJson.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()))
        .build()

    val tmobileApiService: TmobileApiService = retrofit.create(TmobileApiService::class.java)

}
