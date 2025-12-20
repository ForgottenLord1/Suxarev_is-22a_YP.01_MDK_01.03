package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopshoes_suxarev_is_22a.R

@Composable
fun Profile0(modifier: Modifier = Modifier, navController: NavHostController){
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }

    var photoBitmap by remember { mutableStateOf<Bitmap?>(null) }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        photoBitmap = bitmap
    }
    fun PhotoCamera() {
        cameraLauncher.launch()
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                PhotoCamera()
            } else {
                // Можно показать сообщение, что нужно разрешение
            }
        }
    )
    fun requestPermissions() {
        permissionLauncher.launch(android.Manifest.permission.CAMERA)
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Профиль",
            fontSize = 15.sp,
        )
        Box(
            modifier = Modifier
                .clickable { requestPermissions() } // По клику вызываем камеру
        ) {
            if (photoBitmap != null) {
                Image(
                    modifier = Modifier.size(150.dp)
                        .clip(RoundedCornerShape(100.dp)),
                    bitmap = photoBitmap!!.asImageBitmap(),
                    contentDescription = ""
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ){

                }
            }
        }
        Text(
            text = name + " " + surname,
            fontSize = 15.sp,
        )
        Text(
            text = "Изменить фото профиля",
            fontSize = 15.sp,
            color = Color.Blue
        )
        Text(
            text = "Имя",
            modifier = Modifier.offset(x=-179.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Фамилия",
            modifier = Modifier.offset(x=-165.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = surname,
            onValueChange = {surname = it},
            label = {Text("", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Адрес",
            modifier = Modifier.offset(x=-175.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Телефон",
            modifier = Modifier.offset(x=-165.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = telephone,
            onValueChange = {telephone = it},
            label = {Text("", color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = {
                navController.navigate("profile")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF31B0C7)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Сохранить"
            )
        }
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.homemenu1),
            modifier = Modifier.fillMaxHeight().fillMaxWidth().offset(y = 5.dp).clickable(onClick = {navController.navigate("home")})
        )
    }
}