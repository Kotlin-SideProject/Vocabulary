package com.litto.vocabulary.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.data.WordDatabase
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //read Json File
        val inputStream = resources.openRawResource(R.raw.vocabulary)
        val data = inputStream.bufferedReader().readText()
        val obj = JSONObject(data)
        val list = mutableListOf<Word>()
        val words = obj.getJSONArray("words")
        //
        val database = Room.databaseBuilder(this,
                    WordDatabase::class.java, "word.db")
                    .build()
        for (i in 0 until words.length()) {
            val word = words.getJSONObject(i).run {
                val name = getString("name")
                val means = getString("means")
                val difficulty = getInt("difficulty")
                val star = getInt("star")
                Word( name, means, difficulty, star)
            }
            list.add(word)
            // insert data sqlite
            Thread {
                database.wordDao().insert(word)
                database.wordDao().getAll()
            }.start()

        }

    }
}