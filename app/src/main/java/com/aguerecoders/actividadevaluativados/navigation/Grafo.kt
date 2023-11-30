package com.aguerecoders.actividadevaluativados.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aguerecoders.actividadevaluativados.menus.BattleMenu
import com.aguerecoders.actividadevaluativados.menus.CharacterSelection
import com.aguerecoders.actividadevaluativados.menus.Login
import com.aguerecoders.actividadevaluativados.menus.UserMenu

@Composable
fun GrafoNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.CharacterSelection.ruta) {

        composable(Rutas.Login.ruta) {
            Login(navController = navController)
        }
        composable(Rutas.UserMenu.ruta) {
            UserMenu(navController = navController)
        }
        composable(Rutas.CharacterSelection.ruta) {
            CharacterSelection(navController = navController)
        }

        composable(Rutas.BattleMenu.ruta) {
            BattleMenu(navController = navController)
        }
    }
}