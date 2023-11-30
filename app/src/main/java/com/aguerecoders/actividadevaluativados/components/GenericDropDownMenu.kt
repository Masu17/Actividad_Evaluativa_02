package com.aguerecoders.actividadevaluativados.components


import android.widget.Toast
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
            value = if (selectedBanda.value == "") {
                "Elija una banda"
            } else {
                selectedBanda.value
            },
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            modifier = Modifier.menuAnchor()
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
fun PirataButton(
    selectedPiratas: List<Banda>,
    selectedBanda: MutableState<String>,
    navController: NavController,
    selectedPirata: MutableState<String>,
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
            value = if (selectedBanda.value == "") {
                "Seleccione un pirata"
            } else {
                "Banda de: ${selectedBanda.value}"
            },
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            if (selectedBanda.value != "") {
                selectedPiratas[selectedBandaId.value].piratas.forEach { item ->
                    DropdownMenuItem(text = { Text(text = item.nombre) }, onClick = {
                        selectedPirata.value = item.nombre
                        isExpanded = false
                    })
                }
            }
        }
    }
}


