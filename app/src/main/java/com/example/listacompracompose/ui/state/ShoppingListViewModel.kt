package com.example.listacompracompose.ui.state

import android.content.Context
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.listacompracompose.model.Product
import com.example.listacompracompose.model.getFakeShoppingProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoppingListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ShoppingListUiState())
    val uiState: StateFlow<ShoppingListUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = ShoppingListUiState(getFakeShoppingProducts().toMutableStateList())
    }

    fun toggleChecked(item: Product) {
        _uiState.value = _uiState.value.copy(list = _uiState.value.list.toMutableStateList().apply {
            find { it.name == item.name }?.checked = !item.checked
        })
        isSomethingChecked()
    }

    fun remove(item: Product) {
        _uiState.value = _uiState.value.copy(list = _uiState.value.list.toMutableStateList().apply { remove(item) })
    }

    // Add a new product to the list if it is not already there
    fun add(name: String) = if (_uiState.value.list.find { it.name == name } == null) {
        _uiState.value = _uiState.value.copy(list = _uiState.value.list.toMutableStateList().apply { add(0, Product(name)) })
        true
    } else {
        false
    }

    fun changingNewProduct(newProduct: String) {
        _uiState.value = _uiState.value.copy(newProduct = newProduct)
    }

    fun deleteAllChecked() {
        _uiState.value = _uiState.value.copy(list = _uiState.value.list.toMutableStateList().apply {
            removeAll { it.checked }
        })
    }

    fun isSomethingChecked() {
        _uiState.value = _uiState.value.copy(isSomethingChecked = _uiState.value.list.any { it.checked })
    }
}