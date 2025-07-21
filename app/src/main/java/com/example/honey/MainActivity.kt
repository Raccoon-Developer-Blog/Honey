package com.honey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honey.core.ui.theme.HoneyTheme
import com.honey.feature.start.StartScreen
import com.honey.feature.market.HomeScreen
import com.honey.feature.market.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            StartScreen(
                onExploreGuest = { navController.navigate("home") },
                onSignIn = { /* TODO: Navigate to sign in */ },
                onSignUp = { /* TODO: Navigate to sign up */ }
            )
        }
        composable("home") {
            HomeScreen(
                offers = SampleData.honeyOffers,
                onOfferClick = { _ -> 
                    /* TODO: Navigate to offer details */
                },
                onFilterClick = { 
                    /* TODO: Navigate to filter screen */
                },
                onFavoritesClick = { 
                    /* TODO: Navigate to favorites */
                }
            )
        }
    }
}