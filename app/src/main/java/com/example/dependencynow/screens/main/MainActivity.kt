package com.example.dependencynow.screens.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencynow.MyApp
import com.example.dependencynow.R
import com.example.dependencynow.Utils
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import com.example.dependencynow.screens.main.adapter.PersonListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var toast: Toast? = null

    @Inject
    lateinit var personAdapter: MainPersonAdapter

    @Inject
    lateinit var viewModel: MainViewModel

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
        personAdapter.setOnclickListener(PersonListener(this::deleteClicked, this::itemClicked))
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
        binding.rvPerson.adapter = personAdapter
    }

    private fun observer() {
        viewModel._data.observe(this) {
            personAdapter.submitList(it)
        }
    }

    private fun deleteClicked(item: Person) {
        viewModel.delete(item)
    }

    private fun itemClicked(item: Person) {
generateNoti(item.name)
    }

    @SuppressLint("ShowToast")
    fun generateNoti(txt: String) {
        if (toast != null) {
            toast?.cancel()
        }
        toast = Toast.makeText(this, txt, Toast.LENGTH_SHORT)
        toast?.show()
    }

}