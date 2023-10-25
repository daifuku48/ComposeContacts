package com.danilkharytonov.composecontacts.presentation.base.navigation

import androidx.navigation.NavController

class AppNavigator(private val navController: NavController) : Navigator {
    override fun navigateTo(destination: String) {
        navController.navigate(destination)
    }
}