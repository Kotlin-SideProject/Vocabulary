package com.litto.vocabulary.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.litto.vocabulary.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.settings)
    }
}