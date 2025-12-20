package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import android.app.Activity
import android.app.AlertDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myfirstapplication.data.model.SignIn
import com.example.shopshoes_suxarev_is_22a.R
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.SingInModel


//Скрин авторизации Сухарев_ис-22а 15.12.25
@Composable
fun SignIn(modifier: Modifier = Modifier, viewModel: SingInModel = SingInModel(), navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Image(
        contentDescription = "",
        modifier = Modifier.height(50.dp).width(50.dp).offset(x = 5.dp, y = 5.dp).clickable(onClick = {
            AlertDialog.Builder(context)
                .setTitle("Выход")
                .setMessage("Выйти из приложения?")
                .setPositiveButton("Да") { _, _ ->
                    (context as Activity).finishAffinity()
                }
                .setNegativeButton("Нет", null)
                .show()

        }),
        painter = painterResource(R.drawable.exit0)
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Привет!",
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Заполните Свои Данные",
            color = Color(0xFF737377)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Email",
            modifier = Modifier.offset(x=-175.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("xyz@gmail.com", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Пароль",
            modifier = Modifier.offset(x=-165.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("********", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPasswordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {isPasswordVisible =!isPasswordVisible}) {
                    Icon(
                        painter = painterResource(
                            id = if (isPasswordVisible)
                                R.drawable.eye1
                            else
                                R.drawable.eye0
                        ),
                        contentDescription = "",
                        modifier = Modifier.height(24.dp).width(24.dp)
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Востановить",
            textDecoration = TextDecoration.Underline,
            color = Color(0xFF737377),
            modifier = Modifier.offset(x = 145.dp).clickable(onClick = {navController.navigate("forgotpassword")})
        )
        Spacer(modifier = Modifier.height(105.dp))
        Button(
            onClick = {
                viewModel.signIn(SignIn(email, password), context, navController)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF31B0C7)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Войти"
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row {
            Text(
                text = "Вы впервые?",
                color = Color(0xFF737377)
            )
            Text(
                text = "Создать",
                modifier = Modifier.offset(x = 2.dp).clickable(onClick = {navController.navigate("registeraccount")})
            )
        }
    }
}
//root1234@mail.ru
//root1234