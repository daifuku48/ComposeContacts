package com.danilkharytonov.composecontacts.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


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

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    init {
        subscribeEvents()
    }

    protected fun navigate(destination: String) {
        appNavigator.navigateTo(destination)
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    protected fun handleEvent(event: Event) {
        _uiState.update { reducer.reduce(state = uiState.value, event = event) }
        useCase.filter { it.canHandle(event) }.forEach { useCase ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.execute(uiState.value, event)
                handleEvent(result)
            }
        }
    }

    fun setEvent(event: Event) {
        val newEvent = event
        viewModelScope.launch {
            _event.emit(newEvent)
        }
    }

    protected fun setState(state: State) {
        _uiState.value = state
    }
}