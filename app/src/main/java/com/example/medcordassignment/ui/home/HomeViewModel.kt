package com.example.medcordassignment.ui.home

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.medcordassignment.network.NetworkClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class HomeViewModel : ViewModel() {
private val response_val: MutableLiveData<String>? = null
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
       //apicall()
    }

    fun apicall(buttonNAme:String,context:Context): MutableLiveData<String>? {
        val apiClient = NetworkClient.getNetworkClientInstance().getApiClient()
    apiClient.callCommonAPIExecutor(buttonNAme).enqueue(object:Callback<ResponseBody>{
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(context,t.message,Toast.LENGTH_LONG).show()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

           try{
               val loadedString = response.body()!!.string()
            response_val?.value=loadedString

           }catch (exception:Exception){
               exception.printStackTrace()
           }

        }

    })
   return response_val
    }

    val text: LiveData<String> = _text
}


