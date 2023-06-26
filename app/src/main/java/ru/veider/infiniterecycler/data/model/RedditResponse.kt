package ru.veider.infiniterecycler.data.model

import com.google.gson.annotations.SerializedName

data class RedditResponse(
	@SerializedName("data") val data: RedditDataResponse
)
