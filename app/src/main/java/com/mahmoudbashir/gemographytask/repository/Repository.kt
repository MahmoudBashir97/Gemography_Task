package com.mahmoudbashir.gemographytask.repository

import com.mahmoudbashir.gemographytask.pojo.Root
import com.mahmoudbashir.gemographytask.retrofit.RetrofitInstance
import retrofit2.Response

// using Interface for overriding its method
class Repository : IRepository {
    // getting data from api by using Repository pattern

    override suspend fun getTrendingList(): Response<Root> =RetrofitInstance.api.getTrendingRepos()
}