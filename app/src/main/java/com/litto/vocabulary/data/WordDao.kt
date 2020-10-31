package com.litto.vocabulary.data

import android.database.sqlite.SQLiteQuery
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("select * from WORDS")
    fun getAll() : LiveData<List<Word>>

    @RawQuery(observedEntities = [Word::class])
    fun getAll(query: SimpleSQLiteQuery) : LiveData<List<Word>>

    @Query("select * from WORDS where name = :name ")
    fun getWord(name: String) : LiveData<Word>

    @Update
    fun update(word : Word) : Int
}