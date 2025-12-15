package com.example.shopshoes_suxarev_is_22a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopshoes_suxarev_is_22a.ui.theme.ShopShoes_Suxarev_is22aTheme
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.CreateNewPassword
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.ForgotPassword
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Onboard1
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Onboard2
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Onboard3
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.RegisterAccount
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.SignIn
import com.example.shopshoes_suxarev_is_22a.ui.theme.screen.Ventication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopShoes_Suxarev_is22aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "createnewpassword", modifier = Modifier.padding(innerPadding)) {
                        composable("onboard1") {
                            Onboard1(navController = navController)
                        }
                        composable("onboard2") {
                            Onboard2(navController = navController)
                        }
                        composable("onboard3") {
                            Onboard3(navController = navController)
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
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ShopShoes_Suxarev_is22aTheme {
//        Greeting("Android")
//    }
//}