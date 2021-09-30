package com.example.dependencynow.screens.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencynow.module.sub.SplScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@SplScope
class SplashViewModel @Inject constructor() : ViewModel() {
    var _loadData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _loadData.value = true
            delay(2000)
            _loadData.value = false
        }
    }

}