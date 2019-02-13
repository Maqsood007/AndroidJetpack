package com.minhaj.archnavviewpagerimpl.tabbed

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.minhaj.archnavviewpagerimpl.PageControllerListener
import com.minhaj.archnavviewpagerimpl.R
import com.minhaj.archnavviewpagerimpl.TabbedActivity
//import com.minhaj.archnavviewpagerimpl.tabbed.home.Home1FragmentDirections


import kotlinx.android.synthetic.main.activity_tabbed.*
import kotlinx.android.synthetic.main.fragment_home1.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {



    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        clickMeAlso2.setOnClickListener {

            val  navigateTOHome1 = HomeFragmentDirections.actionHomeFragmentToNavigationGraphContent();
//
            findNavController().navigate(navigateTOHome1)

        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }


    override fun onDetach() {
        super.onDetach()
    }

}
