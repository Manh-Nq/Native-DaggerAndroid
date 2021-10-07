package com.example.dependencynow.screens.exp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.databinding.ActivityExampleBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ExampleActivity:AppCompatActivity() {

    private var _binding: ActivityExampleBinding? = null
    val binding: ActivityExampleBinding get() = _binding!!


    val exViewModel: ExampleViewModel by viewModels()
    private val TAG = "ManhNQ"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exViewModel._data.observe(this) {
            Log.d(TAG, "onCreate: $it")
        }

    }

}