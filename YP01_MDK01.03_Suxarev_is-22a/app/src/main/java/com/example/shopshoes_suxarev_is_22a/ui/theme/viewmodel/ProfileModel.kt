package com.example.shopshoes_suxarev_is_22a.ui.theme.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopshoes_suxarev_is_22a.data.RetrofitInstance
import com.example.shopshoes_suxarev_is_22a.data.model.ProfileAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class ProfileState {
    object Loading : ProfileState()
    data class Success(val profile: ProfileAll) : ProfileState()
    data class Error(val message: String) : ProfileState()
}

class ProfileModel : ViewModel() {
    private val _profileState = MutableStateFlow<ProfileState>(ProfileState.Loading)
    val profileState: StateFlow<ProfileState> = _profileState

    fun loadProfile(context: Context) {
        viewModelScope.launch {
            _profileState.value = ProfileState.Loading
            try {
                // Создайте SupabaseClient внутри или используйте Retrofit напрямую
                val supabaseClient = SupabaseClient()
                val profile = supabaseClient.getProfile(context)
                _profileState.value = ProfileState.Success(profile)
            } catch (e: Exception) {
                _profileState.value = ProfileState.Error(e.message ?: "Ошибка загрузки")
            }
        }
    }
}
class SupabaseClient {
    private val userManagementService = RetrofitInstance.userMenegmentService

    suspend fun getProfile(context: Context): ProfileAll {
        val userId = getUserId(context) ?: throw Exception("Пользователь не авторизован")
        // Правильный фильтр: user_id=eq.ваш_id
        val response = userManagementService.getProfile("user_id=eq.$userId")

        if (response.isSuccessful && response.body() != null && response.body()!!.isNotEmpty()) {
            val profile = response.body()!!.first()
            // Сохраняем profile_id для будущих операций
            val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            prefs.edit().putString("profile_id", profile.id.toString()).apply()
            return profile
        }
        throw Exception("Профиль не найден")
    }

    suspend fun updateProfile(context: Context, profile: ProfileAll) {
        val profileId = getProfileId(context) ?: throw Exception("ID профиля не найден")
        // Правильный фильтр для UPDATE: id=eq.ваш_profile_id
        val response = userManagementService.updateProfile(
            "id=eq.$profileId",
            mapOf(
                "firstname" to (profile.name ?: ""),
                "lastname" to (profile.surname ?: ""),
                "address" to (profile.address ?: ""),
                "phone" to (profile.phone ?: "")
            )
        )
        if (!response.isSuccessful) {
            throw Exception("Ошибка обновления")
        }
    }
}