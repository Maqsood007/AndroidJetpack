package com.minhaj.archnavviewpagerimpl.tabbed.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.get

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
class Home1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        clickMeAlso.setOnClickListener {


            val  navigateTOHome2 = Home1FragmentDirections.actionHome1FragmentToNavigationGraphContent();
//
            findNavController().navigate(navigateTOHome2)

//            findNavController().graph.get(R.id.navigation_graph_content).navigatorName.plus(navigateTOHome2)


        }
    }

}
