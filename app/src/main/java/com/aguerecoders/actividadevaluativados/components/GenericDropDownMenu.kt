package com.aguerecoders.actividadevaluativados.components


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aguerecoders.actividadevaluativados.models.Banda

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BandBox(
    selectedBanda: MutableState<String>,
    ListaBanda: List<Banda>,
    selectedBandaId: MutableState<Int>,
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it }) {
        TextField(
            label = { Text(text = "Seleccion de la banda")},
            value = if (selectedBanda.value == "") {
                "Selecciona una banda"
            } else {
                selectedBanda.value
            },
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            modifier = Modifier
                .width(350.dp)
                .menuAnchor()
        )
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            ListaBanda.forEachIndexed() { id, item ->
                DropdownMenuItem(text = { Text(text = item.nombreBanda) }, onClick = {
                    selectedBanda.value = item.nombreBanda
                    selectedBandaId.value = id
                    isExpanded = false
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PirataBox(
    selectedPiratas: List<Banda>,
    selectedBanda: MutableState<String>,
    navController: NavController,
    selectedPirataNombre: MutableState<String>,
    selectedPiraRol: MutableState<String>,
    selectedPirataRecompensa: MutableState<String>,
    selectedPirataImage: MutableState<Int>,
    selectedBandaId: MutableState<Int>,
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
        if (selectedBanda.value == "") {
            Toast.makeText(navController.context, "Seleccione una banda", Toast.LENGTH_SHORT).show()
        } else {
            isExpanded = it
        }
    }) {
        TextField(
            label = { Text(text = "Seleccion del pirata")},
            value = if (selectedBanda.value == "") {
                "No hay una banda seleccionada"
            } else {
                if (selectedPirataNombre.value == ""){
                    "Banda: ${selectedBanda.value}"
                }else{
                    selectedPirataNombre.value
                }
            },
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            modifier = Modifier
                .menuAnchor()
                .width(350.dp)
        )
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            if (selectedBanda.value != "") {
                selectedPiratas[selectedBandaId.value].piratas.forEach { item ->
                    DropdownMenuItem(text = { item.nombre?.let { Text(text = it) } }, onClick = {
                        selectedPirataNombre.value = item.nombre.toString()
                        selectedPiraRol.value = item.rol.toString()
                        selectedPirataRecompensa.value = item.recompensa.toString()
                        selectedPirataImage.value = item.imagen!!
                        isExpanded = false
                    })
                }
            }
        }
    }
}


