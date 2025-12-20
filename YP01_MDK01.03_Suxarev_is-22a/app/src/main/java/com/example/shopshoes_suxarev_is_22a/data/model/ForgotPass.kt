package com.example.shopshoes_suxarev_is_22a.data.model

data class ForgotPass(
    val type: String,
    val email: String,
    val token: String?
    //val token_hash: String?
)