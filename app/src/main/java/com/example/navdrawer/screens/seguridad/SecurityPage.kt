package com.example.navdrawer.screens.seguridad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecurityPage() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = "Aviso de privacidad",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "En FRISA yCo., nos tomamos la seguridad de nuestros usuarios muy en serio. Queremos asegurarnos de que tu experiencia con nuestra aplicación sea segura y protegida en todo momento.:",
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = "Recuerda que FRISA nunca te pedirá información personal o contraseñas a través de correos electrónicos no solicitados o mensajes en la aplicación. Si recibes algún mensaje sospechoso, no lo respondas y repórtalo de inmediato.",
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}
