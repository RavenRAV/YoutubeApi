package com.example.youtubeparcer.data.remote

import com.example.youtubeparcer.data.remote.model.PlayListItems
import com.example.youtubeparcer.data.remote.model.PlayLists
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlayList(
        @Query("part") part : String,
        @Query("channelId") channelId : String,
        @Query("key") apiKey : String,
        @Query("maxResults") maxResults : Int
    ): Response<PlayLists>

    @GET("playlistItems")
    suspend fun getPlayListItems(
        @Query("part") part : String,
        @Query("playlistId") playlistId : String,
        @Query("key") apiKey : String
    ): Response<PlayListItems>
}