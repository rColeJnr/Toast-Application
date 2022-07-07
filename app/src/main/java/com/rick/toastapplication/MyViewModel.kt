package com.rick.toastapplication

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    var count = 1
        private set

    var flag = true
        private set

    fun updateFlag() {
        flag = false
    }

    fun updateCount() {
        count++
    }

}
