package com.minhaj.archnavviewpagerimpl.app

import android.app.Application
import android.content.SharedPreferences


class Application : Application() {


    companion object {

        lateinit var pref : SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()

        pref = getSharedPreferences("ApplicationPref",0)
    }

}