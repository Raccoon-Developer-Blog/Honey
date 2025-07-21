package com.honey.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.honey.core.ui.theme.HoneyTheme
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.DarkMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(
    username: String,
    email: String,
    isDarkMode: Boolean,
    currentLanguage: String,
    notificationsEnabled: Boolean,
    onToggleDarkMode: () -> Unit,
    onChangeLanguage: () -> Unit,
    onToggleNotifications: () -> Unit,
    onEditProfile: () -> Unit,
    onBack: () -> Unit
) {
    HoneyTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Profile") },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Username & Email
                Text(username, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7A5F35))
                Text(email, fontSize = 14.sp, color = Color.Gray)

                // Edit profile button
                OutlinedButton(onClick = onEditProfile) {
                    Text("Edit Profile")
                }

                Divider()

                // Language toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Language, contentDescription = null)
                    Spacer(Modifier.width(12.dp))
                    Text("Language", modifier = Modifier.weight(1f))
                    TextButton(onClick = onChangeLanguage) {
                        Text(currentLanguage.uppercase())
                    }
                }

                // Dark mode switch
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.DarkMode, contentDescription = null)
                    Spacer(Modifier.width(12.dp))
                    Text("Dark Mode", modifier = Modifier.weight(1f))
                    Switch(checked = isDarkMode, onCheckedChange = { onToggleDarkMode() })
                }

                // Notification switch
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Notifications, contentDescription = null)
                    Spacer(Modifier.width(12.dp))
                    Text("Notifications", modifier = Modifier.weight(1f))
                    Switch(checked = notificationsEnabled, onCheckedChange = { onToggleNotifications() })
                }
            }
        }
    }
} 