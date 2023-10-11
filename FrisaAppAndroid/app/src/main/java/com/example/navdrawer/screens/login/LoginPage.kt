package com.example.navdrawer.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navdrawer.AppViewModel
import androidx.compose.ui.unit.sp
import com.example.navdrawer.R
import com.example.navdrawer.model.UserLoginResponse
import com.example.navdrawer.ui.theme.GrisClaro

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.navdrawer.service.UserService
import com.example.navdrawer.viewModel.UserViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoginPage(navController: NavHostController,
              viewModel: AppViewModel,
              onLoggedInChanged: (Boolean) -> Unit) {

    val snackbarHostState = remember { SnackbarHostState() }
    val userviewModel = UserViewModel(UserService.instance)

    var phone by remember {
        mutableStateOf("10")
    }

    var password by remember {
        mutableStateOf("s10")
    }

    var loginResult by remember {
        mutableStateOf(UserLoginResponse())
    }
    LaunchedEffect(key1 = userviewModel) {
        userviewModel.loginResult.collect { result ->
            if (result != null) {
                if(result.id?.isNotEmpty()==true){
                    loginResult = result
                    loginResult.id?.let {
                        //snackbarHostState.showSnackbar("Login exitoso...")
                        /* viewModel.storeValueInDataStore(
                             it,
                             com.example.navdrawer.util.constants.Constants.TOKEN
                         )*/
                        viewModel.setToken(it)
                        viewModel.setLoggedIn()
                        onLoggedInChanged(true)
                        navController.navigate("MainPage")

                        Log.d("DATASTORE", "Token saved: ${it}")
                    }
                }

                /*        if (loginResult?.token != null) {
                    snackbarHostState.showSnackbar("Login exitoso...")
                }*/
            }
        }
    }
    if (!viewModel.isUserLoggedIn()) {
        // El usuario no está autenticado, mostrar la pantalla de inicio de sesión
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = GrisClaro)
        ) {
            //IMAGEN ORILLA 1 ROJA
            Image(
                painter = painterResource(id = R.drawable.orilla1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(160.dp)
                    .offset(y = (0.dp))
                    .offset(x = (-120).dp)
            )

            //IMAGEN DE LOGO DE FRISA
            Image(
                painter = painterResource(id = R.drawable.frisa1),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(137.dp)
                    .offset(y = (-(20).dp))
                    .align(Alignment.CenterHorizontally)
                //.padding(top = 10.dp)
            )

            // Texto de inicio de sesión
            Text(
                text = "Inicio de Sesión",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .offset(y = (-(10).dp))
                    .align(Alignment.CenterHorizontally)
            )


            /*
            Image(
                painter = painterResource(id = R.drawable.orilla2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(160.dp)
                    .offset(y = (700.dp))
                    .offset(x = (-120.dp))
            )

             */

            /*Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-(95).dp))
                    //.padding(top = 150.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }*/

            FlowRow(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    //.padding(top = 10.dp)
                    .fillMaxSize()
                    .background(color = GrisClaro),
                horizontalArrangement = Arrangement.Center,
                //verticalArrangement = Arrangement.Center
            ) {
                //Agregar TEXT INPUT


                // Crear el primer campo de entrada de texto (para télefono)
                OutlinedTextField(
                    value = phone,
                    onValueChange = { newValue ->
                        phone = newValue
                    },
                    label = { Text("Teléfono") }, // Etiqueta del campo
                    modifier = Modifier
                        .padding(5.dp)
                        .width(233.dp)
                        .height(59.dp)
                    //.offset(y = (-180.dp))
                    ,
                    shape = RoundedCornerShape(100)
                )

                // Crear el segundo campo de entrada de texto (para contraseña)
                OutlinedTextField(
                    value = password,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    label = { Text("Contraseña") },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(233.dp)
                        .height(59.dp)
                    //.offset(y = (-210.dp))
                    ,
                    shape = RoundedCornerShape(100)
                )

                //BOTON DE INICIO DE SESIÓN
                Button(
                    onClick = {
                        // Redirige a la página de inicio (HomePage) si se autentica con éxito
                       // viewModel.setLoggedIn()
                        //navController.navigate("MainPage")
                        //navController.navigate("MainPage")
                        userviewModel.loginUser(phone.trim().toInt(), password)
                    },
                    modifier = Modifier
                        //.offset(y = (-208.dp))
                        .padding(top = 10.dp)
                        .height(45.dp)
                        .width(180.dp)

                ) {
                    Text(
                        "INICIAR SESIÓN",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                }

                Text(
                    text = " ¿No tienes cuenta? Registrate aquí. ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        //.offset(y = (212.dp))
                        //.align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                        .clickable {
                            navController.navigate("RegisterPage")
                        }
                )

                Text(
                    text = " ¿Eres OSC? Haz click aquí. ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        //.offset(y = (220.dp))
                        //.align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                        .clickable {
                            navController.navigate("LoginPageOSC")
                        }
                )
            }

        }
    } else {
        // El usuario está autenticado, redirigirlo a la página de inicio con el navigation drawer
        //   navController.navigate("HomePage")
    }
}