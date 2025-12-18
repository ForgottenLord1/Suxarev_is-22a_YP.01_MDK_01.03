package com.example.shopshoes_suxarev_is_22a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopshoes_suxarev_is_22a.ui.theme.ShopShoes_Suxarev_is22aTheme
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.CreateNewPassword
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.ForgotPassword
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Home
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Onboard
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Profile
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Profile0
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.RegisterAccount
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.SignIn
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Ventication

//Класс MainActivity с навигацией Сухарев_ис-22а 15.12.25
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen =  installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopShoes_Suxarev_is22aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "profile", modifier = Modifier.padding(innerPadding)) {
                        composable("onboard") {
                            Onboard(navController = navController)
                        }
                        composable("registeraccount") {
                            RegisterAccount(navController = navController)
                        }
                        composable("signin") {
                            SignIn(navController = navController)
                        }
                        composable("forgotpassword") {
                            ForgotPassword(navController = navController)
                        }
                        composable("ventication") {
                            Ventication(navController = navController)
                        }
                        composable("createnewpassword") {
                            CreateNewPassword(navController = navController)
                        }
                        composable("home") {
                            Home(navController = navController)
                        }
                        composable("profile") {
                            Profile(navController = navController)
                        }
                        composable("profile0") {
                            Profile0(navController = navController)
                        }
                    }
                }
            }
        }
    }
}