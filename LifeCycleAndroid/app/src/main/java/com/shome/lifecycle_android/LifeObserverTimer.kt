package com.shome.lifecycle_android

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.*

class LifeObserverTimer(
    val context: Context, val lifecycle: Lifecycle, val timerListener: TimerListener,
    miliSecondFuture : Long, interValTime : Long = 1000
) : CountDownTimer(miliSecondFuture, interValTime), LifecycleObserver {


    private var millisUntilFinished: Long = 5000

    override fun onFinish() {

        print("finish")
    }

    override fun onTick(millisUntilFinished: Long) {

        this.millisUntilFinished = millisUntilFinished
        Log.d("TICK", millisUntilFinished.toString())
        timerListener.onTick(second = millisUntilFinished.toInt() / 1000)

    }


    public final fun getMillisUntilFinished(): Long {
        return millisUntilFinished
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {

        print("ON_CREATE")

        start()

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startMe() {

        print("ON_START")

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {

        print("ON_RESUME")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {

        print("ON_PAUSE")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {

        print("ON_STOP")


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        print("ON_STOP")
        cancel()
    }


    interface TimerListener {

        fun onTick(second: Int)
    }

}