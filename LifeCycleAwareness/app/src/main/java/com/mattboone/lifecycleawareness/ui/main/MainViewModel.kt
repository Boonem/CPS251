package com.mattboone.lifecycleawareness.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.MutableLiveData

const val RESULT_KEY = "Result"

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var result: MutableLiveData<String> = savedStateHandle.getLiveData(RESULT_KEY)
//I don't know how to get the event listening functions in DemoObserver to alter this LiveData
    fun addEvent(value: String) {
        result.value = (result.value.toString() + value)
    }


}