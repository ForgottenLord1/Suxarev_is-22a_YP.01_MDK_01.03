package com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.myfirstapplication.data.model.SignIn
import com.example.shopshoes_suxarev_is_22a.data.RetrofitInstance
import kotlinx.coroutines.launch
import kotlin.apply
import kotlin.let
import kotlin.toString

//Код авторизации пользователя Сухарев_ис-22а 15.12.25
private val CHANNEL_ID = "3d04925"
class SingInModel : ViewModel() {
    fun signIn(signIn: SignIn, context: Context, navController: NavController) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.userMenegmentService.signInfun(signIn)
                Log.d("SignInResponse", "Code: ${response.code()}, Message: ${response.message()}, Body: ${response.body()}")
                val errorBody = response.errorBody()?.string()
                if (response.isSuccessful) {
                    response.body()?.let {
                        navController.navigate("onboard1")
                    }
                    Log.e("SignInError", "Error body: $errorBody")
                }
                if(errorBody == "{\"code\":400,\"error_code\":\"email_not_confirmed\",\"msg\":\"Email not confirmed\"}"){
                    navController.navigate("onboard1")
                }
                else {
                    if (signIn.email.isNotEmpty() && signIn.password.isNotEmpty()){
                        Toast.makeText(context, "Введены некорректные данные пользователя!", Toast.LENGTH_SHORT).show()
                        Log.e("SignInError", "Error body: $errorBody")
                    }
                    else{
                        Toast.makeText(context, "Должны быть заполнены все поля!", Toast.LENGTH_SHORT).show()
                        Log.e("SignInError", "Error body: $errorBody")
                    }
                }
            }
            catch (e: Exception){
                val error : String = e.message.toString()
                Toast.makeText(context, "Ошибка при авторизации! \n $error", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //root1234@mail.ru
    //root1234
}