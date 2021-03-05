package com.bliss.yang.jetapp

import android.app.Activity
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
* Author: yangtianfu
* Date: 2021/3/5 16:30
* Describe: 绑定activity的生命周期
*/
class LifeCycleListener(val activity: Activity, private val onChangeListener: OnChangeListener) :LifecycleObserver {
    companion object{
        init {
            Log.e("tagLifeCycleListener", ": 执行" )
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreated(){
        onChangeListener.onChange("回调 onCreated 执行")
        Log.e("tagLifeCycleListener", ":onCreated 执行" )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume(){
        Log.e("tagLifeCycleListener", ":onResume 执行" )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause(){
        Log.e("tagLifeCycleListener", ":onPause 执行" )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        Log.e("tagLifeCycleListener", ":onDestroy 执行" )
    }

    interface OnChangeListener{
        fun onChange(des:String)
    }
}