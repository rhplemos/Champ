package com.example.baseproject.data.remote.models

data class Filters(
    val dateFrom: String,
    val dateTo: String,
    val permission: String
)

data class ResultSet(
    val count: Int,
    val competitions: String,
    val first: String,
    val last: String,
    val played: Int
)

data class Area(
    val id: Int,
    val name: String,
    val code: String,
    val flag: String
)

data class Competition(
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String
)

data class Season(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int,
    val winner: Any? // Pode ser nulo, pois o vencedor pode não estar definido
)

data class HomeTeam(
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String?, // Pode ser nulo
    val crest: String
)

data class AwayTeam(
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String?, // Pode ser nulo
    val crest: String
)

data class Score(
    val winner: String,
    val duration: String,
    val fullTime: FullTime,
    val halfTime: HalfTime
)

data class FullTime(
    val home: Int,
    val away: Int
)

data class HalfTime(
    val home: Int,
    val away: Int
)

data class Odds(
    val msg: String
)

data class Match(
    val area: Area,
    val competition: Competition,
    val season: Season,
    val id: Int,
    val utcDate: String,
    val status: String,
    val matchday: Int,
    val stage: String,
    val group: Any?,
    val lastUpdated: String,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val score: Score,
    val odds: Odds,
)

data class FootballDataResponse(
    val filters: Filters,
    val resultSet: ResultSet,
    val matches: List<Match>
)
