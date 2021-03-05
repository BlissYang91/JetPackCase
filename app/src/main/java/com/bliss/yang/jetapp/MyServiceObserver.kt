package com.bliss.yang.jetapp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyServiceObserver :LifecycleObserver{
    private  val MyServiceObserverTAG = "MyServiceObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart(){
        Log.e(MyServiceObserverTAG, "start: 执行" )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        Log.e(MyServiceObserverTAG, "onDestroy: 执行" )
    }

}