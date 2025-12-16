package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Scaffold
import com.example.shopshoes_suxarev_is_22a.R

//Скрин Главное меню Сухарев_ис-22а 16.12.25
@Composable
fun Home(modifier: Modifier = Modifier, navController: NavHostController){
    var text by remember { mutableStateOf("") }
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 7.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Главная",
                fontSize = 35.sp,
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row() {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Поиск", color = Color(0xFF737377)) },
                    modifier = Modifier.offset(x = 5.dp).width(330.dp)
                )
                Image(
                    contentDescription = "",
                    painter = painterResource(R.drawable.home0),
                    modifier = Modifier.height(70.dp).width(70.dp).offset(x = 5.dp, y = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Категории",
                fontSize = 16.sp,
                modifier = Modifier.offset(x = -154.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier.height(40.dp))
            Row() {
                Text(
                    text = "Популярное",
                    fontSize = 16.sp,
                    modifier = Modifier.offset(x = -132.dp)
                )
                Text(
                    text = "Все",
                    fontSize = 16.sp,
                    modifier = Modifier.offset(x = 130.dp),
                    color = Color.Blue
                )
            }
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.home1),
                modifier = Modifier.width(160.dp).height(182.dp).offset(x = -110.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row() {
                Text(
                    text = "Акции",
                    fontSize = 16.sp,
                    modifier = Modifier.offset(x = -154.dp)
                )
                Text(
                    text = "Все",
                    fontSize = 16.sp,
                    modifier = Modifier.offset(x = 154.dp),
                    color = Color.Blue
                )
            }
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.homemenu),
                modifier = Modifier.fillMaxHeight().fillMaxWidth().offset(y = 114.dp),
            )

            //Image(
            //    contentDescription = "",
            //    painter = painterResource(R.drawable.home2),
            //    modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(15.dp)
            //        .offset(y = -100.dp)
            //)
        }
    }
}