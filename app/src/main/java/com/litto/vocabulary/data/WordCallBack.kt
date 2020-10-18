package com.litto.vocabulary.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.litto.vocabulary.R
import org.json.JSONObject
import java.util.concurrent.Executors

class WordCallBack(val context: Context) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        val dao = WordDatabase.getIntance(context)?.wordDao()
        //read Json File
        val inputStream = context.resources.openRawResource(R.raw.vocabulary)
        val data = inputStream.bufferedReader().readText()
        val obj = JSONObject(data)
        val list = mutableListOf<Word>()
        val words = obj.getJSONArray("words")
        //
        for (i in 0 until words.length()) {
            val word = words.getJSONObject(i).run {
                val name = getString("name")
                val means = getString("means")
                val difficulty = getInt("difficulty")
                val star = getInt("star")
                Word( name, means, difficulty, star)
            }
            Executors.newSingleThreadExecutor().execute {
                dao?.insert(word)
            }
        }
    }
}