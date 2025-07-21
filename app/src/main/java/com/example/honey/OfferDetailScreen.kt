package com.example.honey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.honey.core.ui.theme.HoneyTheme

// Detailed data model for a honey offer
data class OfferDetail(
    val id: String,
    val producerName: String,
    val honeyType: String,
    val pricePerKg: String,
    val availableKg: String,
    val description: String,
    val isFavorite: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferDetailScreen(
    offer: OfferDetail,
    onBack: () -> Unit,
    onPreOrder: (String) -> Unit,
    onToggleFavorite: (String) -> Unit
) {
    HoneyTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text(text = offer.producerName, fontSize = 20.sp) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        // Favorite toggle
                        IconButton(onClick = { onToggleFavorite(offer.id) }) {
                            Icon(
                                imageVector = if (offer.isFavorite) Icons.Filled.Favorite
                                               else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Toggle Favorite",
                                tint = Color(0xFF7A5F35)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xFFFDF5F5),
                        titleContentColor = Color(0xFF7A5F35)
                    )
                )
            },
            bottomBar = {
                // Pre-order button at bottom
                Button(
                    onClick = { onPreOrder(offer.id) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA6D785))
                ) {
                    Text("Pre-order (${offer.pricePerKg} per kg)", color = Color.White, fontSize = 16.sp)
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color(0xFFFDF5F5))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Product image placeholder
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFF5E9B9)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Image", color = Color(0xFF7A5F35), fontSize = 18.sp)
                }

                // Honey type
                Text(
                    text = offer.honeyType,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF7A5F35)
                )

                // Price & availability
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Price: ${offer.pricePerKg}/kg",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Available: ${offer.availableKg} kg",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                // Description
                Text(
                    text = offer.description,
                    fontSize = 14.sp,
                    color = Color(0xFF7A5F35)
                )
            }
        }
    }
} 