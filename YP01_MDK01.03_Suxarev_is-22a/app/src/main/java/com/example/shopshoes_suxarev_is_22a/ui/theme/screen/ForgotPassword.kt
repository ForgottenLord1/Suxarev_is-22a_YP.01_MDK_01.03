package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import android.app.Activity
import android.app.AlertDialog
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
import com.example.shopshoes_suxarev_is_22a.data.model.ForgotPass
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.ForgotPasswordModel

//Скрин изменение пароля Сухарев_ис-22а 15.12.25
@Composable
fun ForgotPassword(modifier: Modifier = Modifier, viewModel: ForgotPasswordModel = ForgotPasswordModel(), navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var type = "email"
    var token = "ab34647831b5e8a0fa898a782511bb9b036643f545c15353c54a1140"
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
            text = "Забыл пароль",
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Введите Свою Учетную Запись",
            color = Color(0xFF737377)
        )
        Text(
            text = "Для сброса",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("xyz@gmail.com", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(75.dp))
        Button(
            onClick = {
                viewModel.ForgotPassword(ForgotPass(email,type,token), context, navController)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF31B0C7)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Отправить"
            )
        }
    }
}