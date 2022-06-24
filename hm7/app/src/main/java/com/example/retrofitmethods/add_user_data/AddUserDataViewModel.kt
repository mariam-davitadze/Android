package com.example.retrofitmethods.add_user_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmethods.model.User
import com.example.retrofitmethods.model.UserResponse
import com.example.retrofitmethods.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AddUserDataViewModel : ViewModel() {

    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    val userLiveData: MutableLiveData<UserResponse> = MutableLiveData()

    fun addUser(name: String, job: String) {
        if (name.isNotEmpty() && job.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val call = RetrofitService.RetrofitService().addUserData(User(name, job))
                    if (call.isSuccessful) {
                        userLiveData.postValue(
                            UserResponse(
                                call.body()?.name,
                                call.body()?.job,
                                call.body()?.id,
                                call.body()?.createdAt
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