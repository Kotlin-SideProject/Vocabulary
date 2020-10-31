package com.litto.vocabulary.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("select * from WORDS")
    fun getAll() : List<Word>

    @Query("select * from WORDS where name = :name ")
    fun getWord(name: String) : LiveData<Word>

    @Update
    fun update(word : Word) : Int
}