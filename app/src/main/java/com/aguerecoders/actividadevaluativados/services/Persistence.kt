package com.aguerecoders.actividadevaluativados.services

import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.models.Banda
import com.aguerecoders.actividadevaluativados.models.Pirata


class Persistence {
    private val stringProvider = StringProvider()

    var sombreroPaja = listOf<Pirata>(
        Pirata("Monkey D. Luffy", "Ataque", "3.000.000.000", R.drawable.luffy,
            0,0,stringProvider.bioLuffy(), R.drawable.luffy_grande),
        Pirata("Roronoa Zoro", "Ataque", "1.500.000", R.drawable.zoro,
            0,0, stringProvider.bioZoro(), R.drawable.zoro_grande),
        Pirata("Nami", "Soporte", "66.000.000", R.drawable.nami,
            0,0, stringProvider.bioNami(), R.drawable.nami_grande),
        Pirata("Usopp", "Ataque", "200.000.000", R.drawable.ussop,
            0,0, stringProvider.bioUsopp(), R.drawable.usopp_grande),
        Pirata("Sanji", "Soporte", "330.000.000", R.drawable.sanji,
            0,0, stringProvider.bioSanji(), R.drawable.sanji_grande),
        Pirata("Tony Tony Chopper", "Soporte", "100", R.drawable.chopper,
            0,0, stringProvider.bioChopper(), R.drawable.chopper_grande),
        Pirata("Nico Robin", "Ataque", "130.000.000", R.drawable.robin,
            0,0, stringProvider.bioRobin(), R.drawable.robin_grande),
        Pirata("Franky", "Tanque", "94.000.000", R.drawable.baseline_visibility_24,
            0,0, stringProvider.bioFranky(), R.drawable.franky_grande),
        Pirata("Brook", "Soporte", "83.000.000", R.drawable.brook,
            0,0, stringProvider.bioBrook(), R.drawable.brook_grande)
    )

    var piratasRocks = listOf(
        Pirata("Rocks D. Xebec", "Ataque", "No hay", R.drawable.rocks,
            0,0, stringProvider.bioRocks(), R.drawable.rocks_grande),
        Pirata("Edward Newgate", "Tanque", " ", R.drawable.barba_blanca, 0,0,
            stringProvider.bioBarbaBlanca(), R.drawable.barba_blanca_grande),
        Pirata("Charlotte Linlin", "Ataque", "4.388.000.000", R.drawable.linlin,
            0,0, stringProvider.bioLinlin(), R.drawable.linlin_grande),
        Pirata("Kaido", "Tanque", "4.611.100.000", R.drawable.kaido,
            0,0, stringProvider.bioKaido(), R.drawable.kaido_grande),
        Pirata("Shiki", "Ataque", "No hay", R.drawable.shiki,
            0,0, stringProvider.bioShiki(), R.drawable.shiki_grande),
    )

    var marina = listOf(
        Pirata("Sengoku", "Tanque", "500.000", R.drawable.sengoku,
            0,0, stringProvider.bioSengoku(), R.drawable.sengoku_grande),
        Pirata("Kong", "Tanque", "300.000", R.drawable.kong,
            0,0, stringProvider.bioKong(), R.drawable.kong_grande),
        Pirata("Garp", "Ataque", "2.000.000", R.drawable.garp,
            0,0, stringProvider.bioGarp(), R.drawable.garp_grande),
        Pirata("Kuzan", "Ataque", "3.000.000", R.drawable.kuzan,
            0,0, stringProvider.bioKuzan(), R.drawable.kuzan_grande),
        Pirata("Sakazuki", "Ataque", "1.500.000", R.drawable.sakazuki,
            0,0, stringProvider.bioSakazuki(), R.drawable.sakazuki_grande),
        Pirata("Borsalino", "Ataque", "1.500.000", R.drawable.borsalino,
            0,0, stringProvider.bioBorsalino(), R.drawable.borsalino_grande),
    )

    var piratasPelirrojo = listOf(
        Pirata("Shanks", "Ataque", "4.048.900.000", R.drawable.shanks,
            0,0, stringProvider.bioShanks(), R.drawable.shanks_grande),
        Pirata("Benn Beckman", "Ataque", "2.000.000", R.drawable.beckman,
            0,0, stringProvider.bioBeckman(), R.drawable.beckman_grande),
        Pirata("Lucky Roo", "Ataque", "800.000", R.drawable.roo,
            0,0, stringProvider.bioRoo(), R.drawable.roo_grande),
        Pirata("Yasopp", "Ataque", "750.000", R.drawable.yasopp,
            0,0, stringProvider.bioYasopp(), R.drawable.yasopp_grande),
    )


    var bandas = listOf<Banda>(
        Banda("Sombrero de Paja", sombreroPaja, R.drawable.bandera_sombrero_paja),
        Banda("Piratas de Rocks", piratasRocks, R.drawable.bandera_rocks),
        Banda("Marina", marina, R.drawable.marina),
        Banda("Piratas del Pelirrojo", piratasPelirrojo, R.drawable.bandera_shanks)
    )

    fun getBandaPirata(pirata: Pirata): Banda {
        for (banda in bandas) {
            for (pirataBanda in banda.piratas) {
                if (pirataBanda.nombre == pirata.nombre) {
                    return banda
                }
            }
        }
        throw IllegalArgumentException("Pirata no encontrado en ninguna banda")
    }

    fun getPirataPorNombre(nombrePirata: String?): Pirata {
        val piratas = listOf(sombreroPaja, piratasRocks, marina, piratasPelirrojo).flatten()
        return piratas.find { it.nombre == nombrePirata }
            ?: throw IllegalArgumentException("Pirata no encontrado")
    }

}
