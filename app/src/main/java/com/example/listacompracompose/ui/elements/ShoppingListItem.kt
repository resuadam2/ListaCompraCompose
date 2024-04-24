package com.example.listacompracompose.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListItem(
    name: String,
    checked: Boolean,
    remove: () -> Unit,
    toggleChecked: (Boolean) -> Unit
    ) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(color = if (checked) Color.LightGray else Color.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        )
    {
        Text(text = name)
        Spacer(modifier = Modifier.width(30.dp))
        Row {
            Checkbox(checked = checked, onCheckedChange = toggleChecked)
            IconButton(onClick = remove ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete item")
            }
        }
    }
}