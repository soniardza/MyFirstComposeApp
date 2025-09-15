package com.soniadevs.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.SettingScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.model.SettingModel
import com.soniadevs.myfirstcomposeapp.components.navigation.types.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(navigateToDetail = { navController.navigate(Home) })
        }
        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id -> navController.navigate(Detail(id = id)) }
            )
        }
        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute()
            DetailScreen(detail.id,
                navigateToSettings = { navController.navigate(Settings(it)) })
        }
        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navBackStackEntry ->
            val setting = navBackStackEntry.toRoute<Settings>()
            SettingScreen(setting.settingModel)
        }
    }
}
