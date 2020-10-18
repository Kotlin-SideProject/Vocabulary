package com.litto.vocabulary.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.litto.vocabulary.R
import com.litto.vocabulary.data.Word
import com.litto.vocabulary.ui.detail.DetailActivity

class WordAdapter : RecyclerView.Adapter<WordViewHolder>() {
    var listener : WordClickListener? = null
    private var words: List<Word>? = null
    companion object {
        val TYPE_UNSTAR = 0
        val TYPE_STAR = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_word, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return words?.get(position)?.run {
            if (star == 0) TYPE_UNSTAR else TYPE_STAR
        } ?: TYPE_UNSTAR
    }

    override fun getItemCount(): Int {
        return words?.size ?: 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.name.setText(words?.get(position)?.name ?: "not available")
        holder.itemView.setOnClickListener {
            val word = words!!.get(position)
            listener?.run {
                wordSelected(word, position)
            }
        }
    }

    fun submitList(words: List<Word>?) {
        this.words = words
        notifyDataSetChanged()
    }
}

interface WordClickListener {
    fun wordSelected(word: Word, position: Int)
}