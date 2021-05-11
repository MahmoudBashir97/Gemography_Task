package com.mahmoudbashir.gemographytask.repository

import com.mahmoudbashir.gemographytask.pojo.Root
import retrofit2.Response

interface IRepository {
    suspend fun getTrendingList():Response<Root>
}