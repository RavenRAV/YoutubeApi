package com.example.youtubeparcer.ui.playlists

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.core.ui.BaseViewModel
import com.example.youtubeparcer.data.remote.model.PlayLists
import com.example.youtubeparcer.core.network.RetrofitClient
import com.example.youtubeparcer.data.remote.model.PlayListItems
import com.example.youtubeparcer.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel: BaseViewModel() {

    private val repository = Repository()

    fun getPlayList(): LiveData<PlayLists?>{
        return repository.getPlayList()
    }



}

