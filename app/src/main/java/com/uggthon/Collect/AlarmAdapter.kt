package com.uggthon.Collect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uggthon.Collect.databinding.ItemContentBinding

class AlarmAdapter(private val alarms: List<Int>) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    // ViewHolder 클래스
    class AlarmViewHolder(val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.binding.itemImage.setImageResource(alarms[position])  // 아이템의 이미지를 바인딩
    }

    override fun getItemCount(): Int {
        return alarms.size
    }
}

