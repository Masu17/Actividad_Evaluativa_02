package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.aguerecoders.actividadevaluativados.services.Persistence

@Composable
fun PirateImagen(pirata: Pirata) {
    Image(
        painter = (painterResource(id = pirata.imagenGrande!!)),
        contentDescription = pirata.nombre,
        modifier = Modifier.size(70.dp)
    )
}

@Composable
fun PirateInfo(nombrePirata: String?) {
    val persistence = Persistence()
    val pirata = persistence.getPirataPorNombre(nombrePirata)
    val imagenPirata = painterResource(id = pirata.imagenGrande!!)

    Column (modifier = Modifier.fillMaxWidth()){
        Text(text = pirata.nombre!!)
        Image(
            painter = imagenPirata,
            contentDescription = pirata.nombre,
            modifier = Modifier.size(70.dp)
        )
    }
}
