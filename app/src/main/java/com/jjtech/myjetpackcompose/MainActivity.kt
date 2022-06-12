package com.jjtech.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.jjtech.myjetpackcompose.ui.components.BottomNavigationBar
import com.jjtech.myjetpackcompose.ui.components.JetpackComposeAppbar
import com.jjtech.myjetpackcompose.ui.components.Navigation
import com.jjtech.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { JetpackComposeAppbar(title = "Jetpack Compose App") },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        Navigation(navHostController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyJetpackComposeTheme {
        MainScreen()
    }
}