package com.example.navdrawer.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navdrawer.model.UserLogin
import com.example.navdrawer.model.UserLoginResponse
import com.example.navdrawer.model.UserProtectedResponse
import com.example.navdrawer.model.UserRegister
import com.example.navdrawer.model.UserRegistrationResponse
import com.example.navdrawer.service.UserService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel(private val userService: UserService) : ViewModel() {


    private val _registrationResult = MutableStateFlow<UserRegistrationResponse?>(null)
    val registrationResult: StateFlow<UserRegistrationResponse?> = _registrationResult


    private val _loginResult = MutableStateFlow<UserLoginResponse?>(null)
    val loginResult: StateFlow<UserLoginResponse?> = _loginResult


    private val _protectedResult = MutableStateFlow<UserProtectedResponse?>(null)
    val protectedResult: StateFlow<UserProtectedResponse?> = _protectedResult


/*
fun addUser(telephone: Int, password: String) {
    val user = UserRegister(telephone, password)

    viewModelScope.launch {
        val response: UserRegistrationResponse
        try {
            response = userService.insertUser(user)
            _registrationResult.value = response
        } catch (e: Exception) {

            val errorResponse = UserRegistrationResponse(e.localizedMessage)
            _registrationResult.value = errorResponse
        }
    }
}

 */

/*
fun getUserFavoriteOrganization(token: String) {
    viewModelScope.launch {
        val response: GetUserFavoriteOrganizationsResponse
        try {
            response = userService.getUserFavoriteOrganization(token)
            _getUserFavoriteOrgsResult.value = response
        } catch (e: Exception) {

            val errorResponse = e.localizedMessage
            Log.d("ERROR-API", errorResponse)
            //_getUserFavoriteOrgsResult.value = errorResponse
        }
    }
}

*/


/*
fun addUserFavoriteOrganization(token: String, orgId: String) {


    viewModelScope.launch {
        val response: AddFavoriteOrganizationResponse
        try {
            response = userService.addFavoriteOrganization(token, orgId)
            _addOrgFavoriteResult.value = response
        } catch (e: Exception) {

            val errorResponse = AddFavoriteOrganizationResponse(e.localizedMessage)
            _addOrgFavoriteResult.value = errorResponse
        }
    }
}


 */

fun loginUser(phone: Int, password: String) {

    // Reset the login result to nul before making a new login request
    _loginResult.value = null

    val user = UserLogin(phone, password)

    viewModelScope.launch {
        val response: UserLoginResponse

        try {
            response = userService.loginUser(user)
            _loginResult.value = response
            Log.d("RESPONSE", response.id.toString())
        } catch (e: HttpException) {

            when (e.code()) {

                400 -> {
                    Log.d("RESPONSE", e.localizedMessage)
                    val errorMessage = "Credenciales incorrectas"
                    val errorResponse = UserLoginResponse()
                    _loginResult.value = errorResponse
                }

                else -> {
                    Log.d("RESPONSE", e.localizedMessage)
                    val errorMessage = e.localizedMessage
                    val errorResponse = UserLoginResponse()
                    _loginResult.value = errorResponse
                }
            }
        } catch (e: Exception) {
            Log.d("RESPONSE", e.localizedMessage)
            val errorMessage = e.localizedMessage
            val errorResponse = UserLoginResponse()
            _loginResult.value = errorResponse
        }

    }
}


/*
fun testProtectedRequest(token: String) {

    viewModelScope.launch {
        val response: UserProtectedResponse
        try {
            response = userService.protectedRoute(token)
            _protectedResult.value = response
            Log.d("RESPONSE", response.message)
        } catch (e: HttpException) {

            when (e.code()) {

                401 -> {
                    Log.d("RESPONSE", e.localizedMessage)
                    val errorMessage = "Invalid credentials"
                    val errorResponse = UserProtectedResponse(errorMessage)
                    _protectedResult.value = errorResponse
                }

                else -> {
                    Log.d("RESPONSE", e.localizedMessage)
                    val errorMessage = e.localizedMessage
                    val errorResponse = UserProtectedResponse(errorMessage)
                    _protectedResult.value = errorResponse
                }

            }


        }

    }
}


 */


}

/*
class AppViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
        return AppViewModel(context) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
}
}*/