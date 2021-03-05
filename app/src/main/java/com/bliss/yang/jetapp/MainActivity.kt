package com.bliss.yang.jetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

/**
* Author: yangtianfu
* Date: 2021/3/5 16:19
* Describe:
*/
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var lifecycleListener:LifeCycleListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "onCreate: 执行", )
        lifecycleListener = LifeCycleListener(this, object : LifeCycleListener.OnChangeListener {
            override fun onChange(des: String) {
                Log.e(TAG, "接受到 onChange: ")
            }

        })
        //lifecycle将观察者和被观察者绑定，解决组件对activity生命周期的依赖问题
        lifecycle.addObserver(lifecycleListener)
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: 执行", )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: 执行", )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: 执行", )
    }

    fun launchService(view: View) {
        startService(Intent(this,MyService::class.java))
    }
    fun closeService(view: View) {
        stopService(Intent(this,MyService::class.java))
    }
}