package com.bliss.yang.jetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.btn_jump).setOnClickListener {
            //传参①
//            var bundle = Bundle()
//            bundle.putString("user","Bliss")
//            bundle.putInt("age",30)
            //传参②
            var bundle = MainFragmentArgs.Builder()
                .setUser("Bliss91")
                .setAge(31).build().toBundle()
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment,bundle)
//        方法二 Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_secondFragment)
        }
        return view
    }
}