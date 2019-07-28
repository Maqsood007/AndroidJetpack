package com.minhaj.archnavviewpagerimpl.tabbed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhaj.archnavviewpagerimpl.tabbed.repos.NotificationRepository

class NotificationViewModelFactory (private val notificationRepository: NotificationRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotificationViewModel(notificationRepository) as T
    }
}