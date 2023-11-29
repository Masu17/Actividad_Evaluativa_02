package com.aguerecoders.actividadevaluativados.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aguerecoders.actividadevaluativados.R

@Composable
fun GenericTextFieldComponent(
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
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        )
    )
}
