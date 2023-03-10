package com.example.youtubeparcer.ui.playlists

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import androidx.core.view.isVisible
import com.example.youtubeparcer.R
import com.example.youtubeparcer.core.ui.BaseActivity
import com.example.youtubeparcer.core.utils.CheckInternetConnection
import com.example.youtubeparcer.data.remote.model.Items
import com.example.youtubeparcer.databinding.ActivityPlaylistBinding
import com.example.youtubeparcer.ui.detail_playlist.DetailPlaylistActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListActivity : BaseActivity<ActivityPlaylistBinding>() {

    private val viewModel: PlayListViewModel by viewModel()
    lateinit var adapter: PlaylistsAdapter
    override fun checkInternet() {
        CheckInternetConnection((getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedInternet.constInternet.isVisible = !it
                binding.recyclerPlaylists.isVisible = it

                if (it == true) {
                    initObservers()
                }
            }
    }

    override fun initView() {
    }

    override fun initObservers() {

        viewModel.getPlayList().observe(this) {
            if (it != null) {
                adapter = PlaylistsAdapter(it.items as ArrayList<Items>, this::clickListener)
            }
            binding.recyclerPlaylists.adapter = adapter
        }


    }

    private fun clickListener(id: String, title: String, maxRes: String, desc : String) {
        val intent = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra(PLA_DPLA_ID, id)
        intent.putExtra(PLA_DPLA_TITLE, title)
        intent.putExtra(PLA_DPLA_MAXRES, maxRes)
        intent.putExtra(PLA_DPLA_DESCRIPTION, desc)
        startActivity(intent)
    }

    override fun initListener() {

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    companion object {
        const val PLA_DPLA_ID = "pladplaid"
        const val PLA_DPLA_TITLE = "pladplatitle"
        const val PLA_DPLA_MAXRES = "pladplamaxres"
        const val PLA_DPLA_DESCRIPTION = "pladpladesc"
    }


}