package com.danilkharytonov.composecontacts.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsView
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsViewModel
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileView
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    if (!state.isLoading) { //isLoading == false only is startDestination is init
                        splashScreen.setKeepOnScreenCondition { false }
                        setContent {
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
                                            val createUserViewModel =
                                                getViewModel<CreateUserViewModel>()
                                            CreateUser(viewModel = createUserViewModel)
                                        }

                                        composable(route = Screen.UserScreen.route) {
                                            val mainUserViewModel =
                                                getViewModel<MainUserViewModel>()
                                            MainUserView(viewModel = mainUserViewModel)
                                        }

                                        composable(route = Screen.EditProfileScreen.route) {
                                            val editProfileViewModel =
                                                getViewModel<EditProfileViewModel>()
                                            EditProfileView(viewModel = editProfileViewModel)
                                        }

                                        composable(route = Screen.ContactsScreen.route) {
                                            val contactsViewModel =
                                                getViewModel<ContactsViewModel>()
                                            ContactsView(viewModel = contactsViewModel)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val UPDATE_MAIN_USER = "UPDATE_MAIN_USER"
    }
}
