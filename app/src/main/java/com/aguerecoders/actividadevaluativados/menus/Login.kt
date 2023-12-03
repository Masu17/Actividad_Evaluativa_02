package com.aguerecoders.actividadevaluativados.menus

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aguerecoders.actividadevaluativados.R
import com.aguerecoders.actividadevaluativados.components.GenericButtonComponent
import com.aguerecoders.actividadevaluativados.components.GenericTextFieldComponent
import com.aguerecoders.actividadevaluativados.navigation.Rutas

@Composable
fun Login(navController: NavHostController) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


    Image(
        painter = painterResource(id = R.drawable.bgimages),
        contentDescription = " ",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(50.dp))
        Text(
            text = "One Piece Fighters",
            fontSize = 32.sp,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .height(80.dp)
                .width(300.dp)
                .background(Color(166, 73, 84)),
            color = Color(220, 227, 223),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(
                Font(R.font.alfa_slab_one, FontWeight.Normal)
            ),
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 1.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    )
                )
            )
        )
        Spacer(Modifier.height(20.dp))
        GenericTextFieldComponent(placeholder = "Inserte un usuario",
            textContent = username,
            labelContent = "Usuario",
            leadingIcon = Icons.Filled.AccountCircle,
            textAction = { username = it })
        Spacer(Modifier.height(5.dp))
        GenericTextFieldComponent(placeholder = "Inserte una contraseña",
            textContent = password,
            labelContent = "Contraseña",
            leadingIcon = Icons.Filled.Lock,
            textAction = { password = it })
        Spacer(Modifier.height(20.dp))
        GenericButtonComponent(texto = "Iniciar sesion") {
            if (username == "admin" && password == "admin") {
                navController.navigate(Rutas.UserMenu.ruta)
            } else {
                Toast.makeText(
                    navController.context,
                    "Usuario o contraseña incorrectos, pruebe porfavor con us: admin, pw: admin",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


