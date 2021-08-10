/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Locale

@Composable
fun Login(isDark: Boolean, navController: NavController) {
    val bg = if (isDark) {
        R.drawable.ic_dark_login
    } else {
        R.drawable.ic_light_login
    }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Image(
        modifier = Modifier.fillMaxSize(),
        imageVector = ImageVector.vectorResource(bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LOG IN".uppercase(Locale.ROOT),
            style = typography.h1,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 8.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email address", style = typography.body1) },
            colors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colors.primary)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 8.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", style = typography.body1) },
            colors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colors.primary),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = {
                if (email != "") {
                    navController.navigate("home/$email")
                } else {
                    Toast.makeText(context, "fill email & password", Toast.LENGTH_LONG).show()
                }
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary),
            modifier = Modifier.fillMaxWidth().requiredHeight(72.dp).padding(bottom = 16.dp)
        ) { Text("LOG IN".uppercase(Locale.ROOT)) }
        Row(Modifier.clickable { }) {
            Text(
                text = "Don't have an account? ", style = typography.body1
            )
            Text(
                text = "Sign up",
                style = typography.body1,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}
