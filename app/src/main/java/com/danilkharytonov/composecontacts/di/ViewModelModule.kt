package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.domain.use_cases.main_activity.MainActivityReducer
import com.danilkharytonov.composecontacts.presentation.activity.MainViewModel
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactReducer
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactViewModel
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailReducer
import com.danilkharytonov.composecontacts.presentation.contact_detail_view.ContactDetailViewModel
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsReducer
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsViewModel
import com.danilkharytonov.domain.use_cases.create_user_view.CreateUserReducer
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.domain.use_cases.edit_profile_view.EditProfileReducer
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileViewModel
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserReducer
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import com.danilkharytonov.domain.use_cases.add_contacts_view.GetContactsUseCase
import com.danilkharytonov.domain.use_cases.add_contacts_view.PagingContactsUseCase
import com.danilkharytonov.domain.use_cases.add_contacts_view.SaveContactUseCase
import com.danilkharytonov.domain.use_cases.contact_detail_view.DeleteUserUseCase
import com.danilkharytonov.domain.use_cases.contact_detail_view.GetSubUserByIdUseCase
import com.danilkharytonov.domain.use_cases.contacts_view.FilterContactsUseCase
import com.danilkharytonov.domain.use_cases.contacts_view.SearchContactsUseCase
import com.danilkharytonov.domain.use_cases.create_user_view.SaveMainUserUseCase
import com.danilkharytonov.domain.use_cases.edit_profile_view.EditProfileUseCase
import com.danilkharytonov.domain.use_cases.main_activity.CheckingExistingUserUseCase
import com.danilkharytonov.domain.use_cases.main_user_view.GetMainUserUseCase
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