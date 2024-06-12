package com.selincengiz.composepractice.domain.usecase.news

import androidx.paging.PagingData
import com.selincengiz.composepractice.domain.model.Article
import com.selincengiz.composepractice.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}