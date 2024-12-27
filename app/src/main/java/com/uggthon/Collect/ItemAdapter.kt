package com.uggthon.Collect

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uggthon.Collect.databinding.ItemContentBinding

class ItemAdapter(
    private val items: List<Item>,
    private val categories: Map<Int, String> // 카테고리 이름 매핑
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, categoryName: String, onMemoChanged: (String) -> Unit) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemDescription.text = "${item.description} (${categoryName})"

            // 메모 입력 처리
            binding.itemDescription.setOnClickListener {
                // 입력을 받는 Dialog 등을 띄워 사용자로부터 메모를 입력받을 수 있습니다.
                onMemoChanged("새로운 메모")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val categoryName = categories[item.category] ?: "알 수 없음"
        holder.bind(item, categoryName) { newMemo ->
            item.description = newMemo // 새로운 메모로 업데이트
            notifyItemChanged(position) // 해당 아이템 갱신
        }
    }

    override fun getItemCount(): Int = items.size
}
