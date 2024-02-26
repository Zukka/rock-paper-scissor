package com.zukka.rock_paper_scissor

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object GameScreen: Screen("game_screen")

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
