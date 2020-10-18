package com.litto.vocabulary.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litto.vocabulary.data.Repository
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.data.WordDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordListViewModel(val repository: Repository) : ViewModel() {
    private val words = MutableLiveData<List<Word>>()
    fun getWords() : MutableLiveData<List<Word>> {
        viewModelScope.launch {
            words.postValue(repository.getAll())
        }
        return words
    }
}