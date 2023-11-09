package com.danilkharytonov.domain.di

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