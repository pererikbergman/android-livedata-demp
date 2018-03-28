package com.rakangsoftware.livedatademo

import android.arch.core.util.Function
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    val demo = MutableLiveData<String>()
    val notTriggered: LiveData<String>
    val triggered: LiveData<String>

    init {
        demo.postValue("Should be shown!")

        notTriggered = Transformations.map(demo, object : Function<String, String> {
            override fun apply(input: String?): String {
                return "This should never be shown since notTriggered don't have any observers!"
            }
        })

        triggered = Transformations.map(demo, object : Function<String, String> {
            override fun apply(input: String?): String {
                return "This should be shown since triggered have an observer!"
            }
        })
    }
}