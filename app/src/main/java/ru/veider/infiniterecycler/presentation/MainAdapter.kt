package ru.veider.infiniterecycler.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.veider.infiniterecycler.R
import ru.veider.infiniterecycler.databinding.ItemHotBinding
import ru.veider.infiniterecycler.domain.RedditChildrenData

class MainAdapter : ListAdapter<RedditChildrenData, MainAdapter.ViewHolder>(diffCallback) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		ViewHolder(ItemHotBinding.inflate(LayoutInflater.from(parent.context), parent, false))

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	inner class ViewHolder(private val binding: ItemHotBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(item: RedditChildrenData) {
			with(binding) {
				Glide.with(image.context).asBitmap().load(item.thumbnail).fitCenter().error(R.drawable.ic_ava_default).into(image)
				title.text = item.title
			}
		}


	}

	companion object {
		private val diffCallback = object : DiffUtil.ItemCallback<RedditChildrenData>() {
			override fun areItemsTheSame(oldItem: RedditChildrenData, newItem: RedditChildrenData): Boolean =
				(oldItem.title == newItem.title)

			override fun areContentsTheSame(oldItem: RedditChildrenData, newItem: RedditChildrenData): Boolean =
				oldItem.title == newItem.title &&
						oldItem.thumbnail == newItem.thumbnail
		}
	}
}