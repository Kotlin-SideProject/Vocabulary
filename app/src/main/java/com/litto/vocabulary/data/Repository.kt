package com.litto.vocabulary.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(val context: Context) {
    val dao = WordDatabase.getIntance(context)?.wordDao()

    suspend fun getAll() : List<Word> {
       return dao?.getAll()!!
    }
    suspend fun getWordByName(name: String) : Word? {
        return dao?.getWord(name)
    }
}