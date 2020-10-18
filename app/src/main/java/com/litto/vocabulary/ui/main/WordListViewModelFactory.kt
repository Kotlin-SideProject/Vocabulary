package com.litto.vocabulary.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litto.vocabulary.data.Repository
import java.lang.RuntimeException

class WordListViewModelFactory(val context: Context)
                                : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.getConstructor(Repository::class.java)
                .newInstance(Repository(context))
        } catch (e: Exception) {
            throw RuntimeException("create instance error")
        }
    }

}