package com.example.listacompracompose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Product (val name: String, var checked: Boolean = false) {}

fun getFakeShoppingProducts() = List(20) { Product("Product $it") }
