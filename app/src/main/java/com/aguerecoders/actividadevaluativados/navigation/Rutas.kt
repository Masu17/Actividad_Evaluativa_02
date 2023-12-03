package com.aguerecoders.actividadevaluativados.navigation

sealed class Rutas(val ruta: String) {
    object Login : Rutas("login")
    object UserMenu : Rutas("userMenu")
    object CharacterSelection : Rutas("characterSelection")
    object BattleMenu : Rutas("battle")
    object PirateInfo : Rutas("informacionPirata")


}