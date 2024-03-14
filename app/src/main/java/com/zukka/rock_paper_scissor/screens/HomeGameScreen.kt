package com.zukka.rock_paper_scissor.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import com.zukka.rock_paper_scissor.GameMove
import com.zukka.rock_paper_scissor.R
import com.zukka.rock_paper_scissor.getRandomGameMove
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private var tappedValue by mutableStateOf("")
@Composable
fun HomeGameScreen(numberOfPlayers: Int) {
    val (playerOneMove, setPlayerOneMove) = remember { mutableStateOf<GameMove?>(null) }
    val (playerTwoMove, setPlayerTwoMove) = remember { mutableStateOf<GameMove?>(null) }
    val (isPlayingWithFriend, setIsPlayingWithFriend) = remember { mutableStateOf(false) }

    if (numberOfPlayers == 2) {
        GameScreen(playerOneMove, playerTwoMove)
    } else {
        GetPlayerMove()
    }
}

@Composable
fun GetPlayerMove() {
    val (playerMove, setPlayerMove) = remember { mutableStateOf<GameMove?>(null) }
    val appMove = getRandomGameMove()
    println(appMove)
    val result = playerMove?.let { determineWinner(it, appMove) }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(result ?: "", fontSize = 24.sp, modifier = Modifier.padding(vertical = 16.dp))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.rock),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clickable { setPlayerMove(GameMove.Rock) },
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.paper),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clickable { setPlayerMove(GameMove.Paper) },
                contentScale = ContentScale.Fit
            )
        }
        Image(
            painter = painterResource(id = R.drawable.scissors),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
                .clickable { setPlayerMove(GameMove.Scissors) },
            contentScale = ContentScale.Fit
        )

        runBlocking {
            delay(500)
            setPlayerMove(null)
        }
    }
}

@Composable
fun GameScreen(playerOneMove: GameMove?, playerTwoMove: GameMove?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (playerOneMove != null && playerTwoMove != null) {
            Text("Player One: ${playerOneMove::class.simpleName}", fontSize = 20.sp)
            when (playerOneMove) {
                is GameMove.Rock -> painterResource(id = R.drawable.rock)
                is GameMove.Paper -> painterResource(id = R.drawable.paper)
                is GameMove.Scissors -> painterResource(id = R.drawable.scissors)
                else -> null
            }?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Text("Player Two: ${playerTwoMove::class.simpleName}", fontSize = 20.sp)
            when (playerTwoMove) {
                is GameMove.Rock -> painterResource(id = R.drawable.rock)
                is GameMove.Paper -> painterResource(id = R.drawable.paper)
                is GameMove.Scissors -> painterResource(id = R.drawable.scissors)
                else -> null
            }?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            val result = determineWinner(playerOneMove, playerTwoMove)
            Text(result, fontSize = 24.sp, modifier = Modifier.padding(vertical = 16.dp))
        } else {
            Text("Waiting for players to make their move...")
        }
    }
}

fun determineWinner(playerOneMove: GameMove, playerTwoMove: GameMove): String {
    return when {
        playerOneMove == playerTwoMove -> "It's a tie!"
        playerOneMove is GameMove.Rock && playerTwoMove is GameMove.Scissors ||
                playerOneMove is GameMove.Paper && playerTwoMove is GameMove.Rock ||
                playerOneMove is GameMove.Scissors && playerTwoMove is GameMove.Paper -> "Player wins!"
        else -> "App wins!"
    }
}
