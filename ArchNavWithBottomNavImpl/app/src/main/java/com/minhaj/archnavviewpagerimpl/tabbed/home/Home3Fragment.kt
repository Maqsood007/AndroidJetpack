package com.minhaj.archnavviewpagerimpl.tabbed.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import android.view.KeyEvent.KEYCODE_BACK
import android.view.KeyEvent
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.minhaj.archnavviewpagerimpl.R
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

            findNavController().navigate(Home3FragmentDirections.actionHome3FragmentToHome4Fragment())

        }
    }


    override fun onResume() {
        super.onResume()

    }

}
