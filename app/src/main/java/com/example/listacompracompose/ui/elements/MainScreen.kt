package com.example.listacompracompose.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listacompracompose.ui.state.ShoppingListViewModel


@Composable
fun MainScreen(shoppingListViewModel: ShoppingListViewModel = viewModel()) {
    val shoppingListUiState by shoppingListViewModel.uiState.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text( text = "Shopping List", fontSize = 24.sp )
        AddProduct(addProduct = {
            shoppingListViewModel.add(it)
        })
        LazyColumn(

        )
        {
            items(items = shoppingListUiState.list) { product ->
                ShoppingListItem(
                    product.name,
                    product.checked,
                    remove = { shoppingListViewModel.remove(product) },
                    toggleChecked = { shoppingListViewModel.toggleChecked(product) },
                )
            }
        }
    }
}