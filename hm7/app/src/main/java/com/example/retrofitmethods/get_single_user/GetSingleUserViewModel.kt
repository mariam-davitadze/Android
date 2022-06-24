package com.example.retrofitmethods.get_single_user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmethods.model.Data
import com.example.retrofitmethods.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class GetSingleUserViewModel : ViewModel() {

    val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val userLiveData: MutableLiveData<Data> = MutableLiveData()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = RetrofitService.RetrofitService().getSingleUser()
                if (call.isSuccessful) {
                    call.body()?.data?.let {
                        userLiveData.postValue(it)
                    }
                } else {
                    errorLiveData.postValue("ragac arasworad wavida")
                }
            } catch (e: Exception) {
                errorLiveData.postValue("ragac arasworad wavida")
            }
        }
    }
}