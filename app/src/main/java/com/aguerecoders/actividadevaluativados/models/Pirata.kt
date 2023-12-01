package com.aguerecoders.actividadevaluativados.models

import androidx.compose.ui.graphics.painter.Painter
import kotlin.random.Random

data class Pirata(
    val nombre: String,
    val rol: String,
    val recompensa: String,
    val imagen: Int,
    val vida: Int = generarVidaAleatoria(rol),
    val ataque: Int = generarAtaqueAleatorio(rol)) {


}

fun generarAtaqueAleatorio(rol: String): Int {
    if (rol.equals("Ataque")){
        return Random(Random.nextLong()).nextInt(75, 100)
    }else if(rol.equals("Tanque")){
        return Random(Random.nextLong()).nextInt(25, 50)
    }else{
        return Random(Random.nextLong()).nextInt(35, 65)
    }
}

fun generarVidaAleatoria(rol : String) : Int{
    if (rol.equals("Ataque")){
        return Random(Random.nextLong()).nextInt(25, 50)
    }else if(rol.equals("Tanque")){
        return Random(Random.nextLong()).nextInt(75, 100)
    }else{
        return Random(Random.nextLong()).nextInt(35, 65)
    }
}

