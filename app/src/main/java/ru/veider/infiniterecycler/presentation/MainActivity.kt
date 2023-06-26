package ru.veider.infiniterecycler.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.veider.infiniterecycler.R
import ru.veider.infiniterecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

	private val binding by viewBinding(ActivityMainBinding::bind)

	private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

	private val adapter by lazy {
		MainAdapter()
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding.recyclerList.adapter = adapter
		getData()
		onGetData()
		binding.recyclerList.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
			(binding.recyclerList.layoutManager as? LinearLayoutManager)?.findLastVisibleItemPosition()?.run{
				if (this > adapter.currentList.size-15)
					if (viewModel.canAddNewData){
						viewModel.getNext()
						viewModel.canAddNewData = false
					}

			}
		}
	}

	private fun getData() {
		viewModel.getNext()
	}

	private fun onGetData(){
		viewModel.pages.observe(this){
			val list = it.map { it.data.children }.map { it.map { it.data }}.flatten()
			adapter.submitList(list)
			viewModel.canAddNewData = true
		}
	}
}