package com.jjtech.myjetpackcompose.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import java.time.format.TextStyle

sealed class NavigationItem(var title: String, var icon: ImageVector, var route: String) {

    object Home : NavigationItem("Home", Icons.Default.Home, "home")
    object Profile : NavigationItem("Profile", Icons.Default.Person, "profile")
    object Settings : NavigationItem("Settings", Icons.Default.Settings, "settings")

}

@Composable
fun BottomNavigationBar(navHostController: NavHostController) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Settings,
    )

    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navHostController.navigate(item.route)
                },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.White
            )
        }
    }
}

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }

        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }

        composable(NavigationItem.Settings.route) {
            SettingScreen()
        }
    }
}


@Composable
fun HomeScreen() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Home", style = MaterialTheme.typography.h3)

    }
}

@Composable
fun ProfileScreen() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Profile", style = MaterialTheme.typography.h3)

    }
}

@Composable
fun SettingScreen() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Setting", style = MaterialTheme.typography.h3)

    }
}