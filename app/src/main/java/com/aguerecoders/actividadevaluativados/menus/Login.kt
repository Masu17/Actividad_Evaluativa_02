package com.aguerecoders.actividadevaluativados.menus

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.components.GenericButtonComponent
import com.aguerecoders.actividadevaluativados.components.GenericTextFieldComponent

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Login(navController: NavHostController) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(50.dp))
        Text(text = "Login", fontSize = 64.sp)
        Spacer(Modifier.height(20.dp))
        GenericTextFieldComponent(
            placeholder = "Inserte un usuario",
            textContent = username,
            labelContent = "Usuario",
            leadingIcon = Icons.Filled.AccountCircle,
            textAction = { username = it }
        )
        Spacer(Modifier.height(5.dp))
        GenericTextFieldComponent(
            placeholder = "Inserte una contraseña",
            textContent = password,
            labelContent = "Contraseña",
            leadingIcon = Icons.Filled.Lock,
            textAction = { password = it }
        )
        Spacer(Modifier.height(20.dp))
        GenericButtonComponent(texto = "Iniciar sesion") {
            if (username == "admin" && password == "admin") {
                navController.navigate("UserMenu")
            } else {
                Toast.makeText(
                    navController.context,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


