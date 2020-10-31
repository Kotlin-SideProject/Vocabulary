package com.litto.vocabulary.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.litto.vocabulary.data.Repository
import com.litto.vocabulary.data.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
        private val repository: Repository,
        private val name: String
) : ViewModel() {

    val word = repository.getWordByName(name)
}