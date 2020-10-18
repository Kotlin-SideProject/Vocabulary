package com.litto.vocabulary.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(val context: Context) {
    suspend fun getAll() : List<Word> {
       return WordDatabase.getIntance(context)?.wordDao()?.getAll()!!
    }
}