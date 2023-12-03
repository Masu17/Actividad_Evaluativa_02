package com.aguerecoders.actividadevaluativados.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aguerecoders.actividadevaluativados.menus.BattleMenu
import com.aguerecoders.actividadevaluativados.menus.CharacterSelection
import com.aguerecoders.actividadevaluativados.menus.PirateInfo
import com.aguerecoders.actividadevaluativados.menus.Login
import com.aguerecoders.actividadevaluativados.menus.UserMenu
import com.aguerecoders.actividadevaluativados.models.Pirata
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun GrafoNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.Login.ruta) {

        composable(Rutas.Login.ruta) {
            Login(navController = navController)
        }


        composable(Rutas.UserMenu.ruta) {
            UserMenu(
                navController = navController, emptyList())
        }

        composable(Rutas.UserMenu.ruta + "/{piratas}") {

            val piratasString =
                it.arguments?.getString("piratas")
                    ?.removePrefix("{")
                    ?.removeSuffix("}") ?: ""
            println(piratasString)
            val piratasType = object : TypeToken<ArrayList<Pirata>>() {}.type

            UserMenu(
                navController = navController,
                equipoFinal = Gson().fromJson(
                    piratasString, piratasType
                )
            )
        }

        composable(Rutas.CharacterSelection.ruta) {
            CharacterSelection(navController = navController)

        }

        composable(Rutas.BattleMenu.ruta) {
            BattleMenu(navController = navController)
        }

        composable(Rutas.PirateInfo.ruta + "/{nombrePirata}") { backStackEntry ->
            val nombrePirata = backStackEntry.arguments?.getString("nombrePirata")
            PirateInfo(nombrePirata)
        }
    }
}

