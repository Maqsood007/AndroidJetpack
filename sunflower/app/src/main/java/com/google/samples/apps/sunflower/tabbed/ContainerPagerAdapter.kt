package com.google.samples.apps.sunflower.tabbed


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.findNavController
import com.google.samples.apps.sunflower.TabbedActivity


class ContainerPagerAdapter(fragmentManager: FragmentManager, var  activity: TabbedActivity) : FragmentPagerAdapter(fragmentManager) {


  override fun getItem(position: Int): Fragment {

      when(position){

          0 -> {
              return HomeFragment.newInstance()
          }
          1 ->{
              return DashboardFragment.newInstance()
          }
          2 ->{
              return NotificationFragment.newInstance(1)
          }
          else -> { // Note the block
              return HomeFragment.newInstance()
          }

      }

  }

  // 3  
  override fun getCount(): Int {
    return 3
  }
}