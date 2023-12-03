package com.aguerecoders.actividadevaluativados.models

import com.aguerecoders.actividadevaluativados.R
import kotlin.random.Random

data class Pirata(
    val nombre: String? = "",
    val rol: String? = "",
    val recompensa: String? = "",
    val imagen: Int? = R.drawable.baseline_visibility_24,
    var vida: Int? = 0,
    var ataque: Int? = 0,
    var biografia: String? = "",
    val imagenGrande: Int? = R.drawable.baseline_arrow_drop_down_24
) {
    fun generarAtaqueAleatorio(): Int {
        if (this.rol.equals("Ataque")) {
            return Random(Random.nextLong()).nextInt(75, 100)
        } else if (this.rol.equals("Tanque")) {
            return Random(Random.nextLong()).nextInt(25, 50)
        } else {
            return Random(Random.nextLong()).nextInt(35, 65)
        }
    }

    fun generarVidaAleatoria(): Int {
        if (this.rol.equals("Ataque")) {
            return Random(Random.nextLong()).nextInt(25, 50)
        } else if (this.rol.equals("Tanque")) {
            return Random(Random.nextLong()).nextInt(75, 100)
        } else {
            return Random(Random.nextLong()).nextInt(35, 65)
        }
    }
}



