package com.bliss.yang.jetapp

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    private val TAG = "SecondFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //接受参数①
        var bundle = arguments
//        if (bundle!=null){
//            var user:String = bundle.getString("user","")
//            var age = bundle.getInt("age")
//            Log.e(TAG, "onCreateView:$user,$age " )
//        }
        //接受参数②
        if(bundle!=null){
            var user = MainFragmentArgs.fromBundle(bundle).user
            var age = MainFragmentArgs.fromBundle(bundle).age
            Log.e(TAG, "safe-args接收参数:$user,$age " )
        }


        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()//清除父容器activity中的menu，
        super.onCreateOptionsMenu(menu, inflater)
    }
}