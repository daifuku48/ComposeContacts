package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.presentation.activity.MainActivityReducer
import com.danilkharytonov.composecontacts.presentation.activity.MainViewModel
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactReducer
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactViewModel
import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailReducer
import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailViewModel
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsReducer
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsViewModel
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserReducer
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileReducer
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserReducer
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import com.danilkharytonov.composecontacts.presentation.add_contacts.use_cases.GetContactsUseCase
import com.danilkharytonov.composecontacts.presentation.add_contacts.use_cases.PagingContactsUseCase
import com.danilkharytonov.composecontacts.presentation.add_contacts.use_cases.SaveContactUseCase
import com.danilkharytonov.composecontacts.presentation.contact_detail.use_cases.DeleteUserUseCase
import com.danilkharytonov.composecontacts.presentation.contact_detail.use_cases.GetSubUserByIdUseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.use_cases.FilterContactsUseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.use_cases.SearchContactsUseCase
import com.danilkharytonov.composecontacts.presentation.create_user_view.use_cases.SaveMainUserUseCase
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.use_cases.EditProfileUseCase
import com.danilkharytonov.composecontacts.presentation.activity.use_cases.CheckingExistingUserUseCase
import com.danilkharytonov.composecontacts.presentation.main_user_view.use_cases.GetMainUserUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainUserViewModel(
            reducer = MainUserReducer(),
            useCases = listOf(get<GetMainUserUseCase>()),
            appNavigator = get()
        )
    }

    viewModel {
        CreateUserViewModel(
            reducer = CreateUserReducer(),
            useCases = listOf(get<SaveMainUserUseCase>()),
            appNavigator = get()
        )
    }

    viewModel {
        MainViewModel(
            reducer = MainActivityReducer(),
            useCases = listOf(get<CheckingExistingUserUseCase>()),
            appNavigator = get()
        )
    }

    viewModel {
        EditProfileViewModel(
            reducer = EditProfileReducer(),
            useCases = listOf(get<EditProfileUseCase>()),
            appNavigator = get()
        )
    }

    viewModel {
        ContactsViewModel(
            reducer = ContactsReducer(),
            useCases = listOf(get<FilterContactsUseCase>(), get<SearchContactsUseCase>()),
            appNavigator = get()
        )
    }

    viewModel {
        AddContactViewModel(
            reducer = AddContactReducer(),
            useCases = listOf(
                get<GetContactsUseCase>(),
                get<PagingContactsUseCase>(),
                get<SaveContactUseCase>()
            ),
            appNavigator = get()
        )
    }

    viewModel {
        ContactDetailViewModel(
            reducer = ContactDetailReducer(),
            useCases = listOf(get<DeleteUserUseCase>(), get<GetSubUserByIdUseCase>()),
            appNavigator = get()
        )
    }
}