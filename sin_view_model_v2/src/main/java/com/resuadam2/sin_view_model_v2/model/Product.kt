package com.resuadam2.sin_view_model_v2.model

import com.resuadam2.sin_view_model_v2.data.productsExample


data class Product (val name: String, var checked: Boolean = false) {}

fun getFakeShoppingProducts() = productsExample.map { Product(it) }.toSet()
