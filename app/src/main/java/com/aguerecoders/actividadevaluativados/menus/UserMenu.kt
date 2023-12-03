package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.aguerecoders.actividadevaluativados.services.Persistence
import com.aguerecoders.actividadevaluativados.models.Banda
import com.aguerecoders.actividadevaluativados.navigation.Rutas
import com.aguerecoders.actividadevaluativados.ui.theme.Marina
import com.aguerecoders.actividadevaluativados.ui.theme.Pelirrojo
import com.aguerecoders.actividadevaluativados.ui.theme.Rocks
import com.aguerecoders.actividadevaluativados.ui.theme.Sombrero

/*TODO esto es para buscar todos los cards
@Composable
fun UserMenu(navController: NavHostController) {

    val persistence = Persistence()
    var selectedBanda by remember { mutableStateOf<Banda?>(null) }

    Column {
        BarraDeBusqueda(onBandaSelected = { selectedBanda = it })
        LazyColumn {
            if (selectedBanda != null) {
                persistence.bandas.filter { it == selectedBanda }.forEach { banda ->
                    item {
                        Row(modifier = Modifier.padding(start = 30.dp, top = 30.dp)) {
                            Image(
                                painter = painterResource(id = banda.imagenBanda),
                                contentDescription = banda.nombreBanda,
                                modifier = Modifier.size(70.dp)
                            )
                            Text(
                                text = banda.nombreBanda,
                                modifier = Modifier.padding(16.dp),
                                fontSize = 25.sp
                            )
                        }
                    }
                    banda.piratas.forEach { pirata ->
                        item {
                            PirataCard(pirata)
                        }
                    }
                }
            } else {
                persistence.bandas.forEach { banda ->
                    item {
                        Row(modifier = Modifier.padding(start = 30.dp, top = 30.dp)) {
                            Image(
                                painter = painterResource(id = banda.imagenBanda),
                                contentDescription = banda.nombreBanda,
                                modifier = Modifier.size(70.dp)
                            )
                            Text(
                                text = banda.nombreBanda,
                                modifier = Modifier.padding(16.dp),
                                fontSize = 25.sp
                            )
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraDeBusqueda(onBandaSelected: (Banda) -> Unit) {
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
                    items(filteredBandas) { banda ->
                        TextButton(onClick = {
                            onBandaSelected(banda)
                            searchActive = false
                        }) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Person, contentDescription = "Icono de agregar")
                                Text(
                                    text = banda.nombreBanda,
                                    modifier = Modifier.padding(start = 20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}*/

