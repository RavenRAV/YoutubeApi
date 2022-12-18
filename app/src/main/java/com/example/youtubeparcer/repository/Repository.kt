package com.example.youtubeparcer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.core.network.RetrofitClient
import com.example.youtubeparcer.data.remote.model.PlayListItems
import com.example.youtubeparcer.data.remote.model.PlayLists
import kotlinx.coroutines.Dispatchers

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlayList(): LiveData<PlayLists?> {
        return liveData(Dispatchers.IO) {
            val response = apiService.getPlayList(
                "snippet,contentDetails",
                "UC8M5YVWQan_3Elm-URehz9w",
                BuildConfig.API_KEY,
                10
            )
            if (response.isSuccessful) {
                emit(response.body())
            }
        }
    }

    fun getPlayListItems(id: MutableLiveData<String>): LiveData<PlayListItems?>{
        return liveData(Dispatchers.IO){
            val response = apiService.getPlayListItems(
                part = "snippet",
                playlistId = id.toString(),
//                playlistId = "PLRYgdCIHj6HVn_Nmd0gGc-1Unkkjq_-pl",
                BuildConfig.API_KEY
            )
            if (response.isSuccessful){
                emit(response.body())
            }
        }
    }
}

