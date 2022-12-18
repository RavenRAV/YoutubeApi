package com.example.youtubeparcer.ui.detail_playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.R
import com.example.youtubeparcer.core.ui.BaseActivity
import com.example.youtubeparcer.data.remote.model.ItemsPLI
import com.example.youtubeparcer.data.remote.model.PlayLists
import com.example.youtubeparcer.databinding.ActivityDetailPlaylistBinding
import com.example.youtubeparcer.ui.playlists.PlayListActivity
import com.example.youtubeparcer.ui.playlists.PlayListViewModel

class DetailPlaylistActivity : BaseActivity<ActivityDetailPlaylistBinding, DetailPlayListViewModel>() {

    lateinit var playLists: PlayLists
    lateinit var adapter: DetailPlaylistAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailPlaylistBinding {
        return ActivityDetailPlaylistBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {

    }

    override fun initView() {
        viewModel = ViewModelProvider(this)[DetailPlayListViewModel::class.java]
        val title = intent.getSerializableExtra(PlayListActivity.PLA_DPLA_TITLE) as String
        binding.titleDpl.text = title

        val id = intent.getSerializableExtra(PlayListActivity.PLA_DPLA_ID) as String
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
        viewModel.id.postValue(id)


    }

    override fun initObservers() {
        viewModel.getPlayListItems().observe(this){
            if (it != null){
               adapter = DetailPlaylistAdapter(it.items as ArrayList<ItemsPLI>)
            }

            binding.recyclerDetailPlaylist.adapter = adapter
        }
    }

    override fun initListener() {

    }

}