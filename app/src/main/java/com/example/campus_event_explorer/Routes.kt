package com.example.campus_event_explorer

import kotlinx.serialization.Serializable

@Serializable
data object EventList

@Serializable
data class EventDetail(
    val eventId: Long
)
