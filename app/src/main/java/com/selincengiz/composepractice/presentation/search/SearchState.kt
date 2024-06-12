package com.selincengiz.composepractice.presentation.search

import androidx.paging.PagingData
import com.selincengiz.composepractice.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)
