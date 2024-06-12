package com.selincengiz.composepractice.domain.usecase.news

import com.selincengiz.composepractice.data.local.NewsDao
import com.selincengiz.composepractice.domain.model.Article
import com.selincengiz.composepractice.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticles()
    }
}