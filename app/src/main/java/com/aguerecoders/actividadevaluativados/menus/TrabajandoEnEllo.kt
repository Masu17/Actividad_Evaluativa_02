package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.R

@Composable
fun TrabajandoEnEllo (navController: NavHostController){
    Image(
        painter = painterResource(id = R.drawable.characterselectionbg),
        contentDescription = "",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().padding(50.dp))
        Image(painter = painterResource(id = R.drawable.trabajando),
            contentDescription = "Pagina en proceso",
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 50.dp),
            contentScale = ContentScale.Crop)
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Volver")
        }
    }
}