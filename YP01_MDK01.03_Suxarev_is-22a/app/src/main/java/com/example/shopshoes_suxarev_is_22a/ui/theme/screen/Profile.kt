package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import android.graphics.Bitmap
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.myfirstapplication.data.service.API_KEY
import com.example.shopshoes_suxarev_is_22a.R
import com.example.shopshoes_suxarev_is_22a.data.RetrofitInstance.SUPABASE_URL
import com.example.shopshoes_suxarev_is_22a.data.model.ProfileAll
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.ProfileModel
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.ProfileState
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.SingInModel
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.getProfileId
import com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel.getUserId
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout

val httpClient = HttpClient() {
    install(HttpTimeout) {
        requestTimeoutMillis = 30000
    }
}

// Тогда передавайте именно этот объект
val supabase = createSupabaseClient(
    supabaseUrl = SUPABASE_URL,
    supabaseKey = API_KEY
) {
    install(Postgrest)
}
suspend fun fetchUserById(userId: String): ProfileAll {
    return supabase
        .from("profiles")
        .select {
            filter {
                eq("id", userId)
            }
        }
        .decodeSingle<ProfileAll>()
}


//Скрин Профиля Сухарев_ис-22а 16.12.25 после 19.12.25
@Composable
fun Profile(modifier: Modifier = Modifier,viewModel: ProfileModel = ProfileModel(), navController: NavHostController){
    //var name by remember { mutableStateOf("") }
    //var surname by remember { mutableStateOf("") }
    //var email by remember { mutableStateOf("") }
    //var telephone by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("Иван") }
    var surname by remember { mutableStateOf("Сухарев") }
    var email by remember { mutableStateOf("suharev@is-22a.ru") }
    var telephone by remember { mutableStateOf("+7 (999) 123-45-67") }


    val profileState: ProfileState by viewModel.profileState.collectAsState()
    val context = LocalContext.current
    val userId = getUserId(context)
    val profileId = getProfileId(context)
    Log.d("PROFILE_DEBUG", "userId: $userId")
    Log.d("PROFILE_DEBUG", "profileId: $profileId")

    LaunchedEffect(Unit) {
        if (userId != null) {
            viewModel.loadProfile(context)
        } else {
            // Пользователь не авторизован - переход на логин
            //navController.navigate("login")
        }
    }
    // ✅ Обновление состояний при загрузке профиля
    LaunchedEffect(profileState) {
        if (profileState is ProfileState.Success) {
            val state = profileState as ProfileState.Success
            name = state.profile.name ?: ""
            surname = state.profile.surname ?: ""
            email = state.profile.address ?: ""
            telephone = state.profile.phone ?: ""
            //profilePhotoUrl = state.profile.photo
        }
    }
    //LaunchedEffect(userId) {
    //    try {
    //        val user = fetchUserById(userId)
    //        name = user.name
    //        surname = user.surname
    //        email = user.address
    //        telephone = user.phone
    //    } catch (e: Exception) {
    //        println("Ошибка загрузки: ${e.message}")
    //        e.printStackTrace()}
    //}

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
            text =  name + " " + surname,
            fontSize = 15.sp,
        )
        Image(
            painter = painterResource(R.drawable.profile0),
            contentDescription = "",
            modifier = Modifier.width(335.dp).height(65.dp).clickable(onClick = {})
        )
        Text(
            text = "Имя",
            modifier = Modifier.offset(x=-179.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text(name, color = Color(0xFF737377))},
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
            label = {Text(surname, color = Color(0xFF737377))},
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
            label = {Text(email, color = Color(0xFF737377))},
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
            label = {Text(telephone, color = Color(0xFF737377))},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.navigate("profile0")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF31B0C7)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Изменить"
            )
        }
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.homemenu1),
            modifier = Modifier.fillMaxHeight().fillMaxWidth().offset(y = 5.dp).clickable(onClick = {navController.navigate("home")})
        )
    }
}