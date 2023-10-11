package com.example.navdrawer.navigation

import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navdrawer.AppViewModel
import com.example.navdrawer.R
import com.example.navdrawer.screens.about.AboutPage
import com.example.navdrawer.screens.home.FavsPage

import com.example.navdrawer.screens.home.HomePage
import com.example.navdrawer.screens.login.LoginPage
import com.example.navdrawer.screens.posts.PostsPage
import com.example.navdrawer.screens.profile.ProfilePage
import com.example.navdrawer.screens.register.RegisterPage
import com.example.navdrawer.screens.seguridad.SecurityPage
import com.example.navdrawer.screens.tags.TagsPage
import com.example.navdrawer.ui.theme.BlancoGris
import com.example.navdrawer.ui.theme.RojoFrisa


import kotlinx.coroutines.launch



data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
    val route: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    var isSearchViewOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val viewModel: AppViewModel = viewModel()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val userLoggedIn = viewModel.isUserLoggedIn()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(-1) // -1 means no item is selected
    }

    val items = listOf(
        NavigationItem(
            title = "Inicio",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "HomePage"
        ),
        NavigationItem(
            title = "Ver Perfil",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = "ProfilePage"
        ),
        NavigationItem(
            title = "Tags",
            selectedIcon = Icons.Filled.AddCircle,
            unselectedIcon = Icons.Outlined.AddCircle,
            route = "TagsPage"
        ),
        NavigationItem(
            title = "Favoritos",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            route = "FavsPage"
        ),

        NavigationItem(
            title = "Posts",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox,
            route = "PostsPage"
        ),
        NavigationItem(
            title = "Seguridad",
            selectedIcon = Icons.Filled.Lock,
            unselectedIcon = Icons.Outlined.Lock,
            route = "SecurityPage"

        ),
    )

    ModalNavigationDrawer(drawerContent = {

        ModalDrawerSheet(drawerContainerColor = BlancoGris) {

            Spacer(modifier = Modifier
                .height(16.dp)
                .background(BlancoGris))

            items.forEachIndexed { index, item ->
                NavigationDrawerItem(
                    label = {
                        Text(text = item.title, color = Color.Black)
                    },
                    selected = index == selectedItemIndex,
                    onClick = {
                        navController.navigate(item.route)
                        selectedItemIndex = index
                        scope.launch {
                            drawerState.close()
                        }

                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title,
                            tint = Color(0xFFE7182E)
                        )
                    },
                    badge = {
                        item.badgeCount?.let {
                            Text(text = item.badgeCount.toString())
                        }
                    },
                    modifier = Modifier
                        .padding(NavigationDrawerItemDefaults.ItemPadding)
                        .background(BlancoGris),
                )
            }
        }
    }, drawerState = drawerState) {
        Scaffold(
            containerColor = BlancoGris,
            modifier = Modifier.background(BlancoGris),
            topBar = {
                // Mover el TopAppBar aquí para que esté siempre presente
                TopAppBar(
                    modifier = Modifier
                        .background(BlancoGris),
                    title = {
                            Image(
                                painter = painterResource(id = R.drawable.logo3),
                                contentDescription = "Logo de Frisa",
                                modifier = Modifier
                                    .height(40.dp)
                                    .offset(x = (110.dp))
                                    .width(30.dp)
                                    //.background(BlancoGris)
                            )
                    },

                    navigationIcon = {
                        IconButton(onClick = {
                            if (drawerState.isClosed) {
                                scope.launch {
                                    drawerState.open()
                                }
                            } else {
                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "Drawer Menu.",
                                tint = Color(0xFFE7182E)
                            )
                        }
                    },


                    actions = {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search.",
                                tint = Color(0xFFE7182E)
                            )
                        }
                    }
                )
            }
        ) {
            Box(modifier = Modifier
                .padding(it)
                .background(BlancoGris)) {
                NavHost(navController = navController, startDestination = "HomePage") {

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
                    composable("HomePage") {
                        HomePage(navController, viewModel)
                    }
                    composable("TagsPage") {
                        TagsPage(navController)
                    }
                    composable("ProfilePage") {
                        ProfilePage(viewModel)
                    }
                    composable("SecurityPage") {
                        SecurityPage()
                    }

                    composable("PostsPage") {
                        PostsPage()
                    }

                    composable("MainPage") {
                        MainPage()
                    }

                    composable("AboutPage" + "/{org}") { backStackEntry ->
                        backStackEntry.arguments?.getString("org")
                            ?.let { AboutPage(it, navController) }
                    }
                    }
                }
            }
    }
}