package com.rick.toastapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("key","value")
            apply()
        }

        sharedPref.
            getString(PREF_KEY, "")

        Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show()

    }


}

const val PREF_KEY = "pref_key"

