package com.example.youtubeparcer.ui.video


import android.net.ConnectivityManager
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.youtubeparcer.core.ui.BaseActivity
import com.example.youtubeparcer.core.utils.CheckInternetConnection
import com.example.youtubeparcer.databinding.ActivityVideoBinding
import com.example.youtubeparcer.ui.detail_playlist.DetailPlaylistActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


abstract class VideoActivity : BaseActivity<ActivityVideoBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityVideoBinding {
        return ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        CheckInternetConnection((getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedVideoInternet.constInternet.isVisible = !it
                binding.constContainerVideo.isVisible = it


                if (it == true) {
                    initObservers()
                }
            }

    }

    override fun initView() {
        val title = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_TITLE) as String
        val description = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_DESCRIPTION) as String
        val video = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_VIDEOID) as String

        binding.titleVideo.text = title
        binding.descriptionVideo.text = description

        lifecycle.addObserver(binding.playerVideo)

        binding.playerVideo.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video, 0f)
            }
        })
    }

    override fun initObservers() {

    }

    override fun initListener() {

    }

}