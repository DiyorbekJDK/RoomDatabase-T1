package com.diyorbek.roomdatabase_t1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.roomdatabase_t1.database.NumberEntity
import com.diyorbek.roomdatabase_t1.databinding.ItemLayoutBinding

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.NumberVIewHolder>() {
    lateinit var onClick: (NumberEntity) -> Unit
    private var filmList = mutableListOf<NumberEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberVIewHolder {
        return NumberVIewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NumberVIewHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int = filmList.size

    inner class NumberVIewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(numberEntity: NumberEntity) {
            binding.apply {
                textName.text = numberEntity.number

                itemView.setOnClickListener {
                    onClick(numberEntity)
                }
            }
        }
    }

    fun setList(filmEntity: MutableList<NumberEntity>) {
        this.filmList = filmEntity
        notifyDataSetChanged()
    }
}