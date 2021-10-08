package com.example.dependencynow.screens.exp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.MyApp
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.ActivityExampleBinding
import com.example.dependencynow.modul.example.M001Component
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val TAG = "ManhNQ"

@AndroidEntryPoint
class M001Activity : AppCompatActivity() {
    @Inject
    lateinit var builder: M001Component.Builder

    private var _binding: ActivityExampleBinding? = null


    val binding: ActivityExampleBinding get() = _binding!!

    @Inject
    lateinit var exViewModel: M001ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val component = builder.attachNumber(Person(name = "manh", age = 25)).build()
        exViewModel.getComponent(component)
//        val person = EntryPoints.get(component, M001EntryPoint::class.java).getPerson()

        exViewModel._data.observe(this) {
            Log.d(TAG, "onCreate: $it")
        }

    }

}