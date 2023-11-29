package com.aguerecoders.actividadevaluativados.menus

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.aguerecoders.actividadevaluativados.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Login() {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(50.dp))
        Text(text = "Login", fontSize = 64.sp)
        Spacer(Modifier.height(20.dp))
        TextFields(
            placeholder = "Inserte un usuario",
            textContent = username,
            labelContent = "Usuario",
            leadingIcon = Icons.Filled.AccountCircle,
            textAction = { username = it }
        )
        Spacer(Modifier.height(5.dp))
        TextFields(
            placeholder = "Inserte una contraseña",
            textContent = password,
            labelContent = "Contraseña",
            leadingIcon = Icons.Filled.Lock,
            textAction = { password = it }
        )
        Spacer(Modifier.height(20.dp))
        genericButton(texto = "Iniciar sesion") {
            if (username == "admin" && password == "admin") {

            } else {
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFields(
    placeholder: String,
    textContent: String,
    labelContent: String,
    leadingIcon: ImageVector,
    textAction: (String) -> Unit
) {

    var passwordIcon by remember {
        if (labelContent == "Contraseña") {
            mutableStateOf(R.drawable.baseline_visibility_24)
        } else {
            mutableStateOf(0)
        }
    }

    var passwordTransformation by remember {
        if (labelContent == "Contraseña") {
            mutableStateOf<VisualTransformation>(PasswordVisualTransformation())
        } else {
            mutableStateOf(VisualTransformation.None)
        }
    }

    TextField(
        label = { Text(text = labelContent) },
        value = textContent,
        onValueChange = textAction,
        placeholder = { Text(text = placeholder) },
        leadingIcon = { Icon(leadingIcon, contentDescription = null) },
        visualTransformation = passwordTransformation,
        trailingIcon = {
            if (labelContent == "Contraseña") {
                IconButton(
                    onClick = {
                        if (passwordIcon == R.drawable.baseline_visibility_24) {
                            passwordIcon = R.drawable.baseline_visibility_off_24
                            passwordTransformation = VisualTransformation.None
                        } else {
                            passwordIcon = R.drawable.baseline_visibility_24
                            passwordTransformation = PasswordVisualTransformation()
                        }
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = passwordIcon),
                            contentDescription = null
                        )
                    }
                )
            }
        },
        modifier = Modifier
            .width(300.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(fontSize = 20.sp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            textColor = Color.Black,
            placeholderColor = Color.Black,
        )

    )
}

@Composable
fun genericButton(texto: String, onClickActionLambda: () -> Unit) {

    Button(onClick = onClickActionLambda, colors = ButtonDefaults.buttonColors(Color.Blue)) {
        Text(text = texto, fontSize = 20.sp, color = Color.White)
    }

}
