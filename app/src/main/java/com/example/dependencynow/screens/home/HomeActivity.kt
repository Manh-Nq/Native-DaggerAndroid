package com.example.dependencynow.screens.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.databinding.ActivityHomeBinding
import com.example.dependencynow.modul.home.DaggerHomeComponent
import javax.inject.Inject


class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    private var _binding: ActivityHomeBinding? = null
    val binding: ActivityHomeBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerHomeComponent.builder()
            .seedData("Done")
            .build()
            .inject(this)

        Log.d(TAG, "onCreate: $homeViewModel")

        homeViewModel._data.observe(this) {
            binding.txt.text = it

        }
    }
}