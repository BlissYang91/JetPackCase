package com.bliss.yang.jetapp

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class APP: Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}