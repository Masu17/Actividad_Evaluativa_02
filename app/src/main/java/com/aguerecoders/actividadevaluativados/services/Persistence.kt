package com.aguerecoders.actividadevaluativados.services

import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.models.Bandas
import com.aguerecoders.actividadevaluativados.models.Pirata

class Persistence {

    var sombreroPaja = listOf<Pirata>(
        Pirata("Monkey D. Luffy", "Ataque", "1.500.000.000", R.drawable.luffy_removebg_preview),
        Pirata("Roronoa Zoro", "Ataque", "320.000.000", R.drawable.baseline_visibility_24),
        Pirata("Nami", "Soporte", "66.000.000", R.drawable.baseline_visibility_24),
        Pirata("Usopp", "Ataque", "200.000.000", R.drawable.baseline_visibility_24),
        Pirata("Sanji", "Soporte", "330.000.000", R.drawable.baseline_visibility_24),
        Pirata("Tony Tony Chopper", "Soporte", "100", R.drawable.baseline_visibility_24),
        Pirata("Nico Robin", "Ataque", "130.000.000", R.drawable.baseline_visibility_24),
        Pirata("Franky", "Tanque", "94.000.000", R.drawable.baseline_visibility_24),
        Pirata("Brook", "Soporte", "83.000.000", R.drawable.baseline_visibility_24)
    )

    var piratasRocks = listOf(
        Pirata("Rocks D. Xebec", "Ataque", "???", R.drawable.baseline_visibility_24),
        Pirata("Edward Newgate", "Tanque", " ", R.drawable.baseline_visibility_24),
        Pirata("Charlotte Linlin", "Ataque", "4.388.000.000", R.drawable.baseline_visibility_24),
        Pirata("Kaido", "Tanque", "4.611.100.000", R.drawable.baseline_visibility_24),
        Pirata("Shiki", "Ataque", " ", R.drawable.baseline_visibility_24),
    )

    var marina = listOf(
        Pirata("Sengoku", "Tanque", " ", R.drawable.baseline_visibility_24),
        Pirata("Kong", "Tanque", " ", R.drawable.baseline_visibility_24),
        Pirata("Garp", "Ataque", " ", R.drawable.baseline_visibility_24),
        Pirata("Kuzan", "Ataque", " ", R.drawable.baseline_visibility_24),
        Pirata("Sakazuki", "Ataque", " ", R.drawable.baseline_visibility_24),
        Pirata("Borsalino", "Ataque", " ", R.drawable.baseline_visibility_24),
    )

    var piratasPelirrojo = listOf(
        Pirata("Shanks", "Ataque", "4.048.900.000", R.drawable.baseline_visibility_24),
        Pirata("Benn Beckman", "Ataque", " ", R.drawable.baseline_visibility_24),
        Pirata("Lucky Roo", "Ataque", " ", R.drawable.baseline_visibility_24),
        Pirata("Yasopp", "Ataque", " ", R.drawable.baseline_visibility_24),
    )


    var bandas = listOf<Bandas>(
        Bandas("Sombrero de Paja", sombreroPaja, R.drawable.bandera_sombrero_paja),
        Bandas("Piratas de Rocks", piratasRocks, R.drawable.bandera_sombrero_paja),
        Bandas("Marina", marina, R.drawable.bandera_sombrero_paja),
        Bandas("Piratas del Pelirrojo", piratasPelirrojo, R.drawable.bandera_sombrero_paja)
    )

}