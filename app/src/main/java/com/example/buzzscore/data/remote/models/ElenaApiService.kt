package com.example.buzzscore.data.remote.models

import com.example.buzzscore.util.GET_INPLAY_FIXTURES
import retrofit2.http.GET

interface ElenaApiService {

    @GET(GET_INPLAY_FIXTURES)
    suspend fun getInplayMatches(): InplayMatchesResponse
}