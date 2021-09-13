package com.enty.partyinvetation.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.enty.partyinvetation.data.dto.GuestDto
import com.enty.partyinvetation.databinding.GuestItemBinding

class GuestListAdapter: ListAdapter<GuestDto, GuestListAdapter.GuestViewHolder>(Companion) {
    class GuestViewHolder(val binding: GuestItemBinding): RecyclerView.ViewHolder(binding.root)
    companion object : DiffUtil.ItemCallback<GuestDto>() {
        override fun areItemsTheSame(oldItem: GuestDto, newItem: GuestDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GuestDto, newItem: GuestDto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder =
        GuestViewHolder(GuestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val item = currentList[position]
        val binding = holder.binding
        val imgUrl = item.imgUrl
        Glide
            .with(holder.itemView.context)
            .load(imgUrl)
            .centerCrop()
            .into(holder.binding.ivPhoto);
        binding.textView.text = item.name
    }
}