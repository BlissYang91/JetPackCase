package com.bliss.yang.jetapp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationObserver:LifecycleObserver {
    private  val ApplicationObserverTAG = "ApplicationObserver"

    /**
     * 监听应用程序的onCreate方法，整个生命周期只会调用一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreated(){
        Log.e(ApplicationObserverTAG, "Application onCreated: 执行" )
    }

    /**
     * 监听应用程序的处于前台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart(){
        Log.e(ApplicationObserverTAG, "Application onStart: 前台执行" )
    }

    /**
     * 监听应用程序的处于前台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume(){
        Log.e(ApplicationObserverTAG, "Application onResume: 前台执行" )
    }

    /**
     * 监听应用程序的处于后台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause(){
        Log.e(ApplicationObserverTAG, "Application onPause: 后台执行" )
    }

    /**
     * 监听应用程序的处于后台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop(){
        Log.e(ApplicationObserverTAG, "Application onStop: 后台执行" )
    }

    /**
     * 永远不会调用，系统不会分发调用on_destroy事件
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        Log.e(ApplicationObserverTAG, "Application onDestroy: 不会执行" )
    }
}