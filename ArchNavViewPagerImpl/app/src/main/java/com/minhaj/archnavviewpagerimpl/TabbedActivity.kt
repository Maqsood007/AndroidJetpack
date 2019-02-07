package com.minhaj.archnavviewpagerimpl

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
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

class TabbedActivity : AppCompatActivity(), ViewPager.OnPageChangeListener,
    DashboardFragment.OnFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener,
    PageControllerListener {


    private var prevMenuItem: MenuItem? = null

    private lateinit var pageNavController: NavController;

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.homeFragment -> {

                if (viewPager.currentItem == 0) {
                    pageNavController.popBackStack(R.id.home1Fragment, false)
                }
                viewPager.currentItem = 0;
                toolbar.setTitle("HomeFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.dashboardFragment -> {
                viewPager.currentItem = 1;
                toolbar.setTitle("DashboardFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.notificationFragmentgit -> {
                viewPager.currentItem = 2;
                toolbar.setTitle("NotificationFragment")
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

    }

    override fun onPageScrollStateChanged(state: Int) {

    }


    override fun onBackPressed() {

        if (viewPager.currentItem != 0)
            viewPager.currentItem = 0
        else
            super.onBackPressed()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {

        if (prevMenuItem != null) {
            prevMenuItem!!.setChecked(false);
        } else
            navigation.getMenu().getItem(0).setChecked(false);

        navigation.getMenu().getItem(position).setChecked(true);
        prevMenuItem = navigation.getMenu().getItem(position);


    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }


    override fun setNavController(navController: NavController) {

        pageNavController = navController
    }
}

