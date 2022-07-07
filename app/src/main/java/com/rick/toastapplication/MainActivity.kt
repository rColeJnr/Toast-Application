package com.rick.toastapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        if (sharedPref.getInt(PREF_KEY, 1) == 3) {
            Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show()
            sharedPref.edit()
                .putInt(PREF_KEY, -1)
                .apply()
        } else if (sharedPref.getInt(PREF_KEY, 1) == 1) {
            viewModel.count++
            with(sharedPref.edit()) {
                putInt(PREF_KEY, viewModel.count)
                apply()
            }

        } else if (sharedPref.getInt(PREF_KEY, 1) == 2) {
            viewModel.count = 3
            sharedPref.edit()
                .putInt(PREF_KEY, viewModel.count)
                .apply()
        }


    }


}

const val PREF_KEY = "pref_key"

