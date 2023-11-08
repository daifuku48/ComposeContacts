package com.danilkharytonov.composecontacts.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.core.base.UiEvent
import com.danilkharytonov.core.base.UiState
import com.danilkharytonov.core.base.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<Event : UiEvent, State : UiState, UiModel>(
    private val reducer: Reducer<State, Event>,
    private val useCase: List<UseCase<State, Event>>,
    private val appNavigator: Navigator
) : ViewModel() {
    abstract val uiModel: UiModel

    private val initialState: State by lazy {
        createInitialState()
    }

    abstract fun createInitialState(): State

    protected val uiState: MutableState<State> = mutableStateOf(initialState)
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
        uiState.value = reducer.reduce(state = uiState.value, event = event)
        if (_uiEvents.contains(event)) {
            handleSpecialEvent(event)
        }
        useCase.filter { it.canHandle(event) }.forEach { useCase ->
            viewModelScope.launch(Dispatchers.IO) {
                val result = useCase.execute(uiState.value, event)
                withContext(Dispatchers.Main) {
                    handleEvent(result)
                }
            }
        }
    }
}