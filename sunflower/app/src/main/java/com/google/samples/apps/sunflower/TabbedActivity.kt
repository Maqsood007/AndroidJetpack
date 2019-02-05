package com.google.samples.apps.sunflower

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.viewpager.widget.ViewPager
import com.google.samples.apps.sunflower.tabbed.ContainerPagerAdapter
import com.google.samples.apps.sunflower.tabbed.DashboardFragment
import com.google.samples.apps.sunflower.tabbed.NotificationFragment
import com.google.samples.apps.sunflower.tabbed.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_tabbed.*
import kotlinx.android.synthetic.main.activity_tabbed.view.*

class TabbedActivity : AppCompatActivity() , ViewPager.OnPageChangeListener,DashboardFragment.OnFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener {


    private var prevMenuItem : MenuItem? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homeFragment -> {
                viewPager.currentItem = 0;
                return@OnNavigationItemSelectedListener true
            }
            R.id.dashboardFragment -> {
                viewPager.currentItem = 1;

                return@OnNavigationItemSelectedListener true
            }
            R.id.notificationFragment -> {
                viewPager.currentItem = 2;

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

        viewPager.offscreenPageLimit = 3
        viewPager.addOnPageChangeListener(this)
        viewPager.adapter = ContainerPagerAdapter(supportFragmentManager, this)

//        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
//        val navController = Navigation.findNavController(this, R.id.mainNavigationFragment)
//        NavigationUI.setupWithNavController(navigation, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
       Log.v("onSupportNavigateUp", "")
        return true;
    }

    override fun onBackPressed() {

        super.onBackPressed()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {

        if (prevMenuItem != null)
            prevMenuItem!!.setChecked(false);
        else
            navigation.getMenu().getItem(0).setChecked(false);

        navigation.getMenu().getItem(position).setChecked(true);
        prevMenuItem = navigation.getMenu().getItem(position);
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }
}

