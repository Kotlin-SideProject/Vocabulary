package com.litto.vocabulary.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.data.WordDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordListViewModel(application: Application) : AndroidViewModel(application) {
    private val words = MutableLiveData<List<Word>>()
    fun getWords() : MutableLiveData<List<Word>> {
        CoroutineScope(Dispatchers.IO).launch {
            val words =
                WordDatabase.getIntance(getApplication())?.wordDao()?.getAll()
        }
        return words
    }
}