package com.litto.vocabulary.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.ui.main.WordListViewModelFactory
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel
    companion object {
        val TAG = DetailActivity::class.java.simpleName
    }
    //    var word : Word? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        word = intent.getParcelableExtra<Word>("WORD")
        val name = intent.getStringExtra("WORD_NAME")!!
        val factory = DetailViewModelFactory.createFactory(this, name)
        viewModel = ViewModelProvider(this, factory)
            .get(DetailViewModel::class.java)
        viewModel.word.observe(this, Observer {
            Log.d(TAG, "word: $it");
        })
    }
}