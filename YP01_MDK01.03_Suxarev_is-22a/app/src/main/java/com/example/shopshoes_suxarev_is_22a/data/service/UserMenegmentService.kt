package com.example.myfirstapplication.data.service

import com.example.myfirstapplication.data.model.SignIn
import com.example.myfirstapplication.data.model.SignInID
import com.example.myfirstapplication.data.model.SignUp
import com.example.myfirstapplication.data.model.SignUpID
import com.example.shopshoes_suxarev_is_22a.data.model.ForgotPass
import com.example.shopshoes_suxarev_is_22a.data.model.ForgotPassID
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJ5Y2V6cGhzbmRjdWZiZ3VvZnZyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTk4MTYwMDgsImV4cCI6MjA3NTM5MjAwOH0.KeP8WF_-WqUBldXjuUbK-oH2dCS7OTH0tqC4RhWCHZI"

interface UserMenegmentService {
    @Headers("apikey: $API_KEY")
    @POST(value = "auth/v1/signup")
    suspend fun signUpfun(@Body signUp: SignUp): retrofit2.Response<SignUpID>

    @Headers("apikey: $API_KEY")
    @POST(value = "auth/v1/token?grant_type=password")
    suspend fun signInfun(@Body signIn: SignIn): retrofit2.Response<SignInID>

    @Headers("apikey: $API_KEY")
    @POST(value = "auth/v1/verify")
    suspend fun ForgotPasswordfun(@Body forgotPass: ForgotPass): retrofit2.Response<ForgotPassID>
}