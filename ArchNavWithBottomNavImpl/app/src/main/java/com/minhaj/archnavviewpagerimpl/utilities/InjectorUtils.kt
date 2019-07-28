package com.minhaj.archnavviewpagerimpl.utilities

import com.minhaj.archnavviewpagerimpl.tabbed.repos.NotificationRepository
import com.minhaj.archnavviewpagerimpl.tabbed.viewmodels.NotificationViewModel
import com.minhaj.archnavviewpagerimpl.tabbed.viewmodels.NotificationViewModelFactory

object InjectorUtils {


    fun getNotificationRepository() : NotificationRepository{

        NotificationRepository().let {
            return it
        }
    }

    fun provideNotificationViewModel(): NotificationViewModelFactory{

        return NotificationViewModelFactory(getNotificationRepository())
    }

}