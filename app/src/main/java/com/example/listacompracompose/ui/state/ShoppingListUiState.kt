package com.example.listacompracompose.ui.state

import com.example.listacompracompose.model.Product

data class ShoppingListUiState (
    val list: List<Product> = emptyList(),
    val newProduct: String = "",
    val isSomethingChecked: Boolean = false
)

