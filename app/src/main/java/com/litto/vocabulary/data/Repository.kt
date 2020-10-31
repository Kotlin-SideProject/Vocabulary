package com.litto.vocabulary.data

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository private constructor(private val dao: WordDao) {
    suspend fun getAll() : List<Word> {
       return dao.getAll()
    }
    fun getWordByName(name: String) : LiveData<Word> {
        return dao.getWord(name)
    }
    companion object {

        fun getInstance(context: Context) :Repository {
            val dao = WordDatabase.getIntance(context)
                    .wordDao()
            return Repository(dao)
        }
    }
}