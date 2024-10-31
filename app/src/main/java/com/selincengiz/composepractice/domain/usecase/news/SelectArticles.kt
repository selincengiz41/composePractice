package com.selincengiz.composepractice.domain.usecase.news

import com.selincengiz.composepractice.domain.model.Article
import com.selincengiz.composepractice.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository,
) {
    operator fun invoke(): Flow<List<Article>> = newsRepository.getArticles()
}
