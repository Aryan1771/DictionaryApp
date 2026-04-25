package com.example.dictionaryapp.utils

object LanguageDetector {

    fun isEnglish(text: String): Boolean {
        return text.matches(Regex("^[a-zA-Z]+$"))
    }
}