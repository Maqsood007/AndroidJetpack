package com.minhaj.archnavviewpagerimpl.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.minhaj.archnavviewpagerimpl.app.Application

object AppSharedPreference {


    /*
    * {https://developer.android.com/kotlin/ktx}
    */

    // Commit a new value asynchronously
//    sharedPreferences.edit { putBoolean("key", value) }

// Commit a new value synchronously
//    sharedPreferences.edit(commit = true) { putBoolean("key", value) }


    private val DEFAULT_VALUE_STRING  = "DEFAULT_VALUE"
    private val DEFAULT_VALUE_INT  = -1
    private val DEFAULT_VALUE_  = 0.0F


    fun putValue(key: String, value: String){
        Application.pref.edit {
            putString(key, value)
        }
    }

    fun putInt(key: String, value: Int){
        Application.pref.edit {
            putInt(key, value)
        }
    }

    fun putFloat(key: String, value: Float){
        Application.pref.edit {
            putFloat(key, value)
        }
    }

    fun getStringValue(key: String){
        Application.pref.getString(key,DEFAULT_VALUE_STRING)
    }

    fun getIntValue(key: String){
        Application.pref.getInt(key,DEFAULT_VALUE_INT)
    }

    fun getDoubleValue(key: String){
        Application.pref.getFloat(key,DEFAULT_VALUE_)
    }

}



