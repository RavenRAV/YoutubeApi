package com.example.youtubeparcer.ui.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeparcer.databinding.ItemPlaylistsBinding
import com.example.youtubeparcer.data.remote.model.Items
import com.example.youtubeparcer.data.remote.model.PlayLists

class PlaylistsAdapter(
    val list: ArrayList<Items>,
    private val clickListener: (id: String, title: String) -> Unit):
    RecyclerView.Adapter<PlaylistsAdapter.PlayListsViewHolder>() {

    inner class PlayListsViewHolder(val binding: ItemPlaylistsBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.tvPlaylistName.text = items.snippet.title
            binding.tvPlaylistCounter.text = items.contentDetails.itemCount.toString() + " video series"
            binding.imgPlaylists.load(items.snippet.thumbnails.standard.url)
            itemView.setOnClickListener {
                clickListener(items.id, items.snippet.title)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}