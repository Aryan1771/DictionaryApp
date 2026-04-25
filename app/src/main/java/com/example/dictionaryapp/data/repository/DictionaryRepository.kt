package com.example.dictionaryapp.data.repository

import com.example.dictionaryapp.network.RetrofitClient

class DictionaryRepository {

    suspend fun getWordMeaning(word: String, targetLang: String): String {

        return try {
            val response = RetrofitClient.dictionaryApi.getMeaning(word)

            if (response.isSuccessful && response.body() != null) {

                val meaning = response.body()?.getOrNull(0)
                    ?.meanings?.getOrNull(0)
                    ?.definitions?.getOrNull(0)
                    ?.definition

                meaning ?: "No definition found"

            } else {
                getSlangMeaning(word, targetLang)
            }

        } catch (e: Exception) {
            getSlangMeaning(word, targetLang)
        }
    }

    private suspend fun getSlangMeaning(word: String, targetLang: String): String {
        return try {
            val slang = RetrofitClient.urbanApi.getSlang(word)

            if (slang.list.isNotEmpty()) {
                "[SLANG]\n${slang.list[0].definition}"
            } else {
                translateWord(word, targetLang)
            }

        } catch (e: Exception) {
            translateWord(word, targetLang)
        }
    }

    private suspend fun translateWord(word: String, targetLang: String): String {
        return try {
            val response = RetrofitClient.translateApi.translate(
                mapOf(
                    "q" to word,
                    "source" to "auto",
                    "target" to targetLang
                )
            )
            "Translated: ${response.translatedText}"
        } catch (e: Exception) {
            "Translation failed"
        }
    }
}