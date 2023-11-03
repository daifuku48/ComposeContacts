package com.danilkharytonov.composecontacts.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


abstract class BaseViewModel<Event : UiEvent, State : UiState>(
    private val reducer: Reducer<State, Event>,
    private val useCase: List<UseCase<State, Event>>,
    private val appNavigator: Navigator
) : ViewModel() {

    private val initialState: State by lazy {
        createInitialState()
    }

    abstract fun createInitialState(): State

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _uiEvents: MutableList<Event> = arrayListOf()

    protected abstract fun handleSpecialEvent(event: Event)

    protected fun addSpecialEvent(event: Event) {
        _uiEvents.add(event)
    }

    protected fun navigate(destination: String, navOptions: NavOptions? = null) {
        appNavigator.navigateTo(destination, navOptions)
    }

    protected fun popBackStack() {
        appNavigator.pop()
    }

    protected fun handleEvent(event: Event) {
        _uiState.update { reducer.reduce(state = uiState.value, event = event) }
        if (_uiEvents.contains(event)) {
            handleSpecialEvent(event)
        }
        useCase.filter { it.canHandle(event) }.forEach { useCase ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.execute(uiState.value, event)
                withContext(Dispatchers.Main ) {
                    handleEvent(result)
                }
            }
        }
    }
}