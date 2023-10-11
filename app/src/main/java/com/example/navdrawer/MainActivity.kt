package com.example.navdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navdrawer.navigation.MainPage
import com.example.navdrawer.screens.about.AboutPage

import com.example.navdrawer.screens.home.FavsPage
import com.example.navdrawer.screens.home.HomePage
import com.example.navdrawer.screens.login.LoginPage
import com.example.navdrawer.screens.login_osc.LoginPageOSC
import com.example.navdrawer.screens.profile.ProfilePage
import com.example.navdrawer.screens.register.RegisterPage
import com.example.navdrawer.screens.register_osc.RegisterPageOSC
import com.example.navdrawer.screens.seguridad.SecurityPage
import com.example.navdrawer.screens.tags.TagsPage
import com.example.navdrawer.ui.theme.BlancoGris
import com.example.navdrawer.ui.theme.GrisClaro
import com.example.navdrawer.ui.theme.NavDrawerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavDrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BlancoGris),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: AppViewModel = viewModel()
                    val navController = rememberNavController()

                  /// viewModel.setLoggedIn()
                    NavHost(navController = navController, startDestination = if (viewModel.isUserLoggedIn()) "MainPage" else "LoginPage" ) {

                        composable("LoginPage") {
                            LoginPage(navController, viewModel){

                            }
                        }
                        composable("RegisterPage") {
                            RegisterPage(navController, viewModel)
                        }
                        composable("FavsPage") {
                            FavsPage(navController, viewModel)
                        }
                        composable("RegisterPageOSC") {
                            RegisterPageOSC(navController)
                        }
                        composable("HomePage") {
                            HomePage(navController,viewModel)
                        }
                        composable("TagsPage") {
                            TagsPage(navController)
                        }
                        composable("LoginPageOSC") {
                            LoginPageOSC(navController,viewModel)
                        }
                        composable("ProfilePage") {
                            ProfilePage(viewModel)
                        }
                        composable("SecurityPage") {
                            SecurityPage()
                        }

                        composable("MainPage") {
                            MainPage()
                        }

                        composable("AboutPage"+ "/{org}") {  backStackEntry ->
                            backStackEntry.arguments?.getString("org")
                                ?.let { AboutPage(it,navController) }
                        }
                    }

                /*     if (viewModel.isUserLoggedIn()) {
                        // El usuario está autenticado, cargar la página de inicio con el navigation drawer
                       // MainPage(navController)

                    } else {
                        // El usuario no está autenticado, cargar la página de inicio de sesión
                        LoginPage(navController = navController, viewModel)
                    }*/
                    // Después de que el usuario haya completado el inicio de sesión
                    //viewModel.setLoggedIn()
                    // ...

                /*    NavHost(navController = navController, startDestination = "HomePage") {
                        // Otras composable destinations aquí...

                        composable("HomePage") {
                            HomePage(navController, viewModel)
                        }

                        composable(
                            "AboutPage/{orgname}",
                            arguments = listOf(
                                navArgument("orgname") { // Definir el argumento orgname
                                    type = NavType.StringType
                                }
                            )
                        ) { navBackStackEntry ->
                            val orgname = navBackStackEntry.arguments?.getString("orgname")
                            AboutPage(orgname)
                        }
                    }*/

                }
            }
        }
    }
}



