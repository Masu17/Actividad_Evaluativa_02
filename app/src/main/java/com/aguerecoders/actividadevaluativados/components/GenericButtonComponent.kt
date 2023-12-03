package com.aguerecoders.actividadevaluativados.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun GenericButtonComponent(texto: String, onClickActionLambda: () -> Unit) {
    Button(onClick = onClickActionLambda, colors = ButtonDefaults.buttonColors(Color(166, 73, 84))) {
        Text(text = texto, fontSize = 20.sp, color = Color.White)
    }
}