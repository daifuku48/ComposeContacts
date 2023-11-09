package com.danilkharytonov.composecontacts.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactView
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.contact_detail_view.ContactDetailView
import com.danilkharytonov.composecontacts.presentation.contact_detail_view.ContactDetailViewModel
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsView
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsViewModel
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileView
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import com.danilkharytonov.domain.model.Screen
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModel<MainViewModel>()
        installSplashScreen()
        setContent {
            DisposableEffect(Unit) {
                onDispose {
                    navigator.detach()
                }
            }
            ComposeContactsTheme {
                val navController = rememberNavController()
                navigator.attach(navController)
                NavHost(
                    navController = navController,
                    startDestination = viewModel.getDestination()
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

                    composable(route = Screen.AddContactScreen.route) {
                        val addContactViewModel =
                            getViewModel<AddContactViewModel>()
                        AddContactView(viewModel = addContactViewModel)
                    }

                    composable(
                        route = Screen.ContactDetailScreen.route + "/{$USER_ID}",
                        arguments = listOf(navArgument("USER_ID") {
                            defaultValue = "0"
                        })
                    ) { backStackEntry ->
                        val contactDetailViewModel =
                            getViewModel<ContactDetailViewModel>()
                        backStackEntry.arguments?.getString(USER_ID)
                            ?.let { userId ->
                                ContactDetailView(
                                    viewModel = contactDetailViewModel,
                                    userId
                                )
                            }
                    }
                }
            }
        }
    }

    companion object {
        const val UPDATE_MAIN_USER = "UPDATE_MAIN_USER"
        const val LOAD_CONTACT_USER = "LOAD_CONTACT_USER"
        const val USER_ID = "user_id"
    }
}


