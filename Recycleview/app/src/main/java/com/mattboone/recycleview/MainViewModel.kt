package com.mattboone.recycleview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object StaticMVM {
        private val data = Data()
        private var randCounter = MutableLiveData(0)
        private val rands = Array(8) {IntArray(3) {(0..7).random()}}

        fun getTitles():  Array<String>{
            return data.getTitles()
        }
        fun getDetails():  Array<String>{
            return data.getDetails()
        }
        fun getImages(): IntArray {
            return data.getImages()
        }

        /*fun nextRand(): Int? {
            if (randCounter.value == 24) {randCounter.value = 1}
            else {randCounter.value = (randCounter.value)?.plus(1) }
            val randsInst = rands
            return randCounter.value?.let { randsInst.get(it) }
        }*/

        fun getRand(i: Int, j: Int) : Int {
            return rands[i][j]
        }
        fun getRandSet(i: Int) : IntArray {
            return rands[i]
        }
    }
    /*private val data = Data()
    private var randCounter = MutableLiveData(0)
    private val rands = IntArray(24) { (0..7).random()}

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
        val randsInst = rands
        return randCounter.value?.let { randsInst.get(it) }
    }

    fun getRand(i: Int) : Int {
        return rands[i]
    }*/

}