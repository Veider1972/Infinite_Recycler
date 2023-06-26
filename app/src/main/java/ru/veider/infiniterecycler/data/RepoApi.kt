package ru.veider.infiniterecycler.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.veider.infiniterecycler.data.model.RedditResponse

interface RepoApi {

	@GET("/r/aww/hot.json")
	suspend fun getNext(
		@Query("after") after: String? = null
	): RedditResponse

}