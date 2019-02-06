package com.google.samples.apps.sunflower.activitynavhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.TabbedActivity
import kotlinx.android.synthetic.main.activity_nav_host.*
import kotlinx.android.synthetic.main.activity_tabbed.*

class NavHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment?
                ?: return

        val navController = navHostFragment.navController

        // Set up ActionBar

        val toolbar: Toolbar = findViewById(R.id.toolbar)

        NavigationUI.setupWithNavController(toolbar, navController)

    }


    override fun onSupportNavigateUp() : Boolean {
        Log.d("","")
        return findNavController(R.id.fragment).navigateUp()
    }


    override fun onBackPressed() {
        Log.d("","")
        super.onBackPressed()
    }

}
