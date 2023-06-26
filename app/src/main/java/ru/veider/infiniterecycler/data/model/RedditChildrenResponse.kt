package ru.veider.infiniterecycler.data.model

import com.google.gson.annotations.SerializedName

data class RedditChildrenResponse(
	@SerializedName("data") val data : RedditChildrenDataResponse
)
