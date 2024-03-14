import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zukka.rock_paper_scissor.screens.MainScreen
import com.zukka.rock_paper_scissor.Screen
import com.zukka.rock_paper_scissor.screens.HomeGameScreen

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
            entry.arguments?.let { HomeGameScreen(numberOfPlayers = it.getInt("numberOfPlayers")) }
        }
    }
}
