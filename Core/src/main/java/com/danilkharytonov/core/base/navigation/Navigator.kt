package com.danilkharytonov.core.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface Navigator {

    fun attach(navController: NavController)

    fun navigateTo(destination: String, navOptions: NavOptions? = null)

    fun pop()

    fun detach()
}