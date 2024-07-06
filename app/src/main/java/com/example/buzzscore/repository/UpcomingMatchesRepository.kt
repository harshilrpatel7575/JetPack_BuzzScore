package com.example.buzzscore.repository

import com.example.buzzscore.data.remote.models.ElenaApiService
import com.example.buzzscore.data.remote.models.Match
import javax.inject.Inject

class UpcomingMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService) {
    suspend fun getAllUpcomingMatches(): List<Match> = elenaApiService.getUpcomingMatches().data

}