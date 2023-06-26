package ru.veider.infiniterecycler.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.veider.infiniterecycler.data.RepoDataBase
import ru.veider.infiniterecycler.domain.Reddit
import ru.veider.infiniterecycler.domain.usecases.toReddit

class MainViewModel : ViewModel() {
	private val repo = RepoDataBase()
	val data = mutableListOf<Reddit>()
	val pages = MutableLiveData<List<Reddit>>()
	var canAddNewData = true
	private var after: String? = null


	fun getNext(): LiveData<List<Reddit>> {
		viewModelScope.launch {
			val nextData = if (after == null)
				repo.getNext()
			else
				repo.getNext(after = after)
			after = nextData.data.after
			Log.d(">>>>>", "after: $after")
			data.add(nextData.toReddit())
			pages.postValue(data)
		}
		return pages
	}
}