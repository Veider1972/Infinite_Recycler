package ru.veider.infiniterecycler.data.model

import com.google.gson.annotations.SerializedName

data class RedditDataResponse(
	@SerializedName("after") val after: String?,
	@SerializedName("dist") val dist: Int,
	@SerializedName("children") val children: List<RedditChildrenResponse>,
	@SerializedName("before") val before: String?
)
