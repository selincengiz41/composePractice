package com.selincengiz.composepractice.domain.usecase.news

import com.selincengiz.composepractice.domain.model.Article
import com.selincengiz.composepractice.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(url: String): Article? = newsRepository.getArticle(url)
}
