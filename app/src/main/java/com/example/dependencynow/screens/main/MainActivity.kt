package com.example.dependencynow.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencynow.MyApp
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var personAdapter: MainPersonAdapter

    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btInsert.setOnClickListener {
            viewModel.insert()
        }
        binding.btDelete.setOnClickListener {
            viewModel.deleteAll()
        }

        initRecycle()
        observer()
    }

    private fun initRecycle() {
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
        binding.rvPerson.adapter = personAdapter
    }

    private fun observer() {
        viewModel._data.observe(this) {
            personAdapter.submitList(it)
        }
    }
}