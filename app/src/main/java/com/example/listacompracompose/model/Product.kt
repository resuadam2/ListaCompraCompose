package com.example.listacompracompose.model

class Product (val name: String, var checked: Boolean = false) {
    fun toggleChecked() { checked = !checked }
}

fun getFakeShoppingProducts() = List(20) { Product("Product $it") }
