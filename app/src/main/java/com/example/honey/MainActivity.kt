package com.example.honey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.honey.core.ui.theme.HoneyTheme
import com.honey.feature.start.StartScreen
import com.example.honey.HomeScreen
import com.example.honey.OfferDetailScreen
import com.example.honey.OfferDetail
import com.example.honey.sampleHoneyOffers
import com.honey.feature.order.PreOrderScreen
import com.honey.feature.order.DeliveryMethod
import androidx.compose.runtime.mutableStateListOf
import com.honey.feature.auth.SignInScreen
import com.honey.feature.auth.SignUpScreen
import com.honey.feature.profile.UserProfileScreen
import com.honey.feature.profile.EditProfileScreen

class MainActivity : ComponentActivity() {
    private val favoriteIds = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(navController = navController, favoriteIds = favoriteIds)
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, favoriteIds: MutableList<String>) {
    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            StartScreen(
                onExploreGuest = {
                    navController.navigate("home") {
                        popUpTo("start") { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onSignIn = { navController.navigate("signin") },
                onSignUp = { navController.navigate("signup") }
            )
        }
        composable("signin") {
            SignInScreen(
                onBack = { navController.popBackStack() },
                onSubmit = { email, password -> /* TODO: Handle sign in */ },
                onForgotPassword = { /* TODO: Handle forgot password */ },
                onSignUp = { navController.navigate("signup") }
            )
        }
        composable("signup") {
            SignUpScreen(
                onBack = { navController.popBackStack() },
                onSubmit = { name, email, password -> /* TODO: Handle sign up */ },
                onSignIn = { navController.navigate("signin") }
            )
        }
        composable("home") {
            HomeScreen(
                offers = sampleHoneyOffers,
                onOfferClick = { offer ->
                    navController.navigate("offerDetail/${offer.id}")
                },
                onFilterClick = { /* TODO: Navigate to filter screen */ },
                onFavoritesClick = { /* TODO: Navigate to favorites */ },
                onProfileClick = { navController.navigate("profile") }
            )
        }
        composable("profile") {
            UserProfileScreen(
                username = "Jane Doe",
                email = "jane@example.com",
                isDarkMode = false,
                currentLanguage = "EN",
                notificationsEnabled = true,
                onToggleDarkMode = { /* TODO: Toggle dark mode */ },
                onChangeLanguage = { /* TODO: Change language */ },
                onToggleNotifications = { /* TODO: Toggle notifications */ },
                onEditProfile = { navController.navigate("editProfile") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("editProfile") {
            EditProfileScreen(
                currentName = "Jane Doe",
                currentBio = "Organic beekeeper in Bavaria",
                onBack = { navController.popBackStack() },
                onSubmit = { newName, newBio -> navController.popBackStack() }
            )
        }
        composable(
            route = "offerDetail/{offerId}",
            arguments = listOf(navArgument("offerId") { type = NavType.StringType })
        ) { backStack ->
            val id = backStack.arguments?.getString("offerId")!!
            val offer = sampleHoneyOffers.find { it.id == id }?.let {
                OfferDetail(
                    id = it.id,
                    producerName = it.producerName,
                    honeyType = it.honeyType,
                    pricePerKg = "20", // Demo value
                    availableKg = "10",    // Demo value
                    description = "Delicious local honey from ${it.producerName}.",
                    isFavorite = favoriteIds.contains(it.id)
                )
            }
            if (offer != null) {
                OfferDetailScreen(
                    offer = offer,
                    onBack = { navController.popBackStack() },
                    onPreOrder = { offerId ->
                        navController.navigate("preOrder/${offer.id}/${offer.pricePerKg}/${offer.availableKg}")
                    },
                    onToggleFavorite = { offerId ->
                        if (favoriteIds.contains(offerId)) favoriteIds.remove(offerId)
                        else favoriteIds.add(offerId)
                    }
                )
            } else {
                Text("Offer not found", color = Color.Red)
            }
        }
        composable(
            route = "preOrder/{offerId}/{pricePerKg}/{availableKg}",
            arguments = listOf(
                navArgument("offerId") { type = NavType.StringType },
                navArgument("pricePerKg") { type = NavType.StringType },
                navArgument("availableKg") { type = NavType.StringType }
            )
        ) { backStack ->
            val offerId = backStack.arguments?.getString("offerId")!!
            val pricePerKg = backStack.arguments?.getString("pricePerKg")!!
            val availableKg = backStack.arguments?.getString("availableKg")!!
            PreOrderScreen(
                offerId = offerId,
                pricePerKg = pricePerKg,
                availableKg = availableKg,
                onBack = { navController.popBackStack() },
                onConfirmOrder = { id, qty, method, comment ->
                    // TODO: Handle order confirmation
                    navController.popBackStack()
                }
            )
        }
    }
}