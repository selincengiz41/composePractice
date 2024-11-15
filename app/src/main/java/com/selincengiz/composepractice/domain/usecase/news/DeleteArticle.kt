package com.selincengiz.composepractice.domain.usecase.news

import com.selincengiz.composepractice.domain.model.Article
import com.selincengiz.composepractice.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}
