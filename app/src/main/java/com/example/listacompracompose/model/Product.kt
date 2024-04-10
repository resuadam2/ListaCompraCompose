package com.example.listacompracompose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Product (val name: String) {
    var checked by mutableStateOf(false)
    fun toggleChecked() { checked = !checked }
}

fun getFakeShoppingProducts() = List(20) { Product("Product $it") }
