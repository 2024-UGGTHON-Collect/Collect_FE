package com.uggthon.Collect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uggthon.Collect.databinding.ItemFrequentBinding

class FrequentAdapter(
    private val items: List<Pair<Int, String>>,
    private val onClick: (Pair<Int, String>) -> Unit
) : RecyclerView.Adapter<FrequentAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFrequentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<Int, String>) {
            binding.imageFrequent.setImageResource(item.first)
            binding.textFrequent.text = item.second

            // 클릭 이벤트 설정
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFrequentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
