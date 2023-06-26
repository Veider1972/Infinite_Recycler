package ru.veider.infiniterecycler.domain.usecases

import ru.veider.infiniterecycler.data.model.RedditChildrenDataResponse
import ru.veider.infiniterecycler.data.model.RedditChildrenResponse
import ru.veider.infiniterecycler.data.model.RedditDataResponse
import ru.veider.infiniterecycler.data.model.RedditResponse
import ru.veider.infiniterecycler.domain.Reddit
import ru.veider.infiniterecycler.domain.RedditChildren
import ru.veider.infiniterecycler.domain.RedditChildrenData
import ru.veider.infiniterecycler.domain.RedditData

fun RedditChildrenDataResponse.toRedditChildrenData()=
	RedditChildrenData(
		title = title,
		thumbnail = thumbnail
	)

fun RedditResponse.toReddit()=
	Reddit(
		data = data.toRedditData()
	)

fun RedditDataResponse.toRedditData()=
	RedditData(
		after = after,
		dist = dist,
		children = children.map { it.toRedditChildren() },
		before = before
	)

fun RedditChildrenResponse.toRedditChildren()=
	RedditChildren(
		data = data.toRedditChildrenData()
	)

