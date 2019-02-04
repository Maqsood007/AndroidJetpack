package com.google.samples.apps.sunflower.tabbed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

import com.google.samples.apps.sunflower.R
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
        // TODO: Use the ViewModel


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val toolbar = view.findViewById<Toolbar>(R.id.tab_1_toolbar)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.tab_1_nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = navHostFragment.navController



        val appBarConfig = AppBarConfiguration(navController.graph)

        toolbar.setupWithNavController(navController, appBarConfig)
    }

}
