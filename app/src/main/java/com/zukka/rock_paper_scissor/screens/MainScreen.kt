package com.zukka.rock_paper_scissor.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zukka.rock_paper_scissor.Screen


@Composable
fun MainScreen(navController: NavController) {

    var numberOfPlayers by remember {
        mutableStateOf(1)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)) {
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