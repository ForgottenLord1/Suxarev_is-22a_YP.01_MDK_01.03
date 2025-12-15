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
                        //createNotificationChannel(context)
                        //showSignInSuccessNotification(context, "Здравствуйте", "Вы успешно авторизованы.")
                        navController.navigate("onboard1")
                    }
                    Log.e("SignInError", "Error body: $errorBody")
                }
                if(errorBody == "{\"code\":400,\"error_code\":\"email_not_confirmed\",\"msg\":\"Email not confirmed\"}"){
                    //createNotificationChannel(context)
                    //showSignInSuccessNotification(context, "Здравствуйте", "Вы успешно авторизованы.")
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
    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Общий канал уведомлений"
            val descriptionText = "Канал для важных уведомлений"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            Log.d("Notification", "Канал создан или уже существует")
        }
    }

    // Новая функция, которая принимает текст сообщения
    //un showSignInSuccessNotification(context: Context, title: String, message: String){
    //   try {
    //       // Перед показом уведомления обязательно нужно проверить разрешение!
    //       // Эта проверка должна выполняться в Activity, прежде чем она вызовет signIn из ViewModel.

    //       val builder = NotificationCompat.Builder(context, CHANNEL_ID)
    //           .setSmallIcon(R.drawable.photo) // Убедитесь, что R.drawable.photo существует
    //           .setContentTitle(title)
    //           .setContentText(message)
    //           .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    //           .setAutoCancel(true)

    //       with(NotificationManagerCompat.from(context)) {
    //           // Проверку разрешения в API > 32 нельзя обойти, даже если вы в ViewModel
    //           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
    //               ContextCompat.checkSelfPermission(
    //                   context,
    //                   Manifest.permission.POST_NOTIFICATIONS
    //               ) != PackageManager.PERMISSION_GRANTED
    //           ) {
    //               Log.e("NotificationError", "Разрешение POST_NOTIFICATIONS не предоставлено!")
    //               return
    //           }
    //           notify(1, builder.build()) // Уникальный ID уведомления
    //           Log.d("Notification", "Уведомление показано")
    //       }
    //   } catch (e: Exception) {
    //       Log.e("NotificationError", "Ошибка при создании уведомления", e)
    //   }
    //
    //root1234@mail.ru
    //root1234
}