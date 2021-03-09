package com.bliss.yang.jetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

/**
* Author: yangtianfu
* Date: 2021/3/5 16:19
* Describe:
*/
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var appBarConfiguration:AppBarConfiguration?=null//用于APPBar的配置
    private var navController:NavController?=null//用于页面的导航和切换
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment_container)
        navController?.let { _navController ->
            appBarConfiguration = AppBarConfiguration.Builder(_navController.graph).build()
        }
        //将APPBar和navController绑定
        if (navController!=null && appBarConfiguration!=null){
            NavigationUI.setupActionBarWithNavController(this, navController!!,
                appBarConfiguration!!
            )
        }
        if (navController!=null){
            navController?.addOnDestinationChangedListener { controller, destination, arguments ->
                Log.e(TAG, "onDestinationChanged: 页面切换监听")
            }
        }

    }

    /**
     * 通过NavigationUI完成点击跳转
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (navController!=null){
            return NavigationUI.onNavDestinationSelected(item, navController!!)
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 使用NavigationUI完成返回
     */
    override fun onSupportNavigateUp(): Boolean {
        if (navController!=null && appBarConfiguration!=null){
            return NavigationUI.navigateUp(navController!!, appBarConfiguration!!)
        }
        return super.onSupportNavigateUp()
    }

    //添加菜单栏
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_setting,menu)
        return true
    }

    fun launchService(view: View) {
        startService(Intent(this,MyService::class.java))
    }
    fun closeService(view: View) {
        stopService(Intent(this,MyService::class.java))
    }
}