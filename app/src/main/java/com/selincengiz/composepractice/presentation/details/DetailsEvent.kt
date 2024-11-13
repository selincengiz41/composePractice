package com.selincengiz.composepractice.presentation.details

import com.selincengiz.composepractice.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(
        val article: Article,
    ) : DetailsEvent()

    data object ss : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()

    data object rer : DetailsEvent()

    data object fefe : DetailsEvent()
}
