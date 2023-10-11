package com.example.navdrawer.screens.posts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawer.R


@Composable
fun PostsPage() {
    Column {
        Text(text = "")
    }



    LazyColumn {
        items(10) {
            CardOrganizaciones()
        }
    }

    ModalBottomSheetM3()

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetM3() {
    var openBottomSheet by remember { mutableStateOf(false) }


    val icon = Icons.Filled.Add


        Button(
            onClick = { openBottomSheet = true },
            shape = CircleShape, // Set the shape to make it circular
            contentPadding = PaddingValues(16.dp),// Optional padding to make it larger
            modifier = Modifier
                .offset(y = (540.dp))
                .offset(x = (280.dp))


        ) {
            Icon(
                imageVector = icon,
                contentDescription = null, // You can provide a content description if needed
                tint = Color.White // Optional: You can set the icon color
            )
        }


    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { openBottomSheet = false },

        ) {
            BottomSheetContent(
                onHideButtonClick = { }
            )
        }
    }
}




@Composable
fun BottomSheetContent(onHideButtonClick: () -> Unit){
    var text by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Campo de texto contorneado
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Ingrese su texto") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White)

        )

        // Botón para ocultar el Bottom Sheet
        Button(
            onClick = onHideButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Text("")
        }
    }





}


@Composable
fun CardOrganizaciones() {



    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(320.dp)
            .offset(x = (12.dp))
            .clickable { }
            .fillMaxWidth(),

        /*elevation = 8.dp*/
        shape = RoundedCornerShape(20.dp)

    ) {

        Column(
            verticalArrangement = Arrangement.Center, // Alineación vertical al centro
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.articulo
                ),

                contentDescription = "Imagen de la organización"
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)


            ) {
                Text("Artículo", style = TextStyle( fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)

                )
                Text("¿Qué es el autismo?", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(bottom = 8.dp)

                )


                Row(
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Box(){
                        Row() {
                            TextButton(
                                onClick = {}
                            ) {
                                Text("Leer más")

                            }
                            TextButton(onClick = {}) {

                            }

                        }

                    }
                    Box(){
                        Row() {
                            IconButton(onClick = {}) {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Boton Favorito",
                                        tint = Color.Red


                                    )

                                }

                            }
                            IconButton(onClick = {}) {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Share,
                                        contentDescription = "Boton Share",
                                        tint = Color.Red
                                    )

                                }


                            }
                        }
                    }
                }

            }

        }

    }
}


@Composable
fun PreviewCardOrganizaciones(){
    NavegacionInferiorTheme {
        CardOrganizaciones()

    }

}

@Composable
fun NavegacionInferiorTheme(content: @Composable () -> Unit) {
    MaterialTheme(

        typography = MaterialTheme.typography,
        content = content
    )
}




/*
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {


                // Lógica que se ejecutará cuando se haga clic en el FAB
                // Por ejemplo, puedes navegar a otra pantalla o realizar alguna acción
            },
            modifier = Modifier
                .size(56.dp),





        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }

 */


