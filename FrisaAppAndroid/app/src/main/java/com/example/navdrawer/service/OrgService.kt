package com.example.navdrawer.service

import com.example.navdrawer.model.OrgRegister
import com.example.navdrawer.model.OrgRegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OrgService {

    @POST("organizations/add") // Incluye la ruta específica del endpoint aquí
    suspend fun addOrg(@Header("Authorization") token: String, @Body org: OrgRegister): OrgRegisterResponse

    companion object {
        // Especifica la URL base sin incluir la ruta específica del endpoint
        private const val BASE_URL = "https://apifrisa-py6x-dev.fl0.io/"

        fun create(): OrgService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OrgService::class.java)
        }
    }
}