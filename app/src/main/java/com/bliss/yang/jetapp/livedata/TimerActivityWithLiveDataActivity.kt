package com.bliss.yang.jetapp.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bliss.yang.jetapp.R
import com.bliss.yang.jetapp.viewmodel.TimerViewModel

class TimerActivityWithLiveDataActivity : AppCompatActivity() {
    private  val TAG = "TimerActivityWithLiveDa"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_with_live_data)
        initComponent()
    }

    private fun initComponent() {
        val timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        var liveData = timerViewModel.getCurrentSecond()
        liveData.observe(this, Observer {
            Log.e(TAG, "initComponent::$it ")
        })
    }
}