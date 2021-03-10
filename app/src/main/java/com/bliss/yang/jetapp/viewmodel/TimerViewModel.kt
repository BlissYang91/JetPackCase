package com.bliss.yang.jetapp.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*

class TimerViewModel:ViewModel() {
    private var timer:Timer?=null
    private var currentSecond:Int = 0

    fun startTiming(){
        if (timer==null){
            currentSecond = 0
            timer = Timer()
            val timerTask:TimerTask = MyTask()
            timer?.schedule(timerTask,1000,1000)
        }
    }
    private inner class MyTask:TimerTask(){
        override fun run() {
            currentSecond ++
            if (onTimeChangeListener!=null){
                onTimeChangeListener.onTimeChange(currentSecond)
            }
        }
    }
    interface OnTimeChangeListener{
        fun onTimeChange(second:Int)
    }
    private lateinit var onTimeChangeListener:OnTimeChangeListener
    fun setOnTimeChangeListener(onTimeChangeListener:OnTimeChangeListener){
        this.onTimeChangeListener = onTimeChangeListener
    }

    /**
     * 当viewmodel不再被需要，也就是相关联的activity被销毁时，该方法被系统调用
     * 可以执行一些资源释放的操作，但是由于屏幕旋转而导致的activity的重建不会触发此方法，不会影响viewmodel的生命周期
     */
    override fun onCleared() {
        super.onCleared()
    }
}