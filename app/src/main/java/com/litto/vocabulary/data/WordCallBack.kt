package com.litto.vocabulary.data

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class WordCallBack : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

    }
}