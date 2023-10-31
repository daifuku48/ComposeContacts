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
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.getViewModel
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
                    var startDestination = ""
                    if (state.userIsExist != null) {
                        startDestination = if (state.userIsExist) {
                            Screen.UserScreen.route
                        } else {
                            Screen.CreateUserScreen.route
                        }
                        splashScreen.setKeepOnScreenCondition { false }
                    }
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
                                startDestination = startDestination
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
    }
}
