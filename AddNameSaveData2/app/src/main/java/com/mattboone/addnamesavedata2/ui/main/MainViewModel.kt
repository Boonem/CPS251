package com.mattboone.addnamesavedata2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    var names : MutableLiveData<String> = MutableLiveData("")
    var newName :MutableLiveData<String> = MutableLiveData("")

    fun addName() {
        names.value = names.value + newName.value + "\n"
    }
}