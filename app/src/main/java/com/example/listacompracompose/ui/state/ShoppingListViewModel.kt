package com.example.listacompracompose.ui.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.listacompracompose.model.Product
import com.example.listacompracompose.model.getFakeShoppingProducts

class ShoppingListViewModel : ViewModel() {
    var list = getFakeShoppingProducts().toMutableStateList()

    fun toggleChecked(item: Product) {
        list[list.indexOf(item)] = item.copy(checked = !item.checked)
    }

    fun remove(item: Product) {
        list.remove(item)
    }

    // Add a new product to the list if it is not already there
    fun add(name: String) = if ( list.none { it.name == name } ) {
        list.add(0, Product(name))
        true
    } else false
}