package com.example.buzzscore.repository

import com.example.buzzscore.data.remote.models.ElenaApiService
import com.example.buzzscore.data.remote.models.Match
import javax.inject.Inject

class InplayMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService) {
    suspend fun getAllInPlayMatches(): List<Match> = elenaApiService.getInplayMatches().data

}