package com.danilkharytonov.composecontacts.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import com.danilkharytonov.composecontacts.presentation.navigation.Screen.Companion.MAIN_USER_SCREEN
import org.koin.androidx.compose.getViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MAIN_USER_SCREEN) {
        composable(route = Screen.CreateUserScreen.route) {
            val viewModel = getViewModel<CreateUserViewModel>()
            viewModel.attachNavController(navController)
            CreateUser(viewModel)
        }

        composable(route = Screen.UserScreen.route) {
            val viewModel = getViewModel<MainUserViewModel>()
            viewModel.attachNavController(navController)
            MainUserView(viewModel = viewModel)
        }
    }
}