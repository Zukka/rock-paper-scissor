package com.zukka.rock_paper_scissor.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zukka.rock_paper_scissor.R
import com.zukka.rock_paper_scissor.Screen


@Composable
fun MainScreen(navController: NavController) {

    var numberOfPlayers by remember {
        mutableStateOf(1)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(
            id = R.drawable.background),
            contentDescription = "App background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
            )
        Image(painter = painterResource(
            id = R.drawable.title),
            contentDescription = "App title",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(64.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 48.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                numberOfPlayers = 1
                println(numberOfPlayers)
                navController.navigate(Screen.GameScreen.withArgs(numberOfPlayers))
            }) {
                Text("One Player")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                numberOfPlayers = 2
                println(numberOfPlayers)
                navController.navigate(Screen.GameScreen.withArgs(numberOfPlayers))
            }) {
                Text("Two Players")
            }
        }
    }
}