package com.minhaj.archnavviewpagerimpl.utilities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings.Global.getString
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavDeepLinkBuilder
import com.minhaj.archnavviewpagerimpl.R
import com.minhaj.archnavviewpagerimpl.TabbedActivity
import java.util.*

object NotificationUtils {


        fun triggerNotification(context: Context){

            val CHANNEL_ID = "NOTIFICATION_ID"

            // Create an explicit intent for an Activity in your app
            val intent = Intent(context, TabbedActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
//            val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.nav_tab_main)
                .setDestination(R.id.notificationFragment)
                .setArguments(null)
                .createPendingIntent()


            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_plus)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line..."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = context.getString(R.string.app_name)
                val descriptionText = "Much longer text that cannot fit one line..."
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)

                with(notificationManager) {
                    // notificationId is a unique int for each notification that you must define
                    notify((123 + System.currentTimeMillis()).toInt(), builder.build())
                }
            }



        }



}