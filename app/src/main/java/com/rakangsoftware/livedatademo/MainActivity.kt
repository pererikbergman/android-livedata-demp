package com.rakangsoftware.livedatademo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModel
        val viewModel = ViewModelProviders.of(
                this,
                MainViewModelFactory()
        ).get(MainViewModel::class.java)

        viewModel.demo.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                println(t)
            }
        })

        viewModel.triggered.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                println(t)
            }
        })
    }
}
