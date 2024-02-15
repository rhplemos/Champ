package com.example.baseproject.repository

import com.example.baseproject.data.remote.ApiService
import com.example.baseproject.data.remote.models.Match
import javax.inject.Inject

class MatchesRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMatches(): List<Match> = apiService.getMatches()
}