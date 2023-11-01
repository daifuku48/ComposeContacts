package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.domain.use_cases.contacts_view.ContactsUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class ContactsViewModel(
    reducer: ContactsReducer,
    useCases: List<ContactsUseCase>,
    appNavigator: Navigator
) : BaseViewModel<ContactsEvent, ContactsState>(reducer,useCases, appNavigator) {
    override fun createInitialState(): ContactsState {
        TODO("Not yet implemented")
    }

    override fun handleSpecialEvent(event: ContactsEvent) {
        TODO("Not yet implemented")
    }
}