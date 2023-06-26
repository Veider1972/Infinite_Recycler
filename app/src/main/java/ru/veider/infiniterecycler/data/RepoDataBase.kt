package ru.veider.infiniterecycler.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepoDataBase {
	private val repoApi by lazy {
		Retrofit.Builder()
			.baseUrl("https://www.reddit.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(RepoApi::class.java)
	}

	suspend fun getNext(after:String? = null) = repoApi.getNext(after)
}