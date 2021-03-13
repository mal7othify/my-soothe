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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import java.util.Locale

@Composable
fun Welcome(isDark: Boolean, navController: NavController) {
    val bg = if (isDark) {
        R.drawable.ic_dark_welcome
    } else {
        R.drawable.ic_light_welcome
    }
    val logo = if (isDark) {
        R.drawable.ic_dark_logo
    } else {
        R.drawable.ic_light_logo
    }
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
        Image(
            imageVector = ImageVector.vectorResource(logo),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = {},
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary),
            modifier = Modifier.fillMaxWidth().height(72.dp).padding(bottom = 8.dp)
        ) { Text(text = "Sign up".toUpperCase(Locale.ROOT)) }
        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary),
            modifier = Modifier.fillMaxWidth().height(72.dp)
        ) { Text("Log in".toUpperCase(Locale.ROOT)) }
    }
}
