package com.litto.vocabulary.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.data.WordDatabase
import com.litto.vocabulary.ui.detail.DetailActivity
import com.litto.vocabulary.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : AppCompatActivity(), WordClickListener {
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
        adapter.listener = this
        recycler_view.adapter = adapter

        viewModel = ViewModelProvider(this,
            WordListViewModelFactory.createFactory(this))
                .get(WordListViewModel::class.java)
        viewModel.getWords().observe(this, Observer {words ->
            Log.d(TAG, "words count: ${words.size}")
            adapter.submitList(words)
        })
    }

    override fun wordSelected(word: Word, position: Int) {
        Intent(this, DetailActivity::class.java).apply {
//            putExtra("WORD", word)
            putExtra("WORD_NAME", word.name)
        }.also {
            startActivity(it)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                Intent(this, SettingsActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}