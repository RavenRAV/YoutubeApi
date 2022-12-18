package com.example.youtubeparcer.ui.playlists

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.core.ui.BaseActivity
import com.example.youtubeparcer.core.utils.CheckInternetConnection
import com.example.youtubeparcer.data.remote.model.Items
import com.example.youtubeparcer.databinding.ActivityPlaylistBinding
import com.example.youtubeparcer.ui.detail_playlist.DetailPlayListViewModel
import com.example.youtubeparcer.ui.detail_playlist.DetailPlaylistActivity

class PlayListActivity : BaseActivity<ActivityPlaylistBinding, PlayListViewModel>() {

lateinit var adapter: PlaylistsAdapter

    override fun checkInternet() {
        CheckInternetConnection((getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this){
                binding.includedInternet.constInternet.isVisible = !it
                binding.recyclerPlaylists.isVisible = it

                if(it == true){
                initObservers()
                }
            }
    }

    override fun initView() {
       viewModel = ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun initObservers() {

        viewModel.getPlayList().observe(this){
            if (it != null) {
                adapter = PlaylistsAdapter(it.items as ArrayList<Items>, this::clickListener)
            }
            binding.recyclerPlaylists.adapter = adapter
        }


    }

    private fun clickListener(id:String, title: String){
        val intent = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra(PLA_DPLA_ID, id)
        intent.putExtra(PLA_DPLA_TITLE, title)
        startActivity(intent)
    }

    override fun initListener() {

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    companion object{
        const val PLA_DPLA_ID = "pladplaid"
        const val PLA_DPLA_TITLE = "pladplatitle"
    }


}