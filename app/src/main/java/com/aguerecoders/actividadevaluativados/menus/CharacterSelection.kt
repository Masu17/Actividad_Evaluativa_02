package com.aguerecoders.actividadevaluativados.menus

import android.widget.Toast
import androidx.compose.foundation.Image
import com.google.gson.Gson
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.components.BandBox
import com.aguerecoders.actividadevaluativados.components.PirataBox
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.aguerecoders.actividadevaluativados.navigation.Rutas
import com.aguerecoders.actividadevaluativados.services.Persistence
import java.util.ArrayList


var equipoPirata = emptyList<Pirata>().toMutableList()

@Composable
fun CharacterSelection(navController: NavController) {

    val selectedBanda: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val selectedBandaId: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    val selectedPirataNombre: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val selectedPirataRol: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val selectedPirataImage: MutableState<Int> = rememberSaveable { mutableIntStateOf(0) }
    val selectedPirataRecompensa: MutableState<String> = rememberSaveable { mutableStateOf("") }
    val selectedPirataImageGrande: MutableState<Int> = rememberSaveable { mutableIntStateOf(0) }

    var longEquipo by rememberSaveable {
        mutableIntStateOf(equipoPirata.size)
    }
    var nombresEquipo by rememberSaveable {
        mutableStateOf("")
    }

    Image(
        painter = painterResource(id = R.drawable.characterselectionbg),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Crear personaje", fontSize = 30.sp,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .width(300.dp)
                .height(55.dp)
                .background(Color(0xFF883130)),
            color = Color(220, 227, 223),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.alfa_slab_one, FontWeight.Normal)
            ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Seleccione una banda: ",
            fontSize = 20.sp,
            modifier = Modifier.width(350.dp),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Black,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        BandBox(
            selectedBanda, Persistence().bandas, selectedBandaId
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Seleccione un pirata: ",
            fontSize = 20.sp,
            modifier = Modifier.width(350.dp),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Black,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        PirataBox(
            Persistence().bandas,
            selectedBanda,
            navController,
            selectedPirataNombre,
            selectedPirataRol,
            selectedPirataRecompensa,
            selectedPirataImage,
            selectedBandaId
        )

        var pirataFinal = Pirata(
            selectedPirataNombre.value,
            selectedPirataRol.value,
            selectedPirataRecompensa.value,
            selectedPirataImage.value,
            0,
            0,
            "",
            selectedPirataImageGrande.value
        )


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Estadisticas: ",
            fontSize = 20.sp,
            modifier = Modifier.width(350.dp),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Black,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        if (pirataFinal.nombre!!.isEmpty()) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFFE6AF))
                    .border(7.dp, Color(0xFF883130))
                    .width(350.dp)
                    .height(170.dp)
                    .padding(13.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nombre: ", fontSize = 18.sp)
                Text(text = "Ataque: ", fontSize = 18.sp)
                Text(text = "Vida: ", fontSize = 18.sp)
                Text(text = "Recompensa: ", fontSize = 18.sp)
            }
        } else {
            Column(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFFE6AF))
                    .border(7.dp, Color(0xFF883130))
                    .width(350.dp)
                    .height(170.dp)
                    .padding(13.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nombre: ${pirataFinal.nombre} ", fontSize = 18.sp)
                pirataFinal.ataque = pirataFinal.generarAtaqueAleatorio()
                Text(text = "Ataque: ${pirataFinal.ataque} ", fontSize = 18.sp)
                pirataFinal.vida = pirataFinal.generarVidaAleatoria()
                Text(text = "Vida: ${pirataFinal.vida} ", fontSize = 18.sp)
                Text(text = "Recompensa: ${pirataFinal.recompensa} ", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Equipo: ",
            fontSize = 20.sp,
            modifier = Modifier.width(350.dp),
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontWeight = FontWeight.Black,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))

        Column(
            Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFFE6AF))
                .border(7.dp, Color(0xFF883130))
                .width(350.dp)
                .height(170.dp)
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = nombresEquipo, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Button(onClick = {
                if (equipoPirata.size >= 5) {
                    Toast.makeText(
                        navController.context,
                        "El equipo solo puede estar formado por 5 piratas",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (pirataFinal.ataque!! != 0 && pirataFinal.vida!! != 0) {
                    var itExists = false
                    equipoPirata.forEach() {
                        if (it.nombre == pirataFinal.nombre) {
                            Toast.makeText(
                                navController.context,
                                "El pirata ya esta en el equipo",
                                Toast.LENGTH_SHORT
                            ).show()
                            itExists = true
                        }
                    }

                    if (!itExists) {
                        Toast.makeText(
                            navController.context,
                            "Pirata añadido al equipo correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                        equipoPirata.add(pirataFinal)
                        nombresEquipo += " ${pirataFinal.nombre} - " + "ATK: ${pirataFinal.ataque} - " + "HP: ${pirataFinal.vida} \n"
                        longEquipo = equipoPirata.size
                    }

                } else {
                    Toast.makeText(
                        navController.context, "Seleccione un pirata valido", Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text(text = "Añadir ${longEquipo}/5")
            }
            Button(onClick = {
                val piratasStringJSON = Gson().toJson(ArrayList(equipoPirata))
                println(piratasStringJSON)
                navController.navigate(Rutas.UserMenu.ruta + "/{$piratasStringJSON}")
            }) {
                Text(text = "Guardar equipo y continuar")
            }
        }


    }
}

