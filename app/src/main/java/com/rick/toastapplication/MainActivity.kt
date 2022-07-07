package com.rick.toastapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

    }

    override fun onResume() {
        super.onResume()

        if (viewModel.flag) {
            val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return

            when (sharedPref.getInt(PREF_KEY, 1)) {
                1 -> {
                    viewModel.updateCount()
                    with(sharedPref.edit()) {
                        putInt(PREF_KEY, viewModel.count)
                        apply()
                    }

                }
                2 -> {
                    viewModel.updateCount()
                    viewModel.updateCount()
                    sharedPref.edit()
                        .putInt(PREF_KEY, viewModel.count)
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
    }

    /**
     * Чтобы не обновить значение параметра count при повороте экрана
     * */
    override fun onPause() {
        super.onPause()
        viewModel.updateFlag()
    }
}

const val PREF_KEY = "pref_key"

