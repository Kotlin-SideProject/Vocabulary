package com.litto.vocabulary.ui.main

import androidx.lifecycle.*
import com.litto.vocabulary.data.Repository
import com.litto.vocabulary.data.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordListViewModel(
    val repository: Repository,
    var sortBy: String
) : ViewModel() {
    private val words = MutableLiveData<List<Word>>()
    fun getWords() : LiveData<List<Word>> {
        return repository.getAll(sortBy)
    }

    fun updateSort(string: String) {
        sortBy = string
        //TODO: livedata update problem
    }
}