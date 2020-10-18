package com.litto.vocabulary.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.ui.main.WordListViewModelFactory
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel

    //    var word : Word? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        word = intent.getParcelableExtra<Word>("WORD")
        val name = intent.getStringExtra("WORD_NAME")
        viewModel = ViewModelProvider(this, WordListViewModelFactory(this))
            .get(DetailViewModel::class.java)
        viewModel.word.observe(this, Observer {

        })
    }
}