package com.selincengiz.composepractice.data.remote.dto

import com.selincengiz.composepractice.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int,
)
