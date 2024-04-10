package com.example.listacompracompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listacompracompose.ui.state.ShoppingListViewModel


@Composable
fun MainScreen() {
    val vm: ShoppingListViewModel = viewModel()

    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(10.dp)
    )
    {
        items( items = vm.list) {product ->
            ShoppingListItem(
                product.name,
                product.checked,
                remove = { vm.deleteProduct(product) },
                toggleChecked = { checkChanged ->
                    product.checked = checkChanged },
            )
        }
    }
}