package com.bliss.yang.jetapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel:ViewModel() {
    private var currentSecond:MutableLiveData<Int> = MutableLiveData()

    fun getCurrentSecond():LiveData<Int>{
        if (currentSecond == null){
            currentSecond = MutableLiveData()
        }
        return currentSecond
    }
}