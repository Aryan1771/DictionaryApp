package com.example.dictionaryapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.dictionaryapp.data.repository.DictionaryRepository
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DictionaryRepository()

    val result = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun search(word: String, targetLang: String) {

        if (word.isBlank()) {
            result.value = "Enter a word"
            return
        }

        viewModelScope.launch {
            isLoading.postValue(true)

            val response = repository.getWordMeaning(word, targetLang)

            result.postValue(response)

            isLoading.postValue(false)
        }
    }
}