package com.danilkharytonov.composecontacts.presentation.activity

import android.Manifest.permission
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUser
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserView
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        checkStoragePermission()
        setContent {
            ComposeContactsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = viewModel.getDestination()
                ) {
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
        }
    }

    private fun checkStoragePermission() {
        if (ActivityCompat.checkSelfPermission(this, permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(permission.READ_MEDIA_IMAGES),
                    STORAGE_PERMISSION_CODE
                )
            }
        }
    }

    companion object {
        const val STORAGE_PERMISSION_CODE = 1
    }
}
