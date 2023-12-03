package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = pirata.nombre!!,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Image(
            painter = imagenPirata,
            contentDescription = pirata.nombre,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.size(20.dp))
        FormatoTexto("Rol: ${pirata.rol!!}")
        FormatoTexto("Recompensa: ${pirata.recompensa!!}")
        FormatoTexto("Ataque: ${pirata.ataque!!}")
        FormatoTexto("Vida: ${pirata.vida!!}")
        FormatoTexto("Biografía: ${pirata.biografia!!}")
    }
}


@Composable
fun FormatoTexto(String: String) {
    Text(
        text = String,
        fontSize = 20.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )
}
