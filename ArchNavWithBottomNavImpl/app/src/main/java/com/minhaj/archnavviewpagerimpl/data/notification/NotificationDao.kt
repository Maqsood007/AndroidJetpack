package com.minhaj.archnavviewpagerimpl.data.notification

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select
import org.jetbrains.annotations.NotNull

@Dao
interface NotificationDao {

    @Query("select * from notification")
    fun getAllNotification(): List<Notification>


    @Insert
    fun insertNotification(@NotNull notification: Notification): Long



    @Query("UPDATE notification SET image = :imageNew where id = :imageId")
    fun updateImage(imageNew: String, imageId : Long)

}