package com.loc.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.LocalUseCases
import com.loc.newsapp.presentation.nav_graph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: LocalUseCases
) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartGraph.route)
        private set

    init {
        appEntryUseCases.getBoolean().onEach {
            if (it) {
                startDestination = Route.NewsGraph.route
            } else {
                startDestination = Route.AppStartGraph.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}