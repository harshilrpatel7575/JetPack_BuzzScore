package com.example.buzzscore.data.remote.models

import com.example.buzzscore.util.API_TOKEN
import com.example.buzzscore.util.GET_MATCHES_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ElenaApiService {



    @GET(GET_MATCHES_ENDPOINT)
    suspend fun getMatches(
        @Query("apikey") apikey: String = API_TOKEN
    ): UpcomingMatchesResponse
}