package com.example.navdrawer.service


import com.example.navdrawer.model.UserLogin
import com.example.navdrawer.model.UserLoginResponse
import com.example.navdrawer.model.UserRegister
import com.example.navdrawer.model.UserRegistrationResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    companion object {

        val instance: UserService =
            Retrofit.Builder().baseUrl("https://androidapi-8n8l-dev.fl0.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserService::class.java)
    }

    @POST("api/user") // Ruta para el registro de usuario
    suspend fun insertUser(@Body user: UserRegister): UserRegistrationResponse

    @POST("user/login") // Ruta para el inicio de sesión de usuario
    suspend fun loginUser(@Body user: UserLogin): UserLoginResponse

    @GET("user") // Ruta para obtener todos los usuarios
    suspend fun getAllUsers(): List<UserRegister>

    @GET("user/{phone}") // Ruta para obtener un usuario específico
    suspend fun getUserByPhone(@Path("phone") phone: Int): UserRegister

    @PATCH("user/{phone}") // Ruta para actualizar un usuario específico
    suspend fun updateUser(@Path("phone") phone: Int, @Body user: UserRegister): UserRegister

    @DELETE("user/{phone}") // Ruta para eliminar un usuario específico
    suspend fun deleteUser(@Path("phone") phone: Int): Response<Void>

}
    /*companion object {
        val instance: Any
        private const val BASE_URL = "https://androidapi-8n8l-dev.fl0.io/"

        fun create(): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UserService::class.java)
        }
    }*/