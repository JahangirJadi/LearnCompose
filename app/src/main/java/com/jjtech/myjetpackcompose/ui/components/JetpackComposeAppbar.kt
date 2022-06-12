package com.jjtech.myjetpackcompose.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JetpackComposeAppbar(title:String){
    TopAppBar(title = { Text(text = title)}, navigationIcon = {
        IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu button")
        }
    }) 
}

@Preview
@Composable
fun JetpackComposeAppbarPreview(){
    JetpackComposeAppbar(title = "Toolbar")
}