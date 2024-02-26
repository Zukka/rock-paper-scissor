import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zukka.rock_paper_scissor.screens.MainScreen
import com.zukka.rock_paper_scissor.Screen
import com.zukka.rock_paper_scissor.screens.GameScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.GameScreen.route + "/{numberOfPlayers}",
        arguments = listOf(
            navArgument("numberOfPlayers") {
                type = NavType.IntType
                defaultValue = 1
            })
        ) { entry ->
            entry.arguments?.let { GameScreen(numberOfPlayers = it.getInt("numberOfPlayers")) }
        }
    }
}
