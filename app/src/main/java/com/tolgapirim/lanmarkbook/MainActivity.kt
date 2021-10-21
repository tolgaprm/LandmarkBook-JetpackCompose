package com.tolgapirim.lanmarkbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.tolgapirim.lanmarkbook.ui.theme.LanmarkBookTheme
import com.tolgapirim.lanmarkbook.ui.theme.MainScreen
import com.tolgapirim.lanmarkbook.ui.theme.screen.DetailScreen


const val MAINSCREEN = "mainScreen"
const val DETAILSCREEN = "detailScreen/{image}/{name}/{country}"

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LanmarkBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MAINSCREEN) {
        composable(MAINSCREEN) {
            MainScreen(navController = navController)

        }

        composable(
            DETAILSCREEN,
            arguments = listOf(
                navArgument("image") { type = NavType.IntType},
                navArgument("name"){ type =  NavType.StringType},
                navArgument("country"){ type =  NavType.StringType}
            )

        ) {
            DetailScreen(
                navController = navController,
                it.arguments?.getInt("image")!!,
                it.arguments?.getString("name")!!,
                it.arguments?.getString("country")!!
                )


        }
    }


}
