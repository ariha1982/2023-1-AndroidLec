package com.example.subeye

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val themeColorPreference: ListPreference? = findPreference("actionBar_color")
        themeColorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        val txtColorPreference: ListPreference? = findPreference("tx_color")
        txtColorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        val ttsSpeedPreference: ListPreference? = findPreference("tts_speed")
        ttsSpeedPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        val ttsPitchPreference: ListPreference? = findPreference("tts_pitch")
        ttsPitchPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
    }
}