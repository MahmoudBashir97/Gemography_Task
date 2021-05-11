package com.mahmoudbashir.gemographytask.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.gemographytask.pojo.Root
import com.mahmoudbashir.gemographytask.repository.Repository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class TrendingViewModel(app:Application,private val repo:Repository):AndroidViewModel(app) {

    // getting data from api by using Repository pattern
    suspend fun getTrendingList(): Response<Root>{
        return repo.getTrendingList()
    }
}