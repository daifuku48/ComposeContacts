package com.danilkharytonov.composecontacts.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value.isLoading
        }

        setContent {
            val state by viewModel.uiState.collectAsState()
            DisposableEffect(Unit) {
                onDispose {
                    navigator.detach()
                }
            }
            ComposeContactsTheme {
                val navController = rememberNavController()
                navigator.attach(navController)
                state.startDestination?.let {
                    NavHost(
                        navController = navController,
                        startDestination = it
                    ) {
                        composable(route = Screen.CreateUserScreen.route) {
                            val createUserViewModel = getViewModel<CreateUserViewModel>()
                            CreateUser(createUserViewModel)
                        }

                        composable(route = Screen.UserScreen.route) {
                            val mainUserViewModel = getViewModel<MainUserViewModel>()
                            MainUserView(viewModel = mainUserViewModel)
                        }
                    }
                }
            }
        }
    }
}
