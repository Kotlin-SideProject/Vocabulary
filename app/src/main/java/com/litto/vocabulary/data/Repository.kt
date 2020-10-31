package com.litto.vocabulary.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQueryBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository private constructor(private val dao: WordDao) {
    fun getAll(sortBy: String) : LiveData<List<Word>> {
        if (sortBy != "default") {
            val builder =
                SupportSQLiteQueryBuilder.builder(WordNames.TABLE_NAME)
                    .orderBy(sortBy)
            val query: SimpleSQLiteQuery =
                SimpleSQLiteQuery(builder.create().sql)
            return dao.getAll(query)
        } else {
            return dao.getAll()
        }
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