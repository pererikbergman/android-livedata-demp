package com.rakangsoftware.livedatademo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

internal class MainViewModelFactory() : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}
