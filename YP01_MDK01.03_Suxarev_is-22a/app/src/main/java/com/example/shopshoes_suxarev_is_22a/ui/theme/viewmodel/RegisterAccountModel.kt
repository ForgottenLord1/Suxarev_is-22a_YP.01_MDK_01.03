package com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.myfirstapplication.data.model.SignUp
import com.example.shopshoes_suxarev_is_22a.data.RetrofitInstance
import kotlinx.coroutines.launch

class RegisterAccountModel: ViewModel() {
    fun RegisterAccount(signUp: SignUp, context: Context, navController: NavController) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            "my_app_preferences",
            Context.MODE_PRIVATE
        )
        try {
            viewModelScope.launch {
                val response = RetrofitInstance.userMenegmentService.signUpfun(signUp)
                Log.d("SignUpResponse", "Code: ${response.code()}, Message: ${response.message()}, Body: ${response.body()}")
                if (response.isSuccessful) {
                    response.body()?.let {
                        sharedPreferences.edit().apply {
                            putString("userEmail", signUp.email)
                            apply()
                        }
                        navController.navigate("signin")
                    }
                } else {
                    val messageText : String = response.message().toString()
                    Toast.makeText(context, "Пользователь ввел некорректные данные \n $messageText", Toast.LENGTH_SHORT).show()
                    val errorBody = response.errorBody()?.string()
                    Log.e("SignUpError", "Error body: $errorBody")
                }
            }
        }
        catch (e: Exception) {
            val error : String = e.message.toString()
            Toast.makeText(context, "Ошибка при регистрации \n $error", Toast.LENGTH_SHORT).show()
        }
    }
}