package com.selincengiz.composepractice.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selincengiz.composepractice.domain.usecase.app_entry.AppEntryUseCase
import com.selincengiz.composepractice.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase,
) : ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCase
            .readAppEntry()
            .onEach { shouldStartFromHomeScreen ->
                startDestination =
                    if (shouldStartFromHomeScreen) {
                        Route.NewsNavigation.route
                    } else {
                        Route.AppStartNavigation.route
                    }
                delay(300)
                splashCondition = false
            }.launchIn(viewModelScope)
    }
}
