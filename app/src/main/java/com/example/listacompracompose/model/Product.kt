package com.example.listacompracompose.model

import com.example.listacompracompose.data.productsExample

data class Product (val name: String, var checked: Boolean = false) {}

fun getFakeShoppingProducts() = productsExample.map { Product(it) }
