package com.litto.vocabulary.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_word.view.*

class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.item_name
    val star = itemView.item_star
}