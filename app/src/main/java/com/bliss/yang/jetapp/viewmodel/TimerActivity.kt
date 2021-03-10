package com.bliss.yang.jetapp.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bliss.yang.jetapp.R

class TimerActivity : AppCompatActivity() {
    private  val TAG = "TimerActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        init()
    }

    private fun init() {
        val timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        timerViewModel.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener {
            override fun onTimeChange(second: Int) {
                Log.e(TAG, "onTimeChange:$second ")
            }
        })
        timerViewModel.startTiming()
    }
}