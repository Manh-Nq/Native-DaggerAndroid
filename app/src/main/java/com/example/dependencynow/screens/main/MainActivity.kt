package com.example.dependencynow.screens.main

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencynow.MyApp
import com.example.dependencynow.R
import com.example.dependencynow.Utils
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as MyApp).personDB)
    }
    val personAdapter: MainPersonAdapter by lazy { MainPersonAdapter() }
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