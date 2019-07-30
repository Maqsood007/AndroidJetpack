package com.minhaj.archnavviewpagerimpl.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.minhaj.archnavviewpagerimpl.constants.Constants.Database.DATA_BASE_NAME
import com.minhaj.archnavviewpagerimpl.data.notification.Notification
import com.minhaj.archnavviewpagerimpl.data.notification.NotificationDao


@Database(entities = [Notification::class],version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao

    companion object{

        private var appDatabase : AppDatabase? =  null

         fun getInstance(context: Context) : AppDatabase{

            return appDatabase ?: synchronized(this){
                appDatabase ?: buildDatabase(context).also {
                    appDatabase = it
                }
            }
        }


        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATA_BASE_NAME)
                /*.addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })*/
                .build()
        }


    }
}