package com.minhaj.archnavviewpagerimpl.data.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notification")
data class Notification(

    val notificationId: Int,
    val title : String,
    val image: String,
    val message: String

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")//specify if you want to have different column name, and data field name.
    var id: Long = 0
}