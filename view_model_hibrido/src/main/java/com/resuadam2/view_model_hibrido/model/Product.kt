package com.resuadam2.view_model_hibrido.model

import com.resuadam2.view_model_hibrido.data.productsExample

data class Product (val name: String, var checked: Boolean = false) {}

fun getFakeShoppingProducts() = productsExample.map { Product(it) }
