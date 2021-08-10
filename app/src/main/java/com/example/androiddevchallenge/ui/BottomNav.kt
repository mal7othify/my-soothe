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

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale

data class NavItem(val icon: ImageVector, val title: String)

@Composable
fun BottomNav() {
    val items = listOf(
        NavItem(Icons.Default.Spa, "Home"),
        NavItem(Icons.Default.AccountCircle, "Profile")
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(bottom = 40.dp),
        elevation = 0.dp
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = index % 2 == 0,
                onClick = { },
                icon = {
                    Icon(item.icon, contentDescription = item.title.uppercase(Locale.ROOT))
                },
                label = {
                    Text(text = item.title, style = MaterialTheme.typography.caption)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    BottomNav()
}
