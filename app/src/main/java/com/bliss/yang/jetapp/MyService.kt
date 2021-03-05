package com.bliss.yang.jetapp

import androidx.lifecycle.LifecycleService

/**
* Author: yangtianfu
* Date: 2021/3/5 17:23
* Describe:LifecycleService的绑定
*/
class MyService: LifecycleService() {
    private  var myServiceObserver:MyServiceObserver = MyServiceObserver()
    init {
        lifecycle.addObserver(myServiceObserver)
    }
}