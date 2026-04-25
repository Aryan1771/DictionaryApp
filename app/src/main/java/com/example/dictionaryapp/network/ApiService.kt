package com.example.dictionaryapp.network

import com.example.dictionaryapp.data.model.DictionaryResponse
import com.example.dictionaryapp.data.model.UrbanResponse
import com.example.dictionaryapp.data.model.TranslationResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("api/v2/entries/en/{word}")
    suspend fun getMeaning(@Path("word") word: String): Response<List<DictionaryResponse>>

    @GET("v0/define")
    suspend fun getSlang(@Query("term") word: String): UrbanResponse

    @POST("translate")
    suspend fun translate(@Body body: Map<String, String>): TranslationResponse
}
