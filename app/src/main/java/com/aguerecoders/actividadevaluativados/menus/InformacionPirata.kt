package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.aguerecoders.actividadevaluativados.services.Persistence

@Composable
fun PirateInfo(nombrePirata: String?, ataquePirata: String?, vidaPirata: String?) {
    val persistence = Persistence()
    val pirata = persistence.getPirataPorNombre(nombrePirata)
    val imagenPirata = painterResource(id = pirata.imagenGrande!!)

    LazyColumn(content = {
        item {
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
                Row(modifier = Modifier.fillMaxWidth()) {
                    FormatoTextoNegrita(String = "Rol: ")
                    FormatoTexto("${pirata.rol!!}")
                }
                Row {
                    FormatoTextoNegrita(String = "Recompensa: ")
                    FormatoTexto("${pirata.recompensa!!}")
                }
                Row {
                    FormatoTextoNegrita(String = "Ataque: ")
                    FormatoTexto("${ataquePirata}")
                }
                Row {
                    FormatoTextoNegrita(String = "Vida: ")
                    FormatoTexto("${vidaPirata}")
                }
                FormatoTextoNegrita(String = "Biografia: ")
                FormatoTexto("${pirata.biografia!!}")
            }
        }
    })
}


@Composable
fun FormatoTexto(String: String) {
    Text(
        text = String,
        fontSize = 20.sp
    )
}

@Composable
fun FormatoTextoNegrita(String: String) {
    Text(
        text = String,
        fontSize = 20.sp,
        fontWeight = Bold
    )
}


