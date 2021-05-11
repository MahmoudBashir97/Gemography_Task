package com.mahmoudbashir.gemographytask.retrofit

import com.mahmoudbashir.gemographytask.pojo.Root
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("search/repositories?q=created:>2017-10-22&sort=stars&order=desc")
    suspend fun getTrendingRepos():Response<Root>
}