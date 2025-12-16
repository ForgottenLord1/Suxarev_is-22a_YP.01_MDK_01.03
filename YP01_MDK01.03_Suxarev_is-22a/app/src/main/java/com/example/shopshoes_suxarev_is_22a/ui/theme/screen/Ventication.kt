package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//Скрин ОТР проверки  Сухарев_ис-22а 15.12.25
@Composable
fun Ventication(modifier: Modifier = Modifier, navController: NavHostController){
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "ОТР Проверка",
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Пожалуйста. Проверьте Свою",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Электронную Почту. Чтобы Увидеть Код",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Подтверждения",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "ОТР Код",
        )
        Spacer(modifier = Modifier.height(40.dp))
        //OutlinedTextField(
        //    value = email,
        //    onValueChange = {email = it},
        //    label = {Text("", color = Color(0xFF737377))},
        //    modifier = Modifier.fillMaxWidth()
        //)
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "00:30",
        )
    }
}