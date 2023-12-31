package com.danilkharytonov.domain.model

sealed class Screen(val route: String) {
    object UserScreen : Screen(MAIN_USER_SCREEN)
    object CreateUserScreen : Screen(CREATE_USER_SCREEN)
    object EditProfileScreen : Screen(EDIT_PROFILE_SCREEN)
    object ContactsScreen : Screen(CONTACTS_SCREEN)
    object AddContactScreen : Screen(ADD_CONTACT_SCREEN)
    object ContactDetailScreen : Screen(CONTACT_DETAIL_SCREEN)
    companion object {
        const val MAIN_USER_SCREEN = "main_user_screen"
        const val CREATE_USER_SCREEN = "create_user_screen"
        const val EDIT_PROFILE_SCREEN = "edit_profile_screen"
        const val CONTACTS_SCREEN = "contacts_screen"
        const val ADD_CONTACT_SCREEN = "add_contact_screen"
        const val CONTACT_DETAIL_SCREEN = "contact_detail_screen"
    }
}
