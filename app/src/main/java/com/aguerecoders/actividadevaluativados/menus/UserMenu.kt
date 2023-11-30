﻿package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.aguerecoders.actividadevaluativados.services.Persistence

@Composable
fun UserMenu(navController: NavHostController) {
    val persistence = Persistence()
    Column {
        BarraDeBusqueda()
        LazyColumn {
            persistence.bandas.forEach { banda ->
                item {
                    Row (modifier = Modifier.padding(start = 30.dp, top = 30.dp)){
                        Image(painter = painterResource(id = banda.imagenBanda),
                            contentDescription = banda.nombreBanda,
                            modifier = Modifier.size(70.dp)
                        )
                        Text(text = banda.nombreBanda,
                            modifier = Modifier.padding(16.dp),
                            fontSize = 25.sp)
                    }
                }
                banda.piratas.forEach { pirata ->
                    item {
                        PirataCard(pirata)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraDeBusqueda(){
    var searchText by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }
    val persistence = Persistence()

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
                val filteredBandas =
                    persistence.bandas.filter { it.nombreBanda.contains(searchText) }
                LazyColumn {
                    items(filteredBandas) { equipo ->

                        TextButton(onClick = { /*TODO*/}) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Person, contentDescription = "Icono de agregar")
                                Text(text = equipo.nombreBanda, modifier = Modifier.padding(start = 20.dp))
                                Text(text = "Yúnez, chúpamela", modifier = Modifier.padding(start = 20.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PirataCard(pirata: Pirata) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onClick = { expanded = !expanded },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = pirata.imagen),
                    contentDescription = pirata.nombre,
                    modifier = Modifier.size(70.dp)
                )
                Text(text = pirata.nombre,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 20.dp)
                )
            }
            // Este contenido se mostrará cuando la tarjeta esté expandida
            if (expanded) {
                /*TODO aqui va el ataque y todo eso*/
                Text(
                    text = "Rol: ${pirata.rol}",
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "Recompensa: ${pirata.recompensa}",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}