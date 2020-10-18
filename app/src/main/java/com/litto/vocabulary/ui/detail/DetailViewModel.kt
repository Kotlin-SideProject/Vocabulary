package com.litto.vocabulary.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.litto.vocabulary.data.Repository
import com.litto.vocabulary.data.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(val repository: Repository) : ViewModel() {
    val word = MutableLiveData<Word>()
    fun setName(name : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val w = repository.getWordByName(name)
            word.postValue(w)
        }
    }
}