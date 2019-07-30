package com.minhaj.archnavviewpagerimpl.tabbed.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minhaj.archnavviewpagerimpl.data.notification.Notification
import com.minhaj.archnavviewpagerimpl.data.notification.NotificationLocalRepository
import com.minhaj.archnavviewpagerimpl.tabbed.NotificationFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


/**
 * The ViewModel is for [NotificationFragment].
 * @param notificationRepository is [NotificationRepository]
 */

class NotificationViewModel internal constructor(private val notificationRepository: NotificationLocalRepository) : ViewModel(){


    fun getNotifications(): LiveData<List<Notification>>{
        return notificationRepository.getNotifications()
    }


    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


    fun addNotification(notification: Notification){

        viewModelScope.launch {
            notificationRepository.addNotification(notification)
        }

    }

}