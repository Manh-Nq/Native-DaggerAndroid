package com.example.dependencynow.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencynow.modul.home.HomeFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

const val TAG = "ManhNQ"

class HomeViewModel @AssistedInject constructor(@Assisted txt: String) : ViewModel() {

    var _data = MutableLiveData<String>()

    init {
        _data.value = txt
    }

    companion object {
        fun provideFactory(
            assistedFactory: HomeFactory,
            initParams: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(initParams) as T
            }
        }
    }
}


