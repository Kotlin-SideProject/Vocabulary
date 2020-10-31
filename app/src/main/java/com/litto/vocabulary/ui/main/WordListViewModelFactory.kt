package com.litto.vocabulary.ui.main

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litto.vocabulary.data.Repository
import java.lang.RuntimeException

class WordListViewModelFactory(val repository: Repository)
                                : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.getConstructor(Repository::class.java)
                .newInstance(repository)
        } catch (e: Exception) {
            throw RuntimeException("create instance error")
        }
    }
    companion object {
        fun createFactory(activity: Activity): WordListViewModelFactory {
            val context = activity.applicationContext
            return WordListViewModelFactory(Repository.getInstance(context))
        }
    }
}