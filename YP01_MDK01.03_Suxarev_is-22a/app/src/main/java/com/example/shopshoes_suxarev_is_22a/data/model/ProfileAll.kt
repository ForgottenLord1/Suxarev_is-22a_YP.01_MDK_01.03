package com.example.shopshoes_suxarev_is_22a.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileAll(
    @SerialName("id")
    val id: String,  // ← Уберите ? - сделайте NOT NULL

    @SerialName("user_id")
    val user_id: String,

    @SerialName("firstname")
    val name: String? = "",  // null по умолчанию пустая строка

    @SerialName("lastname")
    val surname: String? = "",

    @SerialName("address")
    val address: String? = "",

    @SerialName("phone")
    val phone: String? = ""
)
