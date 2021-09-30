package com.example.dependencynow.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencynow.MyApp
import com.example.dependencynow.R
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

//    val viewModel: MainViewModel by viewModels {
//        MainViewModelFactory((application as MyApp).personDB)
//    }

    @Inject
    lateinit var viewModel: MainViewModel

    val personAdapter: MainPersonAdapter by lazy { MainPersonAdapter() }
    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        val component = (application as MyApp).component
        component.inject(this)

        setContentView(binding.root)

        initViews()
        initRecycle()
        observer()
    }

    private fun initViews() {
        binding.btInsert.setOnClickListener {
            viewModel.insert(getString(R.string.lists))
        }
        binding.btDelete.setOnClickListener {
            viewModel.deleteAll()
        }
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