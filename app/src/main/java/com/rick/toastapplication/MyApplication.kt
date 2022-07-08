package com.rick.toastapplication

import android.app.Application
import android.content.Context
import android.widget.Toast

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val sharedPref = getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

        when (sharedPref.getInt(PREF_KEY, 1)) {
            1 -> {
                with(sharedPref.edit()) {
                    putInt(PREF_KEY, 2)
                    apply()
                }

            }
            2 -> {
                sharedPref.edit()
                    .putInt(PREF_KEY, 3)
                    .apply()
            }
            3 -> {
                Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show()
                sharedPref.edit()
                    .putInt(PREF_KEY, -1)
                    .apply()
            }
        }

    }

    companion object {
        const val PREF_KEY = "pref_key"
        const val APP_NAME = "toast"
    }
}