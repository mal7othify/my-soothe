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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.AlignBody
import com.example.androiddevchallenge.model.AlignMind
import com.example.androiddevchallenge.model.FaveCollection
import com.example.androiddevchallenge.model.data.Card
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Locale

@Composable
fun Home(email: String) {
    var search by remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                onClick = {}
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_play_arrow_24),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomNav() }
    ) {
        Column(Modifier.padding(16.dp).fillMaxSize().verticalScroll(rememberScrollState())) {
            TextField(
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_search_24),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.requiredSize(18.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 56.dp),
                value = search,
                onValueChange = { search = it },
                label = { Text("Search", style = typography.body1) },
                colors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colors.onSurface)
            )
            Text(
                "Favorite Collections".uppercase(Locale.ROOT),
                style = typography.h2,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            )
            Column(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                Row {
                    FaveCollectionRow(FaveCollection.take(3))
                }
                Row {
                    FaveCollectionRow(FaveCollection.takeLast(3))
                }
            }
            Text(
                "Align your body".uppercase(Locale.ROOT),
                style = typography.h2,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            )
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                AlignRow(AlignBody)
            }
            Text(
                "Align your mind".uppercase(Locale.ROOT),
                style = typography.h2,
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            )
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                AlignRow(AlignMind)
            }
        }
    }
}

@Composable
fun FaveCollectionRow(collections: List<Card>) {
    collections.forEach { card ->
        Card(
            backgroundColor = MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.small,
            elevation = 2.dp,
            modifier = Modifier.requiredWidth(192.dp)
                .requiredHeight(56.dp)
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    bitmap = ImageBitmap.imageResource(card.image),
                    contentDescription = null,
                    modifier = Modifier.requiredSize(56.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = card.title,
                    style = typography.h3,
                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun AlignRow(align: List<Card>) {
    align.forEach { card ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(card.image),
                contentDescription = null,
                modifier = Modifier.clip(shape = CircleShape)
                    .requiredSize(88.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = card.title, style = typography.h3, modifier = Modifier.padding(top = 16.dp))
        }
    }
}
