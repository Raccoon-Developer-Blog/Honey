package com.honey.feature.market

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

// Data model for a single honey offer
data class HoneyOffer(
    val id: String,
    val beekeeper: String,
    val type: String,
    val distance: String
)

// Two tabs: Map and List
enum class HomeTab(val title: String) { 
    Map("Map"), 
    List("List") 
}

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
                // Floating Action Button opens filter screen
                FloatingActionButton(onClick = onFilterClick) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            },
            bottomBar = {
                BottomAppBar { 
                    Spacer(Modifier.weight(1f))
                    // Button to navigate to favorites
                    IconButton(onClick = onFavoritesClick) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Favorites",
                            tint = Color(0xFF7A5F35)
                        )
                    }
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFFDF5F5))
            ) {
                // Tab row for Map and List views
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

                // Display content based on selected tab
                when (selectedTab) {
                    HomeTab.Map -> {
                        // Placeholder for the map
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Map Placeholder", color = Color.Gray)
                        }
                    }
                    HomeTab.List -> {
                        // List of honey offers
                        OfferList(
                            offers = offers,
                            onOfferClick = onOfferClick
                        )
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
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
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
                        text = offer.beekeeper,
                        fontSize = 18.sp,
                        color = Color(0xFF7A5F35)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = offer.type,
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