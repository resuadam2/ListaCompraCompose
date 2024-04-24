package com.example.listacompracompose.ui.elements

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AddProduct(
    addProduct: (String) -> Boolean,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ){

        var value by rememberSaveable { mutableStateOf("") }
        val context = LocalContext.current
        TextField(value = value, onValueChange = { value = it })
        IconButton(onClick = {
            if (value.isEmpty()) {
                Toast.makeText(context, "Product name cannot be empty", Toast.LENGTH_SHORT).show()
            } else if(!addProduct(value))
                Toast.makeText(context, "Product already exists", Toast.LENGTH_SHORT).show()
        } ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add item")
        }
    }
}