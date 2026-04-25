package com.example.dictionaryapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val dictionaryRetrofit = Retrofit.Builder()
        .baseUrl("https://api.dictionaryapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val urbanRetrofit = Retrofit.Builder()
        .baseUrl("https://api.urbandictionary.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val translateRetrofit = Retrofit.Builder()
        .baseUrl("https://libretranslate.de/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dictionaryApi: ApiService = dictionaryRetrofit.create(ApiService::class.java)
    val urbanApi: ApiService = urbanRetrofit.create(ApiService::class.java)
    val translateApi: ApiService = translateRetrofit.create(ApiService::class.java)
}
