package com.example.navdrawer.screens.home

import android.accounts.AuthenticatorDescription
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun FavsPage(navController: NavController, viewModel: AppViewModel) {

    val loggedIn = remember {
        mutableStateOf(viewModel.isUserLoggedIn())
    }

    Column {
        Text(text = "Welcome to HomePage")
        //Text(text = "Is Logged In: ${loggedIn.value}")

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
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = organizaciones) {
                    FavRow(orgname = it) { orgname ->
                        Log.d("Organizaciones", "$orgname")
                        //navController.navigate("movieDetail/$movie") // Navega a la pantalla de detalles con el nombre de la película
                        navController.navigate("AboutPage/" + orgname)
                    }
                }
            }
        }
    }



}




@Composable
fun FavRow(
    orgname: String,
    onItemClick: (String) -> Unit = {}
) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(320.dp)
            .offset(x = (3.dp))
            .clickable { }
            .fillMaxWidth()
            .clickable {
                onItemClick(orgname)
            },
        shape = RoundedCornerShape(20.dp)


    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .height(200.dp) // Adjust the height as needed
                    .fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.arena1),
                    contentDescription = "Imagen de la organización",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()

                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                    tint = Color.White, // Change the color as needed
                    modifier = Modifier
                        .size(40.dp) // Adjust the size as needed
                        .graphicsLayer {
                            translationX = 530f // Adjust the X position as needed
                            translationY = 20f // Adjust the Y position as needed
                        }
                )





            }

            Column(
                modifier = Modifier
                    .padding(8.dp)


            ) {

                Text(text = orgname, style = TextStyle( fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Red ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)

                )


                Row(
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){


                }
                Box(){
                    Row() {


                    }

                }



            }
        }
    }
}











/* {

        Card(
            modifier = Modifier
                .padding(4.dp)
                .width(320.dp)
                .fillMaxWidth()
                .height(130.dp)
                .clickable {
                    onItemClick(orgname)
                },
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center, // Alineación vertical al centro
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp),
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.frisa), // Reemplaza "arena" con el nombre real de tu imagen, incluyendo la extensión ".jpeg"
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )


                }
                Text(text = orgname)
            }
        }
    }

 */


