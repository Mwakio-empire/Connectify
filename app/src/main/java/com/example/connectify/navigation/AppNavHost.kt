package com.example.connectify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.connectify.ui.theme.screens.SoftEngineering.EngineeringScreen
import com.example.connectify.ui.theme.screens.creative.CreativeScreen
import com.example.connectify.ui.theme.screens.explore.CategoriesScreen
import com.example.connectify.ui.theme.screens.finance.FinanceScreen
import com.example.connectify.ui.theme.screens.home.HomeScreen
import com.example.connectify.ui.theme.screens.imm.SecondLanding
import com.example.connectify.ui.theme.screens.immediate.LandingScreen
import com.example.connectify.ui.theme.screens.login.LoginScreen
import com.example.connectify.ui.theme.screens.products.AddProductsScreen
import com.example.connectify.ui.theme.screens.products.ViewProductsScreen
import com.example.connectify.ui.theme.screens.research.ResearchScreen
import com.example.connectify.ui.theme.screens.signup.SignupScreen
import com.example.connectify.ui.theme.screens.top.SearchesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = LANDING_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }
        composable(CATEGORIES_URL){
            CategoriesScreen(navController = navController)
        }
        composable(SECOND_LANDING_URL){
            SecondLanding(navController = navController)
        }

        composable(ENGINEERING_URL){
            EngineeringScreen(navController = navController)
        }
        composable(FINANCE_URL){
            FinanceScreen(navController = navController)
        }
        composable(RESEARCH_URL){
            ResearchScreen(navController = navController)
        }
        composable(LANDING_URL){
            LandingScreen(navController = navController)
        }
        composable(CREATIVE_URL){
            CreativeScreen(navController = navController)
        }

        composable(SEARCHES_URL){
            SearchesScreen(navController = navController)
        }
    }
}