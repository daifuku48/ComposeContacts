package com.danilkharytonov.composecontacts.di

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
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMainUserUseCase(get())
    }

    factory {
        SaveMainUserUseCase(get(), get())
    }

    factory {
        CheckingExistingUserUseCase(
            get()
        )
    }

    factory {
        EditProfileUseCase(get(), get())
    }

    factory {
        FilterContactsUseCase(get())
    }

    factory {
        SearchContactsUseCase(get())
    }

    factory {
        GetContactsUseCase(get())
    }

    factory {
        SaveContactUseCase(get())
    }

    factory {
        PagingContactsUseCase(get())
    }

    factory {
        DeleteUserUseCase(get())
    }

    factory {
        GetSubUserByIdUseCase(get())
    }
}