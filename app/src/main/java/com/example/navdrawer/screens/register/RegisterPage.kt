package com.example.navdrawer.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navdrawer.AppViewModel
import com.example.navdrawer.R
import com.example.navdrawer.ui.theme.BlancoGris
import com.example.navdrawer.ui.theme.GrisClaro

import com.example.navdrawer.ui.theme.RojoFrisa

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RegisterPage(navController: NavController,
                 viewModel: AppViewModel
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = GrisClaro)
    ) {
        Image(
            painter = painterResource(id = R.drawable.orilla1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(160.dp)
                .offset(y = (0.dp))
                .offset(x = ((-120).dp))
        )

        // Texto de Registro
        Text(
            text = "Registro",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = ((-100).dp))
        )

        // Imagen de línea roja
        Image(
            painter = painterResource(id = R.drawable.linea_roja),
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = ((-190).dp))
        )
    }

    FlowRow(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 130.dp)
            .fillMaxSize()
            .background(color = GrisClaro),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
        ) {
        // Text Input y otros elementos
        val name = remember { mutableStateOf("") }
        val last_name = remember { mutableStateOf("") }
        val phone = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val necesidad = remember { mutableStateOf("") }

        OutlinedTextField(
            value = name.value,
            onValueChange = { newValue ->
                name.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Nombre") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(59.dp)
                //.offset(y = (130).dp)
            ,
            shape = RoundedCornerShape(90)
        )

        OutlinedTextField(
            value = last_name.value,
            onValueChange = { newValue ->
                last_name.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Apellido") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(59.dp)
                //.offset(y = (140).dp)
            ,
            shape = RoundedCornerShape(90)
        )

        OutlinedTextField(
            value = phone.value,
            onValueChange = { newValue ->
                phone.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Teléfono") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(59.dp)
                //.offset(y = (140).dp)
            ,
            shape = RoundedCornerShape(90)
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = { newValue ->
                email.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Correo") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(59.dp)
                //.offset(y = (140).dp)
            ,
            shape = RoundedCornerShape(90)
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { newValue ->
                password.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Contraseña") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(59.dp)
                //.offset(y = (140).dp)
            ,
            shape = RoundedCornerShape(90)
        )

        OutlinedTextField(
            value = necesidad.value,
            onValueChange = { newValue ->
                necesidad.value = newValue
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlancoGris,
                unfocusedBorderColor = BlancoGris,
                focusedContainerColor = BlancoGris,
                unfocusedContainerColor = BlancoGris
            ),
            label = { Text("Descripción de Necesidad") },
            modifier = Modifier
                .padding(5.dp)
                .width(330.dp)
                .height(150.dp)
                //.offset(y = (140).dp)
            ,
            shape = RoundedCornerShape(20)
        )

        // Botón de Registro
        Button(
            onClick = {
                // Redirige a la página de registro (RegisterPage)
                viewModel.setLoggedIn()
                navController.navigate("TagsPage")
            },
            colors = ButtonDefaults.buttonColors(RojoFrisa),
            modifier = Modifier
                .padding(16.dp)
                .width(160.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(100))
                .background(color = BlancoGris)
        ) {
            Text("REGISTRARSE",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp)
        }

        // Imagen de orilla2
        /*
        Image(
            painter = painterResource(id = R.drawable.orilla2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(190.dp)
        ) */
    }
}