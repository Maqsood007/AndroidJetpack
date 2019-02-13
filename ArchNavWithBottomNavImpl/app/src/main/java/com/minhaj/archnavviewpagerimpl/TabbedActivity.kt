package com.minhaj.archnavviewpagerimpl

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.samples.apps.sunflower.tabbed.dummy.DummyContent
import com.minhaj.archnavviewpagerimpl.tabbed.ContainerPagerAdapter
import com.minhaj.archnavviewpagerimpl.tabbed.DashboardFragment
import com.minhaj.archnavviewpagerimpl.tabbed.NotificationFragment
import kotlinx.android.synthetic.main.activity_tabbed.*

class TabbedActivity : AppCompatActivity(),
    DashboardFragment.OnFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener{


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homeFragment -> {


                return@OnNavigationItemSelectedListener true
            }
            R.id.dashboardFragment -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.notificationFragment -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbed)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setSupportActionBar(toolbar)


//        val navHostFragment = mainNavigationFragment as NavHostFragment?
//            ?: return
//
//        val navController = navHostFragment.navController

         val navController = Navigation.findNavController(this, R.id.mainNavigationFragment)



        NavigationUI.setupWithNavController(toolbar, navController)

        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        NavigationUI.setupWithNavController(navigation, navController)

    }


    override fun onBackPressed() {
            super.onBackPressed()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }



}

