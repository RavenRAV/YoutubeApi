package com.example.youtubeparcer.data.remote.model

data class PlayListItems(
    val items: List<ItemsPLI>
)

data class ItemsPLI(
    val id: String,
    val snippet: SnippetPLI
)

data class SnippetPLI(
    val title: String,
    val description : String,
    val thumbnails: ThumbnailsPLI,
    val resourceId : ResourceId
)

data class ThumbnailsPLI(
    val standard : StandardPLI
)

data class StandardPLI(
    val url : String
)

data class ResourceId(
    val videoId : String
)
