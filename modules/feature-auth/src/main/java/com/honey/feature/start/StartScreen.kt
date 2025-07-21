package com.honey.feature.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.honey.core.ui.theme.HoneyTheme

@Composable
fun StartScreen(
    onExploreGuest: () -> Unit,
    onSignIn: () -> Unit,
    onSignUp: () -> Unit
) {
    HoneyTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // App logo placeholder
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🍯",
                        fontSize = 32.sp
                    )
                }

                // App title
                Text(
                    text = "Honey",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7A5F35)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Tagline
                Text(
                    text = "Discover local honey & beekeepers",
                    fontSize = 16.sp,
                    color = Color(0xFF7A5F35).copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Explore as Guest button
                Button(
                    onClick = onExploreGuest,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA6D785)),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Explore as Guest",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Sign In button
                OutlinedButton(
                    onClick = onSignIn,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF7A5F35)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Sign Up link
                ClickableText(
                    text = AnnotatedString("Don't have an account? Sign Up"),
                    onClick = { onSignUp() },
                    modifier = Modifier.padding(top = 8.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color(0xFF7A5F35),
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
} 