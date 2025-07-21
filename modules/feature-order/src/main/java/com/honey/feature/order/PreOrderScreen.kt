package com.honey.feature.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.honey.core.ui.theme.HoneyTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

/**
 * Delivery options for pre‐order
 */
enum class DeliveryMethod(val label: String) {
    PICK_UP("Pick-up"),
    DELIVERY("Delivery")
}

/**
 * PreOrderScreen lets the user specify quantity, delivery method, and optional comment.
 *
 * @param offerId        ID of the honey offer being ordered
 * @param pricePerKg     Price string, e.g. "20.00"
 * @param availableKg    Maximum available kilos, e.g. "5"
 * @param onBack         Navigate back
 * @param onConfirmOrder Called when user taps Confirm; passes offerId, qty, method, and comment
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreOrderScreen(
    offerId: String,
    pricePerKg: String,
    availableKg: String,
    onBack: () -> Unit,
    onConfirmOrder: (offerId: String, quantity: Int, method: DeliveryMethod, comment: String) -> Unit
) {
    HoneyTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("Pre-Order", fontSize = 20.sp) },
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
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Quantity input
                var qtyText by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = qtyText,
                    onValueChange = { input ->
                        // Only allow digits and cap at availableKg
                        if (input.all(Char::isDigit)) qtyText = input
                    },
                    label = { Text("Quantity (kg)") },
                    placeholder = { Text("1–$availableKg") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Delivery method dropdown
                var expanded by remember { mutableStateOf(false) }
                var selectedMethod by remember { mutableStateOf(DeliveryMethod.PICK_UP) }
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedMethod.label,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Delivery Method") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DeliveryMethod.values().forEach { method ->
                            DropdownMenuItem(
                                text = { Text(method.label) },
                                onClick = {
                                    selectedMethod = method
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                // Optional comment
                var comment by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = comment,
                    onValueChange = { comment = it },
                    label = { Text("Comment (optional)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    singleLine = false
                )

                Spacer(modifier = Modifier.weight(1f))

                // Confirm button
                val qty = qtyText.toIntOrNull() ?: 0
                Button(
                    onClick = { onConfirmOrder(offerId, qty, selectedMethod, comment) },
                    enabled = qty in 1..availableKg.toInt(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Confirm Order", fontSize = 16.sp, color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
} 