package com.minhaj.archnavviewpagerimpl.tabbed.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.minhaj.archnavviewpagerimpl.data.notification.Notification
import com.minhaj.archnavviewpagerimpl.data.notification.NotificationLocalRepository
import com.minhaj.archnavviewpagerimpl.tabbed.NotificationFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.IOException


/**
 * The ViewModel is for [NotificationFragment].
 * @param notificationRepository is [NotificationRepository]
 */

class NotificationViewModel internal constructor(private val notificationRepository: NotificationLocalRepository) :
    ViewModel() {


    val notifications: LiveData<List<Notification>> = liveData {
        val data = notificationRepository.getNotifications() // loadUser is a suspend function.
        emit(data)
    }


    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


    fun addNotification(notification: Notification) {

        viewModelScope.launch {
            notificationRepository.addNotification(notification)
        }

    }



    fun updateImage(image: String) {

        viewModelScope.launch {
            notificationRepository.updateImage(image)
        }

    }


    suspend fun callLaunchWithJoin() {

        val job = viewModelScope.launch {

            Thread.sleep(5000)
            Log.d("LAUNCH", "Coroutine section")
//            notificationRepository.getCall()
//            throw IOException()
        }

        Log.d("LAUNCH", "Before Join section")

        job.join()

        Log.d("LAUNCH", "After Join section")

    }


    suspend fun callLaunchWithoutJoin() {

        viewModelScope.launch {

            Log.d("LAUNCH", "Inside coroutine line code")

            notificationRepository.getCall()
        }

        Log.d("LAUNCH", "post couritine line code")
    }

    suspend fun callAsyncWithAwait() {


        val value = viewModelScope.async {

            val value = notificationRepository.getCall()

            Log.d("ASYNC", "Inside couritine valu $value")


            return@async value

        }


        Log.d("ASYNC", "post couritine valu ${value.await()}")

        Log.d("ASYNC", "post couritine join() value ${value.await()}")

    }


    suspend fun callAsyncWithOutAwait() {


        val value = viewModelScope.async {

            Log.d("ASYNC", "Inside couritine valu ")
            notificationRepository.getCall()

        }.await()


        Log.d("ASYNC", "post couritine value $value")

    }

}