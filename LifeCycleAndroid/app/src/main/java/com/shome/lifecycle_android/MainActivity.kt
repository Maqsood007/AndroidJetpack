package com.shome.lifecycle_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val REMAINING_TIME: String = "REMAINING_TIME"
    private  var FUTURE_TIME : Long = 50000
    private  var INTER_TIME : Long = 1000

    val timerListener: LifeObserverTimer.TimerListener = object : LifeObserverTimer.TimerListener {

        override fun onTick(second: Int) {

            // Update UI

            runOnUiThread {

                tv_tick.text = second.toString()
            }
        }

    }


    val lifeObserverTimer: LifeObserverTimer = LifeObserverTimer(this, lifecycle, timerListener,FUTURE_TIME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState!=null && savedInstanceState.containsKey(REMAINING_TIME)){

            FUTURE_TIME = savedInstanceState.getLong(REMAINING_TIME)
        }

        lifecycle.addObserver(lifeObserverTimer)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putLong(REMAINING_TIME, lifeObserverTimer.getMillisUntilFinished())
        super.onSaveInstanceState(outState)
    }

}
