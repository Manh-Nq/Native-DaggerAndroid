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
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import com.example.dependencynow.screens.main.adapter.PersonListener
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private val TAG = "ManhNQ"

    @Inject
    lateinit var viewModel: MainViewModel

    val personAdapter: MainPersonAdapter by lazy {
        MainPersonAdapter(
            PersonListener(
                this::onDeleteClicked,
                this::onItemClicked
            )
        )
    }
    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val component = (application as MyApp).component.createCustomComponent().createInt(10).build()
        component.inject(this)
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

    private fun onItemClicked(item: Person) {
        Log.d(TAG, "onItemClicked: ")
    }

    private fun onDeleteClicked(item: Person) {
        viewModel.delete(item)
    }
}