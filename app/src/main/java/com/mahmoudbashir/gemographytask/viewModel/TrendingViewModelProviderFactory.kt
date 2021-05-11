package com.mahmoudbashir.gemographytask.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahmoudbashir.gemographytask.repository.Repository

class TrendingViewModelProviderFactory(val app : Application,
private val repo:Repository)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = TrendingViewModel(app,repo) as T

}