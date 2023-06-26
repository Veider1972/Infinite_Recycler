package ru.veider.infiniterecycler.domain

data class RedditData(
	val after: String?,
	val dist: Int,
	val children: List<RedditChildren>,
	val before: String?
)
