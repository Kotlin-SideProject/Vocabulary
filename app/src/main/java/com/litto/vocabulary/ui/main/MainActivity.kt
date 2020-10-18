package com.litto.vocabulary.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.data.WordDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: WordAdapter
    private lateinit var viewModel: WordListViewModel
    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = WordAdapter()
        recycler_view.adapter = adapter

        viewModel = ViewModelProvider(this,
            WordListViewModelFactory(applicationContext))
                .get(WordListViewModel::class.java)
        viewModel.getWords().observe(this, Observer {words ->
            //
            Log.d(TAG, "words count: ${words.size}")
            adapter.submitList(words)
            recycler_view.invalidate()
        })

        //read Json File
        val inputStream = resources.openRawResource(R.raw.vocabulary)
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
            list.add(word)


            // insert data sqlite
            /*Thread {
                database.wordDao().insert(word)
                database.wordDao().getAll()
            }.start()*/

        }

    }
}