package com.google.samples.apps.sunflower.tabbed.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.samples.apps.sunflower.R
import android.view.KeyEvent.KEYCODE_BACK
import android.view.KeyEvent
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home1.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Home3Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        clickMeAlso.setOnClickListener {

            Navigation.findNavController(it).popBackStack(R.id.home1Fragment,false)

        }
    }


    override fun onResume() {
        super.onResume()

        if (view == null) {
            return
        }

        view!!.isFocusableInTouchMode = true
        view!!.requestFocus()
        view!!.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {

                return if (event.getAction() === KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    // handle back button's click listener
                    Navigation.findNavController(v).navigateUp()
                    true
                } else false
            }
        })
    }

}
