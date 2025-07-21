package com.example.honey

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.honey.core.ui.theme.HoneyTheme

/**
 * Data model representing a single honey offer.
 */
data class HoneyOffer(
    val id: String,
    val producerName: String,
    val honeyType: String,
    val distance: String
)

/**
 * Two tabs for the Home screen: Map view and List view.
 */
enum class HomeTab(val title: String) { Map("Map"), List("List") }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    offers: List<HoneyOffer>,
    onOfferClick: (HoneyOffer) -> Unit,
    onFilterClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    HoneyTheme {
        var selectedTab by remember { mutableStateOf(HomeTab.Map) }

        Scaffold(
            floatingActionButton = {
                // FAB to open the filter screen
                FloatingActionButton(onClick = onFilterClick) {
                    Icon(Icons.Filled.Search, contentDescription = "Open filters")
                }
            },
            bottomBar = {
                BottomAppBar {
                    Spacer(Modifier.weight(1f))
                    // Button to navigate to Favorites screen
                    IconButton(onClick = onFavoritesClick) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Go to favorites",
                            tint = Color(0xFF7A5F35)
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color(0xFFFDF5F5))
            ) {
                // Tab row switching between map and list
                TabRow(
                    selectedTabIndex = selectedTab.ordinal,
                    containerColor = Color(0xFFFDF5F5),
                    contentColor = Color(0xFF7A5F35)
                ) {
                    HomeTab.values().forEachIndexed { index, tab ->
                        Tab(
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            text = { Text(tab.title, fontSize = 16.sp) }
                        )
                    }
                }

                // Show content based on current tab
                when (selectedTab) {
                    HomeTab.Map -> {
                        // Placeholder for a map composable
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Map view placeholder", color = Color.Gray)
                        }
                    }
                    HomeTab.List -> {
                        // Lazy list of honey offers
                        OfferList(offers = offers, onOfferClick = onOfferClick)
                    }
                }
            }
        }
    }
}

@Composable
private fun OfferList(
    offers: List<HoneyOffer>,
    onOfferClick: (HoneyOffer) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(offers, key = { it.id }) { offer ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOfferClick(offer) },
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = offer.producerName,
                        fontSize = 18.sp,
                        color = Color(0xFF7A5F35)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = offer.honeyType,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = offer.distance,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
} 