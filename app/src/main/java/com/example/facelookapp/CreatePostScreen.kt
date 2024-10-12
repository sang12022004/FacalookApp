package com.example.facelookapp

import android.os.Parcelable.Creator
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePostScreen(navtController: NavHostController){
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                TopAppBar(
                    title = { Text(text = "Create Post")},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navtController.popBackStack()
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")

                        }
                    },
                    actions = {
                        Button(onClick = {}, enabled = true) {
                            Text(text = "Post")
                        }
                    }
                )
                Divider()
            }
        }
    ){
        TextField(
            value = "", onValueChange = {},
            maxLines = Int.MAX_VALUE,
            modifier = Modifier.padding(it).padding(5.dp).fillMaxSize(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
    }
}