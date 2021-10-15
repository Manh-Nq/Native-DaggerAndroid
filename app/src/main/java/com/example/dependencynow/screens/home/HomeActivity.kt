package com.example.dependencynow.screens.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.databinding.ActivityHomeBinding
import com.example.dependencynow.modul.home.HomeFactory
import com.example.dependencynow.modul.home.customscope.HomeEntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeFactory: HomeFactory

    @Inject
    lateinit var homeComponentHandler: HomeComponentHandler

    @Inject
    lateinit var exampleClassFactory: ExampleClassFactory

    val exampleClass: ExampleClass by lazy {
        exampleClassFactory.create(123, 632)
    }

    private val homeViewModel: HomeViewModel by viewModels {
        ProviderFactory(
            homeFactory, "this is result"
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

        val entryPoint = EntryPoints.get(homeComponentHandler, HomeEntryPoint::class.java)

        entryPoint.getPerson().observe(this) {
            Log.d(TAG, "onCreate: ${it.size}")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        homeComponentHandler.destroy()
    }
}