package com.selincengiz.composepractice.domain.usecase.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val deleteArticle: DeleteArticle,
    val upsertArticle: UpsertArticle,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)
