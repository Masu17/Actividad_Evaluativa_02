package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController

@Composable
fun UserMenu(navController: NavHostController) {

    var searchText by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }

    Column {
        SearchBar(
            query = searchText,
            onQueryChange = { newQuery -> searchText = newQuery },
            onSearch = { query ->
                // Implementar la lógica de búsqueda aquí
                println("Buscando: $query")
                searchActive = false
            },
            active = searchActive,
            onActiveChange = { searchActive = it },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            placeholder = { Text("Buscar") },
            leadingIcon = { /* Implementar el ícono de búsqueda aquí */ },
            trailingIcon = { /* Implementar el ícono de cierre aquí */ },
        )
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val searchText = remember { mutableStateOf(query) }

    TextField(
        value = searchText.value,
        onValueChange = { newValue ->
            searchText.value = newValue
            onQueryChange(newValue)
        },
        modifier = modifier,
        enabled = enabled,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch(searchText.value) })
    )
}