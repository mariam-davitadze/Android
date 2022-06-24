package com.example.recyclerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerapp.model.Data
import com.example.recyclerapp.network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<List<Data>> = MutableLiveData()

    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun getUsersList() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = RetrofitService.RetrofitService().getUsersList()
                if (call.isSuccessful) {
                    usersLiveData.postValue(call.body()?.data)
                } else {
                    errorLiveData.postValue("ragac arasworad wavida")
                }
            } catch (e: Exception) {
                errorLiveData.postValue("ragac arasworad wavida")
            }
        }
    }
}