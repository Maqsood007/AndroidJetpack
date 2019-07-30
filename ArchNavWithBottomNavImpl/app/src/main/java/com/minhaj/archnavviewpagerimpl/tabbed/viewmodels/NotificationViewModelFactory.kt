package com.minhaj.archnavviewpagerimpl.tabbed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhaj.archnavviewpagerimpl.data.notification.NotificationLocalRepository

class NotificationViewModelFactory (private val notificationRepository: NotificationLocalRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotificationViewModel(notificationRepository) as T
    }
}