package com.example.navdrawer.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.navdrawer.R



@Composable
fun AboutPage(orgname: String = "Sin Nombre", navController: NavHostController) {

    Column {
        Text(text = "Aquí se muestra la info de una organización")
    }
    Box(contentAlignment= Alignment.Center,
        modifier= Modifier.fillMaxSize()){
        Text(text="Nombre Organización: $orgname")
    }
}



@Composable
fun detalles(){





}




