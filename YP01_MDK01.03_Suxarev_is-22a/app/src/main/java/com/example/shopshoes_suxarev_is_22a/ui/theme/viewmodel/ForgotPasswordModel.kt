package com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.shopshoes_suxarev_is_22a.data.RetrofitInstance
import com.example.shopshoes_suxarev_is_22a.data.model.ForgotPass
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


//Код скрина забыл пароль Сухарев_ис-22а 17.12.25
class ForgotPasswordModel: ViewModel() {
    fun ForgotPassword(forgotPass: ForgotPass, context: Context, navController: NavController) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.userMenegmentService.ForgotPasswordfun(forgotPass)
                //val jwt = response.data?.access_token
                //val token = yourSupabaseClient.auth.currentSession?.accessToken
                Log.d("ForgotPassword", "Code: ${response.code()}, Message: ${response.message()}, Body: ${response.body()}")
                val errorBody = response.errorBody()?.string()
                if (response.isSuccessful) {
                    response.body()?.let {
                        navController.navigate("home")
                    }
                    Log.e("ForgotPasswordError", "Error body: $errorBody")
                }
                if(errorBody == "{\"code\":400,\"error_code\":\"email_not_confirmed\",\"msg\":\"Email not confirmed\"}"){
                    navController.navigate("ventication")
                }
                else {
                    if (forgotPass.email.isNotEmpty()){
                        Toast.makeText(context, "Введены некорректные данные email!", Toast.LENGTH_SHORT).show()
                        Log.e("ForgotPasswordError", "Error body: $errorBody")
                    }
                    else{
                        Toast.makeText(context, "Должны быть заполнены все поля!", Toast.LENGTH_SHORT).show()
                        Log.e("ForgotPasswordError", "Error body: $errorBody")
                    }
                }
            }
            catch (e: Exception){
                val error : String = e.message.toString()
                Toast.makeText(context, "Ошибка при получении токена! \n $error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
//root1234@mail.ru