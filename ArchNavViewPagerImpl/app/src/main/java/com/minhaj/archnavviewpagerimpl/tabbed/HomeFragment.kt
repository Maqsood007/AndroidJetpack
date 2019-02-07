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


import kotlinx.android.synthetic.main.activity_tabbed.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {



    private  var navControllerListener: PageControllerListener? = null;


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

        val navHostFragment = childFragmentManager.findFragmentById(R.id.tab_1_nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = navHostFragment.navController

        navControllerListener?.setNavController(navController)

        val appBarConfig = AppBarConfiguration(navController.graph)

//        (activity as TabbedActivity).toolbar.setupWithNavController(navController, appBarConfig)
//        (activity as AppCompatActivity).setSupportActionBar((activity as TabbedActivity).toolbar)
//        setupActionBarWithNavController(activity as AppCompatActivity,navController)

        NavigationUI.setupWithNavController((activity as TabbedActivity).toolbar, navController)

//        (activity as TabbedActivity).supportFragmentManager.beginTransaction()
//                .add(R.id.tab_1_nav_host_fragment, navHostFragment)
//                .setPrimaryNavigationFragment(navHostFragment) // this is the equivalent to app:defaultNavHost="true"
//                .commit()

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        navControllerListener = context as (PageControllerListener)
    }


    override fun onDetach() {
        navControllerListener = null
        super.onDetach()
    }

}
