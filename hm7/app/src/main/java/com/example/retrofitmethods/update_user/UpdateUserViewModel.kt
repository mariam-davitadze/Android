package com.example.retrofitmethods.update_user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmethods.model.UpdateUserResponse
import com.example.retrofitmethods.model.User
import com.example.retrofitmethods.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class UpdateUserViewModel : ViewModel() {

    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    val userLiveData: MutableLiveData<UpdateUserResponse> = MutableLiveData()

    fun updateUser(name: String, job: String) {
        if (name.isNotEmpty() && job.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val call = RetrofitService.RetrofitService().updateUser(User(name, job))
                    if (call.isSuccessful) {
                        userLiveData.postValue(
                            UpdateUserResponse(
                                call.body()?.job!!,
                                call.body()?.name!!,
                                call.body()?.updatedAt!!,
                            )
                        )
                    } else {
                        errorLiveData.postValue("ragac arasworad wavida")
                    }
                } catch (e: Exception) {
                    errorLiveData.postValue("ragac arasworad wavida")
                }
            }
        } else {
            errorLiveData.postValue("Sheavse yvela veli")
        }
    }
}