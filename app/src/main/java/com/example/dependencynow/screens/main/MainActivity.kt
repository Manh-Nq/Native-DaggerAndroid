package com.example.dependencynow.screens.main

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import com.example.dependencynow.MyApp
import com.example.dependencynow.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as MyApp).personDB)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bt_insert).setOnClickListener {
            viewModel.insert("manh", 25)
        }
        observer()
    }

    private fun observer() {
        viewModel._data.observe(this) {
            it.forEach { item ->
                Log.d("ManhNQ", "observer: ${item.id}")
            }
        }
    }
}