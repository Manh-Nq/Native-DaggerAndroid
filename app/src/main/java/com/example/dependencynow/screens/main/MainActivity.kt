package com.example.dependencynow.screens.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencynow.MyApp
import com.example.dependencynow.R
import com.example.dependencynow.Utils
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.ActivityMainBinding
import com.example.dependencynow.modul.example.CustomScope
import com.example.dependencynow.screens.main.adapter.MainPersonAdapter
import com.example.dependencynow.screens.main.adapter.PersonListener
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@CustomScope
class MainActivity : AppCompatActivity() {

    private var toast: Toast? = null

    val personAdapter: MainPersonAdapter by lazy {
        MainPersonAdapter(PersonListener(this::deleteClicked, this::itemClicked))
    }

    val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as MyApp).component().injectNumber(100)

        binding.btInsert.setOnClickListener {
            viewModel.insert()
        }
        binding.btDelete.setOnClickListener {
            viewModel.deleteAll()
        }

        initRecycle()
        observer()
    }


    private fun initRecycle() = with(binding.rvPerson) {
        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = personAdapter
        addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
            scrollToPosition((adapter as MainPersonAdapter).currentList.size - 1)
        }
    }
    private  val TAG = "ManhNQ"
    private fun observer() {
       /* viewModel._data.observe(this) {
            personAdapter.submitList(it)
        }*/
        viewModel._num.observe(this) {
            Log.d(TAG, "observer: $it")
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