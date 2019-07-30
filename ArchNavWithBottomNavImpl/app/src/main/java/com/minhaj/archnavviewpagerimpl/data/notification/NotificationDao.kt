package com.minhaj.archnavviewpagerimpl.data.notification

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface NotificationDao {

    @Query("select * from notification")
    fun getAllNotification(): LiveData<List<Notification>>


    @Insert
    fun insertNotification(notification: Notification): Long

}