package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aguerecoders.actividadevaluativados.components.BandBox
import com.aguerecoders.actividadevaluativados.components.PirataButton
import com.aguerecoders.actividadevaluativados.services.Persistence

@Composable
fun CharacterSelection(navController: NavController) {

    val selectedBanda: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val selectedBandaId : MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    val selectedPirata : MutableState<String> = rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Text(text = "Crear personaje", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        BandBox(selectedBanda, Persistence().bandas, selectedBandaId)
        Spacer(modifier = Modifier.height(20.dp))
        PirataButton(Persistence().bandas, selectedBanda, navController, selectedPirata, selectedBandaId)
    }

}

