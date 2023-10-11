package com.example.navdrawer.screens.home

import android.accounts.AuthenticatorDescription
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navdrawer.AppViewModel
import com.example.navdrawer.R
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.navdrawer.ui.theme.BlancoGris
import com.example.navdrawer.ui.theme.GrisClaro
import com.example.navdrawer.ui.theme.Purple80
import com.example.navdrawer.ui.theme.RojoFrisa


@Composable
fun HomePage(navController: NavController, viewModel: AppViewModel) {


    val loggedIn = remember {
        mutableStateOf(viewModel.isUserLoggedIn())
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(GrisClaro)
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
    }

    val organizaciones: List<String> = listOf(
        "Organizacion A",
        "Organizacion B",
        "Organizacion C",
        "Organizacion D ",
        "Organizacion E",
        "Organizacion F"
    )

    Surface(
        modifier = Modifier.background(GrisClaro)
    ) {

        header()



        Column(modifier = Modifier.padding(12.dp)) {
            LazyRow(
                modifier = Modifier
                    .padding(top = 100.dp),
                content = {
                items(items = organizaciones) {
                    OrgRow(orgname = it) { orgname ->
                        Log.d("Organizaciones", "$orgname")
                        //navController.navigate("movieDetail/$movie") // Navega a la pantalla de detalles con el nombre de la película
                        navController.navigate("AboutPage/" + orgname)
                    }
                }
            },
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            )
            PostsPage()

        }
        ModalBottomSheetM3()
    }
}
@Composable
fun OrgRow(
    orgname: String,
    onItemClick: (String) -> Unit = {}
) {
    Row {
        Card(
            modifier = Modifier
                .padding(1.dp)
                .width(287.dp) // Reduce the width
                .height(250.dp) // Reduce the height
                .clickable {
                    onItemClick(orgname)
                },
            colors = CardDefaults.cardColors(containerColor = BlancoGris),
            shape = RoundedCornerShape(20.dp),
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .height(200.dp) // Adjust the height as needed
                        .fillMaxWidth()
                        .background(BlancoGris)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.arena1),
                        contentDescription = "Imagen de la organización",
                        contentScale = ContentScale.Crop,
                        //modifier = Modifier.fillMaxHeight()

                    )

                    /*
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite Icon",
                        tint = Color.White, // Change the color as needed
                        modifier = Modifier
                            .size(40.dp) // Adjust the size as needed
                            .graphicsLayer {
                                translationX = 480f // Adjust the X position as needed
                                translationY = 10f // Adjust the Y position as needed
                            }
                    )
                    */

                }

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {

                    Text(
                        text = orgname,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = RojoFrisa
                        ),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun header(){
    Column(
        //modifier = Modifier.background(GrisClaro)
        ) {
        Image(
            painter = painterResource(id = R.drawable.orillainicio),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(160.dp)
                .offset(y = (-55.dp))
                .offset(x = (-80).dp)
        )
        FlowRow {
            Text(
                text = "     ¡Hola, ",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .offset(y = -160.dp),
            )
            Text(
                text = "usuario",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = Color.White),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .offset(y = -160.dp),
            )
            Text(
                text = "!",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Black),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .offset(y = -160.dp),
            )
        }
        Text(text = "Recomendaciones", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold), color = Color.Black,
            modifier = Modifier
                .padding(20.dp)
                .offset(y = -140.dp)
        )
    }
}

@Composable
fun PostsPage() {
    Column {
        Text(text = "Publicaciones", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
        )
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
    val icon = Icons.Default.Add


    Button(
        onClick = { openBottomSheet = true },
        shape = CircleShape, // Set the shape to make it circular
        contentPadding = PaddingValues(16.dp),// Optional padding to make it larger
        modifier = Modifier
            .offset(y = (15.dp))
            .offset(x = (280.dp)),
            colors = ButtonDefaults.buttonColors(RojoFrisa)


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
fun BottomSheetContent(onHideButtonClick: () -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Publicación", fontWeight = FontWeight.ExtraBold, color = Color.Black,fontSize = 22.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally))
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RojoFrisa,
                    unfocusedBorderColor = BlancoGris,
                    focusedContainerColor = BlancoGris,
                    unfocusedContainerColor = BlancoGris
                ),
                label = { Text("Título") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                shape = RoundedCornerShape(90)

            )

            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RojoFrisa,
                    unfocusedBorderColor = BlancoGris,
                    focusedContainerColor = BlancoGris,
                    unfocusedContainerColor = BlancoGris
                ),
                label = { Text("Contenido") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(bottom = 10.dp),
                shape = RoundedCornerShape(10)

            )

            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = RojoFrisa,
                    unfocusedBorderColor = BlancoGris,
                    focusedContainerColor = BlancoGris,
                    unfocusedContainerColor = BlancoGris
                ),
                label = { Text("Imágen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                shape = RoundedCornerShape(90)

            )


            // Botón para ocultar el Bottom Sheet
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(RojoFrisa),
                modifier = Modifier
                    .padding(16.dp)
                    .width(160.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(100))

                    .align(Alignment.CenterHorizontally)
            ) {
                Text("PUBLICAR",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun CardOrganizaciones() {
    Card(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .height(230.dp) // Reduce the height
            //.offset(x = (10.dp))
            .clickable { }
            .fillMaxWidth(),
        /*elevation = 8.dp*/
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = BlancoGris)
    ) {
        Column(
            verticalArrangement = Arrangement.Center, // Alineación vertical al centro
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.imagenorg
                ),
                contentDescription = "Imagen de la organización",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                )
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text("Artículo", style = TextStyle( fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Red )
                )

                Text("¿Qué es el autismo?", style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.Black),
                    modifier = Modifier
                )
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



