package com.minhaj.archnavviewpagerimpl.utilities

import android.content.Context
import com.minhaj.archnavviewpagerimpl.data.AppDatabase
import com.minhaj.archnavviewpagerimpl.data.notification.NotificationLocalRepository
import com.minhaj.archnavviewpagerimpl.tabbed.viewmodels.NotificationViewModel
import com.minhaj.archnavviewpagerimpl.tabbed.viewmodels.NotificationViewModelFactory

object InjectorUtils {


    fun getNotificationRepository(context: Context) : NotificationLocalRepository{
        return NotificationLocalRepository.getInstance(AppDatabase.getInstance(context).notificationDao())
    }

    fun provideNotificationViewModel(context: Context): NotificationViewModelFactory{
        return NotificationViewModelFactory(getNotificationRepository(context))
    }

}