package com.example.retrofitmethods.delete_user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmethods.model.DeletedUserResponse
import com.example.retrofitmethods.model.User
import com.example.retrofitmethods.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DeleteUserViewModel : ViewModel() {
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    val userLiveData: MutableLiveData<DeletedUserResponse> = MutableLiveData()

    fun deleteUser(name: String, job: String) {
        if (name.isNotEmpty() && job.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val call = RetrofitService.RetrofitService().deleteUser(User(name, job))
                    if (call.isSuccessful) {
                        userLiveData.postValue(
                            DeletedUserResponse(
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