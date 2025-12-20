package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopshoes_suxarev_is_22a.R

//Скрин создания нового пароля Сухарев_ис-22а 15.12.25
@Composable
fun CreateNewPassword(modifier: Modifier = Modifier, navController: NavHostController){
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Image(
        contentDescription = "",
        modifier = Modifier.height(50.dp).width(50.dp).offset(x = 5.dp, y = 5.dp).clickable(onClick = {
            navController.navigate("signin")
        }),
        painter = painterResource(R.drawable.exit0)
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Задать Новый Пароль",
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Установите Новый Пароль Для Входа В",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Вашу Учетную Запись",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Пароль",
            modifier = Modifier.offset(x=-175.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("********", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Подтверждение пароля",
            modifier = Modifier.offset(x=-150.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("********", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = {
                //viewModel.signIn(SignIn(email, password), context, navController)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFFFFFFF),       // цвет текста
                containerColor = Color(0xFF31B0C7)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Сохранить"
            )
        }
    }
}