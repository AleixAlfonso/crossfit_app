package com.aleix_alfonso.recipeapp.screens.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aleix_alfonso.recipeapp.screens.login.LoginViewModel
import com.aleix_alfonso.recipeapp.ui.components.CrossfitAppScreenContainer
import com.aleix_alfonso.recipeapp.ui.components.TopBarCustom


@Preview(showSystemUi = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, viewModel: LoginViewModel = viewModel()) {

    CrossfitAppScreenContainer(topBar = {
        TopBarCustom(
            title = "Login Page",
            onArrowBackClick = { },
            arrowBackEnabled = false,
        )
    }, content = {
        Box(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            ) {
                TextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person ,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Email") },
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
                    value = viewModel.email,
                    onValueChange = { viewModel.onEmailChange(it) }
                )
                Spacer(modifier = Modifier.height(24.dp))

                TextField(

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Password,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Password") },
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
                    value = viewModel.email,
                    onValueChange = { viewModel.onEmailChange(it) }
                )
            }
        }
    })

}