package com.danilkharytonov.composecontacts.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import com.danilkharytonov.composecontacts.presentation.navigation.Screen.Companion.MAIN_USER_SCREEN

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MAIN_USER_SCREEN) {
        composable(route = Screen.CreateUserScreen.route) {
            CreateUser()
        }

        composable(route = Screen.UserScreen.route) {
            val viewModel: MainUserViewModel = viewModel()
            MainUserView(viewModel)
        }
    }
}