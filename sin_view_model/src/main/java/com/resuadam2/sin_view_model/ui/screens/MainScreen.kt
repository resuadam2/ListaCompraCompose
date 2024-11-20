package com.resuadam2.sin_view_model.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resuadam2.sin_view_model.model.Product
import com.resuadam2.sin_view_model.model.getFakeShoppingProducts

// private val products = getFakeShoppingProducts()

@Composable
fun MainScreen() {
    ScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent() {
    var products by remember { mutableStateOf(getFakeShoppingProducts()) }
    var somethingChecked = products.any { it.checked }
    val context = LocalContext.current

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text( text = "Shopping List", fontSize = 24.sp)
                },
                actions = {
                    OutlinedIconButton (
                        onClick = {
                            products = products.filter { !it.checked }.toSet()
                            somethingChecked = products.any { it.checked }
                        },
                        enabled = somethingChecked,
                    ) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete item")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AddProductRow(
                products = products,
                onAdd = { name ->
                    products = setOf(Product(name, false)) + products
                }
            )
            LazyColumn {
                items(products.size) {
                    val product = products.elementAt(it)
                    ShoppingListItem(
                        name = product.name,
                        checked = product.checked,
                        onDelete = {
                            products = products - product
                        },
                        toggleChecked = {
                            products = products.map {
                                if (it == product) {
                                    it.copy(checked = !it.checked)
                                } else {
                                    it
                                }
                            }.toSet()
                            somethingChecked = products.any { it.checked }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AddProductRow(
    products: Set<Product>,
    onAdd: (String) -> Unit
) {
    val context = LocalContext.current
    var value by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            singleLine = true,
        )
        IconButton(onClick = {
            if (value.isBlank()) {
                Toast.makeText(context, "Product name cannot be empty", Toast.LENGTH_SHORT)
                    .show()
                return@IconButton
            }
            if (products.any { it.name == value }) {
                Toast.makeText(context, "Product already exists", Toast.LENGTH_SHORT).show()
            } else {
                onAdd(value)
            }
            value = ""
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add item")
        }
    }
}


@Composable
fun ShoppingListItem(
    name: String,
    checked: Boolean,
    onDelete: () -> Unit,
    toggleChecked: (Boolean) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(color = if (checked) Color.LightGray else Color.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    )
    {
        Text(text = name)
        Spacer(modifier = Modifier.width(30.dp))
        Row {
            Checkbox(checked = checked, onCheckedChange = toggleChecked)
            IconButton(onClick = {
                onDelete()
            } ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete item")
            }
        }
    }
}