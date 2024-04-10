package com.example.listacompracompose.ui.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.listacompracompose.model.Product
import com.example.listacompracompose.model.getFakeShoppingProducts

class ShoppingListViewModel : ViewModel() {
    var list = getFakeShoppingProducts().toMutableStateList()

    fun toggleChecked(item: Product) {
        item.toggleChecked()
    }

    fun deleteProduct(item: Product) {
        list.remove(item)
    }
}