package com.example.baseproject.data.remote

import com.example.baseproject.data.remote.models.Match
import com.example.baseproject.util.BASE_URL
import retrofit2.http.GET

interface ApiService {

    @GET(BASE_URL)
    suspend fun getMatches(): List<Match>
}