package com.example.navdrawer.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.navdrawer.AppViewModel

@Composable
fun ProfilePage(viewModel: AppViewModel) {

    Column {
        Text(text = "Aquí se muestran los datos del usuario")

        Button(onClick = { viewModel.setLoggedOut() }) {
            Text("Log Out")
        }
    }
}