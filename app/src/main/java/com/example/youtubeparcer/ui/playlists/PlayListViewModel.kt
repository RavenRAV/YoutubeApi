package com.example.youtubeparcer.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubeparcer.core.ui.BaseViewModel
import com.example.youtubeparcer.data.remote.model.PlayLists
import com.example.youtubeparcer.repository.Repository

class PlayListViewModel(private val repository: Repository): BaseViewModel() {

    fun getPlayList(): LiveData<PlayLists?>{
        return repository.getPlayList()
    }



}

