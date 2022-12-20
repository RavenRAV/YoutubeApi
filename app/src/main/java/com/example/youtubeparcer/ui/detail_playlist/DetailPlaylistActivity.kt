package com.example.youtubeparcer.ui.detail_playlist

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.example.youtubeparcer.core.ui.BaseActivity
import com.example.youtubeparcer.data.remote.model.ItemsPLI
import com.example.youtubeparcer.data.remote.model.PlayLists
import com.example.youtubeparcer.databinding.ActivityDetailPlaylistBinding
import com.example.youtubeparcer.ui.playlists.PlayListActivity
import com.example.youtubeparcer.ui.video.VideoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailPlaylistActivity : BaseActivity<ActivityDetailPlaylistBinding>() {

    private val viewModel: DetailPlayListViewModel by viewModel()

    lateinit var playLists: PlayLists
    lateinit var adapter: DetailPlaylistAdapter

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailPlaylistBinding {
        return ActivityDetailPlaylistBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {

    }

    override fun initView() {
        val title = intent.getSerializableExtra(PlayListActivity.PLA_DPLA_TITLE) as String
        binding.titleDpl.text = title

    }

    override fun initObservers() {
        val id = intent.getSerializableExtra(PlayListActivity.PLA_DPLA_ID) as String
        viewModel.getPlayListItems(id).observe(this){
            if (it != null){
               adapter = DetailPlaylistAdapter(it.items as ArrayList<ItemsPLI>, this::clickListener)
            }

            binding.recyclerDetailPlaylist.adapter = adapter
        }
    }

    private fun clickListener(videoId:String, title: String, description: String){
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra(DPLA_VA_VIDEOID, videoId)
        intent.putExtra(DPLA_VA_TITLE, title)
        intent.putExtra(DPLA_VA_DESCRIPTION, description)
        startActivity(intent)
    }

    override fun initListener() {

    }

    companion object{
        const val DPLA_VA_VIDEOID = "dplavavideoid"
        const val DPLA_VA_TITLE = "dplavatitle"
        const val DPLA_VA_DESCRIPTION = "dplavadescription"
    }

}