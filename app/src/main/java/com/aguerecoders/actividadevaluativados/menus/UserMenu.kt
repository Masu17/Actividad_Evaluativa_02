package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.services.Persistence

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserMenu(navController: NavHostController) {

    var searchText by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }
    val persistence = Persistence() // Asume que tienes una instancia de Persistence

    Column {
        Text(text = "Menú de usuario")
        SearchBar(
            query = searchText,
            onQueryChange = { newQuery -> searchText = newQuery },
            onSearch = { query ->
                println("Buscando: $query")
                searchActive = false
            },
            active = searchActive,
            onActiveChange = { searchActive = it },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            placeholder = { Text("Buscar") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Icono de busqueda") },
            trailingIcon = {
                IconButton(onClick = { searchActive = false }) {
                    Icon(Icons.Filled.Close, contentDescription = "Icono de busqueda")
                }
            }
        ) {
            if (searchActive) {
                val filteredBandas = persistence.bandas.filter { it.nombreBanda.contains(searchText) }
                LazyColumn {
                    items(filteredBandas) { equipo ->
                        Button(
                            onClick = { navController.navigate("login") }) {
                            Text(text = equipo.nombreBanda)
                        }
                    }
                }
            }
        }

    }
}

fun TextButton(content: Unit, onClick: () -> Unit, function: () -> Unit) {}