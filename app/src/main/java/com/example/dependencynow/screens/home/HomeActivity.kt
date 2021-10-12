package com.example.dependencynow.screens.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.databinding.ActivityHomeBinding
import com.example.dependencynow.modul.home.HomeFactory
import com.example.dependencynow.modul.home.customscope.HomeEntryPoint
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var ftr: HomeFactory

    @Inject
    lateinit var homeComponentHandler: HomeComponentHandler

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModel.provideFactory(
            ftr, "this is result"
        )
    }

    private var _binding: ActivityHomeBinding? = null
    val binding: ActivityHomeBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeComponentHandler.create()

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: $homeViewModel")

        homeViewModel._data.observe(this) {
            binding.txt.text = it
        }

        val person = EntryPoints.get(homeComponentHandler, HomeEntryPoint::class.java)

        Log.d(TAG, "onCreate: ${person}")
    }
}