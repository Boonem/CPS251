package com.mattboone.recycleview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val data = Data()
    private var randCounter = MutableLiveData(0)
    private val rands = MutableLiveData(IntArray(24) { (0..7).random()})

    fun getTitles():  Array<String>{
        return data.getTitles()
    }
    fun getDetails():  Array<String>{
        return data.getDetails()
    }
    fun getImages(): IntArray {
        return data.getImages()
    }

    fun nextRand(): Int? {
        if (randCounter.value == 24) {randCounter.value = 1}
        else {randCounter.value = (randCounter.value)?.plus(1) }
        val randsInst = rands.value
        return randCounter.value?.let { randsInst?.get(it) }
    }

}