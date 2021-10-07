package com.example.dependencynow.screens.exp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dependencynow.database.dao.PersonDao
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ExampleViewModel @Inject constructor(
    @Named("number") num: Int,
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var _data: MutableLiveData<Int> = MutableLiveData()

    init {
        _data.value = num
    }
}