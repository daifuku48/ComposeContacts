package com.danilkharytonov.composecontacts.presentation.base

sealed class Screen(val route: String){
    object UserScreen : Screen(MAIN_USER_SCREEN)
    object CreateUserScreen : Screen(CREATE_USER_SCREEN)

    companion object {
        const val MAIN_USER_SCREEN = "main_user_screen"
        const val CREATE_USER_SCREEN = "create_user_screen"
    }
}