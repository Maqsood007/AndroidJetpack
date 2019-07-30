package com.minhaj.archnavviewpagerimpl.data.notification

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class NotificationLocalRepository(val notificationDao: NotificationDao) {

    fun getNotifications(): LiveData<List<Notification>> = notificationDao.getAllNotification()

    suspend fun addNotification(notification: Notification) : Unit {

        withContext(IO){
            notificationDao.insertNotification(notification)
        }

    }


    companion object {

        @Volatile
        private var instance: NotificationLocalRepository? = null

        fun getInstance(notificationDao: NotificationDao): NotificationLocalRepository {

            return instance ?: synchronized(this) {
                instance ?: NotificationLocalRepository(notificationDao).also {
                    instance = it
                }
            }
        }

    }
}