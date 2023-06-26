package ru.veider.infiniterecycler.data.model

import com.google.gson.annotations.SerializedName

data class RedditChildrenDataResponse(
	@SerializedName("title") val title : String,
	@SerializedName("thumbnail") val thumbnail : String
)
