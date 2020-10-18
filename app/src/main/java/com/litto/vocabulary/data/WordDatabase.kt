package com.litto.vocabulary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
    companion object {
        var instance: WordDatabase? = null
        fun getIntance(context: Context) : WordDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    WordDatabase::class.java, "word.db")
                    .build()
            }
            return instance
        }
    }

}