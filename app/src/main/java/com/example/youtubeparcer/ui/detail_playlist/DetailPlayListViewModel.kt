package com.example.youtubeparcer.ui.detail_playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeparcer.core.ui.BaseViewModel
import com.example.youtubeparcer.data.remote.model.PlayListItems
import com.example.youtubeparcer.repository.Repository

class DetailPlayListViewModel: BaseViewModel() {

    private val repository = Repository()

    fun getPlayListItems(id : String): LiveData<PlayListItems?> {
        return repository.getPlayListItems(id)
    }
}