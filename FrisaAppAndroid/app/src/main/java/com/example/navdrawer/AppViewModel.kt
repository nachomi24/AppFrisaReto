package com.example.navdrawer


import android.app.Application
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navdrawer.dataStore.deleteValue
import com.example.navdrawer.dataStore.getValueFromDataStore
import com.example.navdrawer.dataStore.hasKeyWithValue
import com.example.navdrawer.dataStore.storeValue
import com.example.navdrawer.util.constants.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel (private val appContext: Application): AndroidViewModel(appContext) {

    private var isLoggedIn = false
    private var token = ""
    private var isAdmin = false
    private var signedPrivacy = false

    fun setLoggedIn() {
        isLoggedIn = true
    }

    fun setLoggedOut() {
        isLoggedIn = false
    }

    fun isUserLoggedIn(): Boolean {
        return isLoggedIn
    }

    fun <T> storeValueInDataStore(value: T, key: Preferences.Key<T>) {
        viewModelScope.launch {
            appContext.storeValue(value, key)
        }
    }

    fun deleteToken(){
        viewModelScope.launch {
            appContext.deleteValue(Constants.TOKEN)
            token =""
            setLoggedOut()
        }
    }
    fun getToken(): String {
        return token
    }

    fun setToken(mytoken: String) {
        token = mytoken
    }

    fun isAdmin(): Boolean {
        return isAdmin
    }

    fun setIsAdmin(value: Boolean){
        isAdmin = value
    }

    fun setSignedPrivacy(){
        signedPrivacy = true
    }

    fun isPrivacySigned(): Boolean{
        return signedPrivacy
    }

    private val _isInitialized = MutableStateFlow(false)
    val isInitialized: StateFlow<Boolean>
        get() = _isInitialized


    init {
        viewModelScope.launch {
            val hasTokenResult = appContext.hasKeyWithValue(Constants.TOKEN)
            val token = appContext.getValueFromDataStore(Constants.TOKEN, "")
            val isAdmin = appContext.getValueFromDataStore(Constants.ISADMIN, false)
            val signed = appContext.getValueFromDataStore(Constants.SIGNED_PRIVACY,false)

            if (hasTokenResult) {
                setLoggedIn()
                setToken(token)
                setIsAdmin(isAdmin)
            }
            if (signed){
                setSignedPrivacy()
            }
            _isInitialized.value = true
            Log.d("POSTVALUE","posting value *** ${_isInitialized.value}")

        }
    }
}