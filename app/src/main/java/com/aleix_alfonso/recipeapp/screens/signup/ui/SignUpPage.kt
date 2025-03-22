package com.aleix_alfonso.recipeapp.screens.signup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aleix_alfonso.recipeapp.R
import com.aleix_alfonso.recipeapp.screens.signup.SignUpPageViewModel
import com.aleix_alfonso.recipeapp.ui.components.CrossfitAppScreenContainer

@Composable
fun SignUpPage(
    modifier: Modifier = Modifier,
    onSignUpClick: (String, String) -> Unit,
    navigateToLogin: () -> Unit,
    viewModel: SignUpPageViewModel = viewModel(),
) {

    CrossfitAppScreenContainer(scrollEnabled = false, content = {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.crossfit_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(24.dp)
                    .clip(
                        CircleShape
                    )
            )
            Text("Registro", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))

            CustomTextFieldSignUp(
                viewModel = viewModel,
                value = viewModel.email,
                onValueChange = { viewModel.onEmailChange(it) },
            )
            Spacer(modifier = Modifier.height(24.dp))
            CustomTextFieldSignUp(
                viewModel = viewModel,
                value = viewModel.password,
                isPassword = true,
                onValueChange = { viewModel.onPasswordChange(it) },
            )

            Spacer(modifier = Modifier.height(24.dp))
            SignUpButton(onSignUpClick = { onSignUpClick(viewModel.email, viewModel.password) })
            Spacer(modifier = Modifier.height(8.dp))

            LoginButtonSignUpPage(navigateToLogin)


        }
    }

    )

}

@Composable
fun SignUpButton(onSignUpClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = {
        onSignUpClick()
    }, modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
        Text(text = "Registrarse")
    }
}

@Composable
fun CustomTextFieldSignUp(
    viewModel: SignUpPageViewModel,
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
) {
    TextField(
        leadingIcon = {
            val icon = if (isPassword) Icons.Filled.Password else Icons.Filled.Person
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        trailingIcon = {
            if (isPassword) {
                val visibilityIcon =
                    if (viewModel.isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { viewModel.onVisibilityClick() }) {
                    Icon(imageVector = visibilityIcon, contentDescription = null)
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Email),
        label = {
            val label = if (isPassword) "Contraseña" else "Correo electrónico"
            Text(text = label)
        },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (!viewModel.isPasswordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,

        )

}


@Composable
fun LoginButtonSignUpPage(navigateToSignup: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = {
        navigateToSignup()
    }, modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
        Text(text = "Ya tengo una cuenta")
    }
}

