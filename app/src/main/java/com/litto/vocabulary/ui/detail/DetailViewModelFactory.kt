package com.litto.vocabulary.ui.detail

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litto.vocabulary.data.Repository
import java.lang.RuntimeException

class DetailViewModelFactory(
        private val repository: Repository,
        private val name: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
                Repository::class.java, String::class.java)
                .newInstance(repository, name)
    }

    companion object {
        fun createFactory(activity: Activity, name: String) : DetailViewModelFactory {
            val context = activity.applicationContext ?:
            throw RuntimeException("no application")
            return DetailViewModelFactory(Repository.getInstance(context), name)
        }
    }
}