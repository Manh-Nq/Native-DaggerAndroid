package com.example.dependencynow.screens.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.databinding.ActivityHomeBinding
import com.example.dependencynow.modul.home.HomeFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var ftr: HomeFactory

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModel.provideFactory(
            ftr, "this is result"
        )
    }

    private var _binding: ActivityHomeBinding? = null
    val binding: ActivityHomeBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeViewModel._data.observe(this) {
            binding.txt.text = it

        }
    }
}