@Composable
fun UserMenu(navController: NavHostController, equipoFinal: List<Pirata>) {
    val persistence = Persistence()
    var selectedBanda by remember { mutableStateOf<Banda?>(null) }
    var borrar = remember { mutableStateOf(false) }

    Column {
        Text(text = "Menú de usuario")
        BarraDeBusqueda(onBandaSelected = { selectedBanda = it })
        LazyColumn {
            if (selectedBanda != null) {
                val equipoFiltrado = equipoFinal.filter { pirata ->
                    persistence.bandas.any { banda ->
                        banda.piratas.any { it.nombre == pirata.nombre
                                && banda.nombreBanda == selectedBanda!!.nombreBanda }
                    }
                }
                items(equipoFiltrado) { pirata ->
                    PirataCard(navController ,pirata, borrar)
                }
            } else {
                items(equipoFinal) { pirata ->
                    PirataCard(navController, pirata, borrar)
                }
            }
            item { Spacer(modifier = Modifier.height(50.dp)) }
        }
    }
    botonesFlotantes(navController = navController, borrar)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraDeBusqueda(onBandaSelected: (Banda?) -> Unit) {
    var searchText by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }
    val persistence = Persistence()
    var placeHolderText by remember { mutableStateOf("Buscar") }

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
        placeholder = { Text(text = placeHolderText) },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Icono de busqueda") },
        trailingIcon = {
            IconButton(onClick = {
                searchActive = false
                onBandaSelected(null)
                placeHolderText = "Buscar"
            }) {
                Icon(Icons.Filled.Close, contentDescription = "Icono de busqueda")
            }
        }
    ) {
        if (searchActive) {
            val filteredBandas = persistence.bandas.filter { it.nombreBanda.contains(searchText) }
            LazyColumn {
                items(filteredBandas) { banda ->
                    TextButton(onClick = {
                        onBandaSelected(banda)
                        searchActive = false
                        placeHolderText = banda.nombreBanda
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Person, contentDescription = "Icono de agregar")
                            Text(
                                text = banda.nombreBanda,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                    }
                }
                item {
                    TextButton(onClick = {
                        searchActive = false
                        searchText = ""
                        onBandaSelected(null)
                        placeHolderText = "Buscar"
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Person, contentDescription = "Icono de agregar")
                            Text(
                                "Mostrar todo",
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PirataCard(navController: NavHostController, pirata: Pirata, borrar: MutableState<Boolean>) {
    var expanded by remember { mutableStateOf(false) }
    val persistence = Persistence()
    val bandaColores = mapOf(
        "Sombrero de Paja" to Sombrero,
        "Piratas de Rocks" to Rocks,
        "Marina" to Marina,
        "Piratas del Pelirrojo" to Pelirrojo
    )
    val pirataBanda = persistence.getBandaPirata(pirata)
    val bandaColor = bandaColores[pirataBanda.nombreBanda] ?: Color.Blue

    Row(verticalAlignment = Alignment.CenterVertically) {
        {}
        if (borrar.value) {
            Checkbox(checked = false, onCheckedChange = { /*TODO*/ })
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = bandaColor
            ),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = { expanded = !expanded }
        ) {
            Surface(
                color = bandaColor,
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            pirata.imagen?.let { painterResource(id = it) }?.let {
                                Image(
                                    painter = it,
                                    contentDescription = pirata.nombre,
                                    modifier = Modifier.size(70.dp)
                                )
                            }
                            pirata.nombre?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .padding(start = 20.dp)
                                )
                            }
                            Image(
                                painter = painterResource(id = pirataBanda.imagenBanda),
                                alignment = Alignment.CenterEnd,
                                contentDescription = "Bandera de la banda",
                                modifier = Modifier.fillMaxWidth()
                                    .size(60.dp)
                            )
                        }
                        if (expanded) {
                            /*TODO aqui va el ataque y todo eso*/
                            Text(
                                text = "Rol: ${pirata.rol}",
                                modifier = Modifier.padding(top = 16.dp)
                            )
                            Text(text = "Vida: ${pirata.vida}", modifier = Modifier.padding(top = 16.dp))
                            Text(text = "Ataque: ${pirata.ataque}", modifier = Modifier.padding(top = 16.dp))
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Recompensa: ${pirata.recompensa}",
                                    modifier = Modifier.padding(top = 16.dp)
                                )
                                IconButton(onClick = {
                                    navController.navigate(Rutas.PirateInfo.ruta + "/${pirata.nombre}")
                                }) {
                                    Icon(Icons.Default.Info, contentDescription = "Icono de info")
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun botonesFlotantes(navController: NavHostController, borrar: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExtendedFloatingActionButton(onClick = { navController.navigate(Rutas.CharacterSelection.ruta) }) {
                Row {
                    Icon(Icons.Default.Person, contentDescription = "Icono de agregar")
                    Text(text = "Agregar")
                }
            }
            ExtendedFloatingActionButton(onClick = { "pelea" }) {
                Row {
                    Icon(Icons.Default.Warning, contentDescription = "Icono de pelea")
                    Text(text = "Pelea")
                }
            }
            ExtendedFloatingActionButton(onClick = { borrar.value = !borrar.value }) {
                Row {
                    Icon(Icons.Default.Warning, contentDescription = "Icono de borrar")
                    Text(text = "Borrar")
                }
            }

        }
    }
}