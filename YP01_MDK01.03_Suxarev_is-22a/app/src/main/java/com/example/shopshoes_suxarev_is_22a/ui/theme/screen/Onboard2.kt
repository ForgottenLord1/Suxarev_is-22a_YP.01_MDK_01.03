package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shopshoes_suxarev_is_22a.R

@Composable
fun Onboard2(modifier: Modifier = Modifier, navController: NavHostController){
    //val myColor: Color = Color(0xFF48B2E7)
    //val modifier = Modifier.background(myColor).padding(30.dp)
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Добро пожаловать",
            //modifier = Modifier.weight(700F)
            //fontSize = 20.sp,
            //modifier = Modifier.offset(145.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().height(302.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frame1),
            contentDescription = "",
            modifier = Modifier.size(150.dp).offset(120.dp)
        )
        Spacer(modifier = Modifier.height(110.dp))
        Button(
            onClick = {navController.navigate("onboard3")},
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Начать"
            )
        }
    }
}