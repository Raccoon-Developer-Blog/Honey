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
import androidx.navigation.compose.rememberNavController
import com.honey.core.ui.theme.HoneyTheme
import com.honey.feature.start.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoneyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    Box(modifier = Modifier.padding(innerPadding)) {
                                            StartScreen(
                        onExploreGuest = { /* TODO: Navigate to guest mode */ },
                        onSignIn = { /* TODO: Navigate to sign in */ },
                        onSignUp = { /* TODO: Navigate to sign up */ }
                    )
                    }
                }
            }
        }
    }
}