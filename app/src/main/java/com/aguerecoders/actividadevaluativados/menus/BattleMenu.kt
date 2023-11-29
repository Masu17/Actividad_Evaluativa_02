package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BattleMenu(navController: NavHostController) {
    SearchBarFuncionamiento(query = "Busqueda", onQueryChange = "", onSearch = "", active = "", onActiveChange = "") {
        
    }
}

fun SearchBarFuncionamiento(query: String, onQueryChange: String, onSearch: String, active: String, onActiveChange: String, function: () -> Unit) {

}

@ExperimentalMaterial3Api
@Composable
fun SearchBarFuncionamiento(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: androidx.compose.ui.graphics.Shape = SearchBarDefaults.inputFieldShape,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    tonalElevation: Dp = SearchBarDefaults.Elevation,
    windowInsets: androidx.compose.foundation.layout.WindowInsets = SearchBarDefaults.windowInsets,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
){}