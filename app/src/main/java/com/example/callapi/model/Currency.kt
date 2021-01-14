package com.example.callapi.model

data class Currency(
    val success: Boolean,
    val terms: String,
    val privacy: String,
    val timestamp: Float,
    val source: String,
    val quotes: Quotes
)