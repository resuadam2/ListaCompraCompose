package com.resuadam2.view_model_hibrido.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.resuadam2.view_model_hibrido.model.Product
import androidx.lifecycle.ViewModel
import com.resuadam2.view_model_hibrido.model.getFakeShoppingProducts

class ShoppingListViewModel : ViewModel() {
    var state by mutableStateOf(ShoppingListUiState())
         private set

    private val _shoppingList = mutableStateListOf<Product>()
    val shoppingList: Set<Product> get() = _shoppingList.toSet()

    init {
        _shoppingList.addAll(getFakeShoppingProducts())
    }

    fun toggleChecked(item: Product) {
        // _shoppingList.find { it.name == item.name }?.checked = !item.checked
        _shoppingList.set(_shoppingList.indexOf(item), item.copy(checked = !item.checked))
        isSomethingChecked() // Check if there is something checked
    }

    fun remove(item: Product) {
        _shoppingList.remove(item)
        isSomethingChecked() // Check if there is something checked
    }

    // Add a new product to the list if it is not already there
    fun add(name: String) = if (_shoppingList.find { it.name == name } == null) {
        _shoppingList.add(0, Product(name))
        true
    } else {
        false
    }

    private fun isSomethingChecked() {
        state = state.copy(isSomethingChecked = _shoppingList.any { it.checked })
    }

    fun changingNewProduct(newProduct: String) {
        state = state.copy(newProduct = newProduct)
    }

    fun deleteAllChecked() {
        _shoppingList.removeAll { it.checked }
        isSomethingChecked() // Check if there is something checked
    }
}